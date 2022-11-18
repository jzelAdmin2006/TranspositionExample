package tech.bison.trainee2021.encryption;

public class FenceCryptography implements Encryption {

  private final String plainText;
  private final String cipher;
  private final int key;

  public FenceCryptography(String plainText, int key) {
    validateKey(key);
    this.key = key;
    this.plainText = plainText;
    this.cipher = calculateCipher();
  }

  public void validateKey(int key) {
    if (key <= 1) {
      throw new IllegalArgumentException(
          String.format("The encryption key %s is invalid. This encryption key must have a value of at least 2.", key));
    }
  }

  private String calculateCipher() {
    char[][] fence = createFence(plainText);
    return assembleCipher(fence);
  }

  private String assembleCipher(char[][] fence) {
    String cipher = "";
    for (char[] row : fence) {
      for (char character : row) {
        if (character != Character.UNASSIGNED) {
          cipher += character;
        }
      }
    }
    return cipher;
  }

  private char[][] createFence(String text) {
    char[][] fence = createEmptyFence(text);
    int rowIndex = 0;
    for (int charIndex = 0; charIndex < text.length(); charIndex++) {
      fence[rowIndex][charIndex] = text.charAt(charIndex);
      if (fencePlankIsFacingDown(rowIndex, charIndex, fence)) {
        rowIndex++;
      } else {
        rowIndex--;
      }
    }
    return fence;
  }

  boolean fencePlankIsFacingDown(int rowIndex, int charIndex, char[][] fence) {
    return rowIndex == 0 || fence[rowIndex - 1][charIndex - 1] != Character.UNASSIGNED && rowIndex + 1 < key;
  }

  private char[][] createEmptyFence(String text) {
    char[][] fence = new char[key][];
    for (int i = 0; i < fence.length; i++) {
      fence[i] = new char[text.length()];
    }
    return fence;
  }

  public FenceCryptography(int key, String cipher) {
    validateKey(key);
    this.key = key;
    this.cipher = cipher;
    plainText = calculatePlainText();
  }

  private String assemblePlainText(char[][] fence) {
    String plainText = "";
    int rowIndex = 0;
    for (int charIndex = 0; charIndex < cipher.length(); charIndex++) {
      plainText += fence[rowIndex][charIndex];
      if (fencePlankIsFacingDown(rowIndex, charIndex, fence)) {
        rowIndex++;
      } else {
        rowIndex--;
      }
    }
    return plainText;
  }

  private String calculatePlainText() {
    char[][] fence = createFence(cipher);
    int cipherCharIndex = 0;
    for (int rowIndex = 0; rowIndex < key; rowIndex++) {
      for (int charIndex = 0; charIndex < cipher.length(); charIndex++) {
        if (fence[rowIndex][charIndex] != Character.UNASSIGNED) {
          fence[rowIndex][charIndex] = cipher.charAt(cipherCharIndex++);
        }
      }
    }
    return assemblePlainText(fence);
  }

  @Override
  public String getPlainText() {
    return plainText;
  }

  @Override
  public String getCipher() {
    return cipher;
  }
}
