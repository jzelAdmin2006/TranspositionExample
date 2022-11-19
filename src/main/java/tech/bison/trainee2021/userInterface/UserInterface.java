package tech.bison.trainee2021.userInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import tech.bison.trainee2021.userInterface.command.CommandFactory;

public class UserInterface {
  public static final char ARGS_DELIMITER = ' ';

  private static final String EXIT = "/exit";
  private static final String NO_ENTRY = "";
  private boolean isRunning;

  public UserInterface() {
    isRunning = true;
  }

  public void run() {
    try (Scanner scanner = new Scanner(System.in)) {
      while (isRunning) {
        String input = scanner.nextLine();
        try {
          System.out.println(generateOutput(input));
        } catch (Exception exception) {
          exception.printStackTrace();
        }
      }
    }
  }

  public String generateOutput(String input) {
    if (input.equals(EXIT)) {
      return exit();
    }
    if (input.equals(NO_ENTRY)) {
      return "";
    }
    String[] splitInput = input.split(String.valueOf(ARGS_DELIMITER));
    String command = splitInput[0];
    String[] args = extractArgs(input, splitInput);
    return CommandFactory.create(command).execute(args);
  }

  private String exit() {
    isRunning = false;
    return "Terminating...";
  }

  private String[] extractArgs(String input, String[] splitInput) {
    List<String> inputParts = new ArrayList<>();
    Collections.addAll(inputParts, splitInput);
    inputParts.remove(0);
    if (input.charAt(input.length() - 1) == ARGS_DELIMITER) {
      inputParts.add(String.valueOf(ARGS_DELIMITER));
    }
    String[] args = inputParts.toArray(new String[0]);
    return args;
  }
}
