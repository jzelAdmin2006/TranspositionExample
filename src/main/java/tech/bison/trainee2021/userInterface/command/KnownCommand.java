package tech.bison.trainee2021.userInterface.command;

public enum KnownCommand {
  ENCRYPT(KnownSpellings.ENCRYPT),
  DECRYPT(KnownSpellings.DECRYPT),
  NOT_FOUND("");

  private String spellingOfCommand;

  KnownCommand(String spellingOfCommand) {
    this.spellingOfCommand = spellingOfCommand;
  }

  static KnownCommand translate(String spellingOfCommand) {
    switch (spellingOfCommand) {
      case KnownSpellings.ENCRYPT:
        return ENCRYPT;
      case KnownSpellings.DECRYPT:
        return DECRYPT;
      default:
        return NOT_FOUND;
    }
  }

  public String getSpellingOfCommand() {
    return spellingOfCommand;
  }

  static final class KnownSpellings {
    static final String ENCRYPT = "/encrypt";
    static final String DECRYPT = "/decrypt";
  }
}
