package tech.bison.trainee2021.encryption;

public class UnsupportedEncryption implements Encryption {
  public static final String MESSAGE = "This encryption isn't implemented.";

  @Override
  public String getPlainText() {
    throw new UnsupportedOperationException(MESSAGE);
  }

  @Override
  public String getCipher() {
    throw new UnsupportedOperationException(MESSAGE);
  }
}
