package tech.bison.trainee2021.userInterface.command.encryptionHandling;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class KnownEncryptionTest {
  @Test
  void knownEncryption_getSpellingOfMatrixTranspositionEncryption_isCorrect() {
    KnownEncryption knownEncryption = KnownEncryption.MATRIX_TRANSPOSITION;

    String result = knownEncryption.getSpellingOfEncryption();

    assertThat(result).isEqualTo(KnownEncryption.KnownSpellings.MATRIX_TRANSPOSITION);
  }

  @Test
  void knownEncryption_getSpellingOfFenceCryptographyEncryption_isCorrect() {
    KnownEncryption knownEncryption = KnownEncryption.FENCE_CRYPTOGRAPHY;

    String result = knownEncryption.getSpellingOfEncryption();

    assertThat(result).isEqualTo(KnownEncryption.KnownSpellings.FENCE_CRYPTOGRAPHY);
  }

  @Test
  void knownEncryption_getSpellingOfUnknownEncryption_isCorrect() {
    KnownEncryption knownEncryption = KnownEncryption.NOT_FOUND;

    String result = knownEncryption.getSpellingOfEncryption();

    assertThat(result).isEqualTo("");
  }
}
