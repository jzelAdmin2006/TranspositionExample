package tech.bison.trainee2021.encryption;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class MatrixTranspositionTest {
  @Test
  void newMatrixTranspositionWithPlainText_getPlainText_isTheSame() {
    MatrixTransposition matrixTransposition = new MatrixTransposition("supersecrettext", 1234);

    String result = matrixTransposition.getPlainText();

    assertThat(result).isEqualTo("supersecrettext");
  }

  @Test
  void newMatrixTranspositionWithDifferentPlainText_getPlainText_isTheSame() {
    MatrixTransposition matrixTransposition = new MatrixTransposition("supersecrettextversion2", 1234);

    String result = matrixTransposition.getPlainText();

    assertThat(result).isEqualTo("supersecrettextversion2");
  }

  @Test
  void newMatrixTranspositionWithCipher_getCipher_isTheSame() {
    MatrixTransposition matrixTransposition = new MatrixTransposition(1234, "encrypted stuff");

    String result = matrixTransposition.getCipher();

    assertThat(result).isEqualTo("encrypted stuff");
  }

  @Test
  void newMatrixTranspositionWithDifferentCipher_getCipher_isTheSame() {
    MatrixTransposition matrixTransposition = new MatrixTransposition(1234, "encrypted stuff version 2");

    String result = matrixTransposition.getCipher();

    assertThat(result).isEqualTo("encrypted stuff version 2");
  }

  @Test
  void newMatrixTranspositionWithPlainTextAndDifferentKey_getCipher_isCorrect() {
    MatrixTransposition matrixTransposition = new MatrixTransposition(
        "DieserTextwirdmitderMatrix-Transpositionverschlüsselt", 630418257l);

    String result = matrixTransposition.getCipher();

    assertThat(result).isEqualTo("eiMaoüedtsvsTiiorliwrrilsrannsetxsstDteTthxd-ic rmrpee");
  }

  @Test
  void newMatrixTranspositionWithDifferentPlainTextAndDifferentKey_getCipher_isCorrect() {
    MatrixTransposition matrixTransposition = new MatrixTransposition(
        "DieesrTextwimrditderMaitrx-Transspoitionvecrshlüssel", 6390418257l);

    String result = matrixTransposition.getCipher();

    assertThat(result).isEqualTo("ertpr rixih edTiü iiaselsdros xeros DwMnvetrans Tt-tl emisc ");
  }

  @Test
  void newMatrixTranspositionWithCipherAndDifferentKey_getPlainText_isCorrect() {
    MatrixTransposition matrixTransposition = new MatrixTransposition(630418257l,
        "eiMaoüedtsvsTiiorliwrrilsrannsetxsstDteTthxd-ic rmrpee");

    String result = matrixTransposition.getPlainText();

    assertThat(result).isEqualTo("DieserTextwirdmitderMatrix-Transpositionverschlüsselt");
  }

  @Test
  void newMatrixTranspositionWithDifferentCipherAndDifferentKey_getPlainText_isCorrect() {
    MatrixTransposition matrixTransposition = new MatrixTransposition(6390418257l,
        "ertpr rixih edTiü iiaselsdros xeros DwMnvetrans Tt-tl emisc ");

    String result = matrixTransposition.getPlainText();

    assertThat(result).isEqualTo("DieesrTextwimrditderMaitrx-Transspoitionvecrshlüssel");
  }

  @Test
  void newMatrixTranspositionWithPlainText_getCipher_isCorrect() {
    MatrixTransposition matrixTransposition = new MatrixTransposition(
        "DieserTextwirdmitderMatrix-Transpositionverschlüsselt", 6304918257l);

    String result = matrixTransposition.getCipher();

    assertThat(result).isEqualTo("ertprtrixih edTiü iiaselsdros xeros DwMnvetrans Tt-tl emisc ");
  }

  @Test
  void newMatrixTranspositionWithDifferentPlainText_getCipher_isCorrect() {
    MatrixTransposition matrixTransposition = new MatrixTransposition(
        "DieserTextwirdmitderMatrix-Transpositionverschlüssel", 6304918257l);

    String result = matrixTransposition.getCipher();

    assertThat(result).isEqualTo("ertpr rixih edTiü iiaselsdros xeros DwMnvetrans Tt-tl emisc ");
  }

  @Test
  void newMatrixTranspositionWithCipher_getPlainText_isCorrect() {
    MatrixTransposition matrixTransposition = new MatrixTransposition(6304918257l,
        "ertprtrixih edTiü iiaselsdros xeros DwMnvetrans Tt-tl emisc ");

    String result = matrixTransposition.getPlainText();

    assertThat(result).isEqualTo("DieserTextwirdmitderMatrix-Transpositionverschlüsselt");
  }

  @Test
  void newMatrixTranspositionWithDifferentCipher_getPlainText_isCorrect() {
    MatrixTransposition matrixTransposition = new MatrixTransposition(6304918257l,
        "ertpr rixih edTiü iiaselsdros xeros DwMnvetrans Tt-tl emisc ");

    String result = matrixTransposition.getPlainText();

    assertThat(result).isEqualTo("DieserTextwirdmitderMatrix-Transpositionverschlüssel");
  }

  @Test
  void newMatrixTranspositionWithInvalidPlainText_throwsException_isCorrectInstance() {
    assertThatThrownBy(() -> new MatrixTransposition("asdf qwert", 0213)).isInstanceOf(IllegalArgumentException.class)
        .hasMessage(
            "The plain text \"asdf qwert\" can't be encrypted since it contains a space which isn't allowed in the Matrix Transposition.");
  }

  @Test
  void newMatrixTranspositionWithDifferentInvalidPlainText_throwsException_isCorrectInstance() {
    assertThatThrownBy(() -> new MatrixTransposition("asdfqwsadf ert", 0213))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage(
            "The plain text \"asdfqwsadf ert\" can't be encrypted since it contains a space which isn't allowed in the Matrix Transposition.");
  }

  @Test
  void newMatrixTranspositionWithPlainTextAndInvalidKey_throwsException_isCorrectInstance() {
    assertThatThrownBy(() -> new MatrixTransposition("asdfqwert", 230)).isInstanceOf(IllegalArgumentException.class)
        .hasMessage(
            "The encryption key 230 is invalid. All numbers between 0 and the largest one must be contained exactly once.");
  }

  @Test
  void newMatrixTranspositionWithPlainTextAndDifferentInvalidKey_throwsException_isCorrectInstance() {
    assertThatThrownBy(() -> new MatrixTransposition("asdfqwert", 233450)).isInstanceOf(IllegalArgumentException.class)
        .hasMessage(
            "The encryption key 233450 is invalid. All numbers between 0 and the largest one must be contained exactly once.");
  }

  @Test
  void newMatrixTranspositionWithCipherAndInvalidKey_throwsException_isCorrectInstance() {
    assertThatThrownBy(() -> new MatrixTransposition(230, "asdfqwert")).isInstanceOf(IllegalArgumentException.class)
        .hasMessage(
            "The encryption key 230 is invalid. All numbers between 0 and the largest one must be contained exactly once.");
  }

  @Test
  void newMatrixTranspositionWithCipherAndDifferentInvalidKey_throwsException_isCorrectInstance() {
    assertThatThrownBy(() -> new MatrixTransposition(233450, "asdfqwert")).isInstanceOf(IllegalArgumentException.class)
        .hasMessage(
            "The encryption key 233450 is invalid. All numbers between 0 and the largest one must be contained exactly once.");
  }
}
