package tech.bison.trainee2021.userInterface.command;

public class CommandNotFoundCommand implements Command {

  @Override
  public String execute(String[] args) {
    return "Invalid command!";
  }
}
