package tech.bison.trainee2021.userInterface.command.encryptionHandling;

public enum KnownEncryption {

  MATRIX_TRANSPOSITION(KnownSpellings.MATRIX_TRANSPOSITION),
  FENCE_CRYPTOGRAPHY(KnownSpellings.FENCE_CRYPTOGRAPHY),
  NOT_FOUND("");

  private String spellingOfEncryption;

  KnownEncryption(String spellingOfEncryption) {
    this.spellingOfEncryption = spellingOfEncryption;
  }

  static KnownEncryption translate(String spellingOfEncryption) {
    switch (spellingOfEncryption) {
      case KnownSpellings.MATRIX_TRANSPOSITION:
        return MATRIX_TRANSPOSITION;
      case KnownSpellings.FENCE_CRYPTOGRAPHY:
        return FENCE_CRYPTOGRAPHY;
      default:
        return NOT_FOUND;
    }
  }

  public String getSpellingOfEncryption() {
    return spellingOfEncryption;
  }

  public static class KnownSpellings {
    public static final String MATRIX_TRANSPOSITION = "MatrixTransposition";
    public static final String FENCE_CRYPTOGRAPHY = "FenceCryptography";
  }
}
