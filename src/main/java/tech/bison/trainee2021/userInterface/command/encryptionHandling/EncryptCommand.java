package tech.bison.trainee2021.userInterface.command.encryptionHandling;

import tech.bison.trainee2021.encryption.Encryption;
import tech.bison.trainee2021.encryption.FenceCryptography;
import tech.bison.trainee2021.encryption.MatrixTransposition;
import tech.bison.trainee2021.encryption.UnsupportedEncryption;

public class EncryptCommand extends EncryptionHandlerCommand {
  private String plainText = "";
  private String key = null;
  private String encryptionSpelling = null;

  @Override
  public String execute(String[] args) {
    encryptionSpelling = args[0];
    key = args[1];
    plainText = extractToBeProcessedText(args);
    return createEncryption().getCipher();
  }

  private Encryption createEncryption() {
    KnownEncryption encryptionExpression = KnownEncryption.translate(encryptionSpelling);
    Encryption encryption = new UnsupportedEncryption();
    switch (encryptionExpression) {
      case MATRIX_TRANSPOSITION:
        encryption = new MatrixTransposition(plainText, Long.parseLong(key));
        break;
      case FENCE_CRYPTOGRAPHY:
        encryption = new FenceCryptography(plainText, Integer.parseInt(key));
        break;
      case NOT_FOUND:
        throw new UnsupportedOperationException(
            String.format("The encryption \"%s\" isn't implemented.", encryptionSpelling));
    }
    return encryption;
  }
}
