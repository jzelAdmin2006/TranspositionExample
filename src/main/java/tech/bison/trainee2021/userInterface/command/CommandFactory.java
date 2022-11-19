package tech.bison.trainee2021.userInterface.command;

import tech.bison.trainee2021.userInterface.command.encryptionHandling.DecryptCommand;
import tech.bison.trainee2021.userInterface.command.encryptionHandling.EncryptCommand;

public class CommandFactory {

  public static Command create(String command) {
    KnownCommand commandExpression = KnownCommand.translate(command);
    switch (commandExpression) {
      case DECRYPT:
        return new DecryptCommand();
      case ENCRYPT:
        return new EncryptCommand();
      case NOT_FOUND:
        return new CommandNotFoundCommand();
    }
    throw new UnsupportedOperationException(String.format("The command \"%s\" isn't implemented.", command));
  }
}
