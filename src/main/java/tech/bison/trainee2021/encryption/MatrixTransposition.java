package tech.bison.trainee2021.encryption;

import java.util.Arrays;

public class MatrixTransposition implements Encryption {

  private static final char EMPY_MATRIX_PLACE_SUBSTITUTE = ' ';
  private static final String FIRST_MATRIX_COLUMN_INDEX = "0";
  private final String plainText;
  private final String cipher;
  private final String key;

  public MatrixTransposition(String plainText, long key) {
    validatePlainText(plainText);
    this.key = convertKey(key);
    this.plainText = plainText;
    this.cipher = calculateCipher();
  }

  private void validatePlainText(String plainText) {
    if (plainText.contains(String.valueOf(EMPY_MATRIX_PLACE_SUBSTITUTE))) {
      throw new IllegalArgumentException(String.format(
          "The plain text \"%s\" can't be encrypted since it contains a space which isn't allowed in the Matrix Transposition.",
          plainText));
    }
  }

  private String convertKey(long key) {
    String keyString = Long.toString(key);
    if (!keyString.contains(FIRST_MATRIX_COLUMN_INDEX)) {
      keyString = FIRST_MATRIX_COLUMN_INDEX + keyString;
    }
    validateKey(keyString);
    return keyString;
  }

  private void validateKey(String key) {
    char[] keyDigits = key.toCharArray();
    Arrays.sort(keyDigits);
    for (int i = 0; i < keyDigits.length; i++) {
      if (Character.getNumericValue(keyDigits[i]) != i) {
        throw new IllegalArgumentException(String.format(
            "The encryption key %s is invalid. All numbers between 0 and the largest one must be contained exactly once.",
            key));
      }
    }
  }

  private String calculateCipher() {
    char[][] matrix = createMatrix();
    return assembleCipher(matrix);
  }

  private char[][] createMatrix() {
    int keyLength = key.length();
    int plainTextLength = plainText.length();
    int numberOfRows = plainTextLength / keyLength + 1;
    char[][] matrix = createEmptyMatrix(keyLength, numberOfRows);
    for (int rowIndex = 0; rowIndex < matrix.length; rowIndex++) {
      for (int columnIndex = 0; columnIndex < keyLength
          && getPlainTextIndex(keyLength, rowIndex, columnIndex) < plainTextLength; columnIndex++) {
        matrix[rowIndex][columnIndex] = plainText.charAt(getPlainTextIndex(keyLength, rowIndex, columnIndex));
      }
    }
    return matrix;
  }

  private String assembleCipher(char[][] matrix) {
    String cipher = "";
    for (int columnIndex = 0; columnIndex < key.length(); columnIndex++) {
      for (int rowIndex = 0; rowIndex < matrix.length; rowIndex++) {
        char currentChar = matrix[rowIndex][key.indexOf(Integer.toString(columnIndex).charAt(0))];
        if (currentChar == Character.UNASSIGNED) {
          cipher += String.valueOf(EMPY_MATRIX_PLACE_SUBSTITUTE);
        } else {
          cipher += currentChar;
        }
      }
    }
    return cipher;
  }

  private char[][] createEmptyMatrix(int keyLength, int numberOfRows) {
    char[][] matrix = new char[numberOfRows][];
    for (int i = 0; i < matrix.length; i++) {
      matrix[i] = new char[keyLength];
    }
    return matrix;
  }

  int getPlainTextIndex(int keyLength, int rowIndex, int columnIndex) {
    return columnIndex + keyLength * rowIndex;
  }

  public MatrixTransposition(long key, String cipher) {
    this.key = convertKey(key);
    this.cipher = cipher;
    this.plainText = calculatePlainText();
  }

  private String calculatePlainText() {
    char[][] matrix = recreateMatrix();
    return assemblePlainText(key.length(), matrix);
  }

  private char[][] recreateMatrix() {
    int keyLength = key.length();
    char[][] matrix = createEmptyMatrix(keyLength, cipher.length() / keyLength);
    for (int columnIndex = 0; columnIndex < key.length(); columnIndex++) {
      for (int rowIndex = 0; rowIndex < matrix.length; rowIndex++) {
        char currentChar = cipher.charAt(rowIndex + columnIndex * matrix.length);
        int tmp = key.indexOf(Integer.toString(columnIndex).charAt(0));
        matrix[rowIndex][tmp] = currentChar;
      }
    }
    return matrix;
  }

  private String assemblePlainText(int keyLength, char[][] matrix) {
    String plainText = "";
    for (int rowIndex = 0; rowIndex < matrix.length; rowIndex++) {
      for (int columnIndex = 0; columnIndex < keyLength; columnIndex++) {
        char currentChar = matrix[rowIndex][columnIndex];
        if (currentChar != EMPY_MATRIX_PLACE_SUBSTITUTE) {
          plainText += currentChar;
        }
      }
    }
    return plainText;
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
