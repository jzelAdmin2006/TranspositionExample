package tech.bison.trainee2021.userInterface.command.encryptionHandling;

import tech.bison.trainee2021.userInterface.UserInterface;
import tech.bison.trainee2021.userInterface.command.Command;

public abstract class EncryptionHandlerCommand implements Command {
  String plainText = "";
  String key = null;
  String encryptionSpelling = null;

  protected String extractToBeProcessedText(String[] args) {
    for (int i = 2; i < args.length; i++) {
      plainText += args[i];

      if (!args[i].equals(String.valueOf(UserInterface.ARGS_DELIMITER))) {
        plainText += UserInterface.ARGS_DELIMITER;
      }
    }
    plainText = plainText.substring(0, plainText.length() - 1);
    return plainText;
  }
}
