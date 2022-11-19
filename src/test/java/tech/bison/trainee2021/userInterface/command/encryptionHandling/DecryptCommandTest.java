package tech.bison.trainee2021.userInterface.command.encryptionHandling;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class DecryptCommandTest {
  @Test
  void newFenceDecryptCommand_execute_isCorrect() {
    String[] args = new String[5];
    args[0] = "FenceCryptography";
    args[1] = "2";
    args[2] = "sprsce";
    args[3] = "etue";
    args[4] = "erttx";
    DecryptCommand decrypt = new DecryptCommand();

    String result = decrypt.execute(args);

    assertThat(result).isEqualTo("super secret text");
  }

  @Test
  void newFenceDecryptCommand_executeWithDifferentArgs_isCorrect() {
    String[] args = new String[7];
    args[0] = "FenceCryptography";
    args[1] = "2";
    args[2] = "sprsce";
    args[3] = "etvrin2ue";
    args[4] = "erttx";
    args[5] = "eso";
    args[6] = " ";
    DecryptCommand decrypt = new DecryptCommand();

    String result = decrypt.execute(args);

    assertThat(result).isEqualTo("super secret text version 2");
  }

  @Test
  void newMatrixDecryptCommand_execute_isCorrect() {
    String[] args = new String[11];
    args[0] = "MatrixTransposition";
    args[1] = "6304918257";
    args[2] = "ertpr";
    args[3] = "rixih";
    args[4] = "edTiü";
    args[5] = "iiaselsdros";
    args[6] = "xeros";
    args[7] = "DwMnvetrans";
    args[8] = "Tt-tl";
    args[9] = "emisc";
    args[10] = " ";

    DecryptCommand decrypt = new DecryptCommand();

    String result = decrypt.execute(args);

    assertThat(result).isEqualTo("DieserTextwirdmitderMatrix-Transpositionverschlüssel");
  }

  @Test
  void newMatrixDecryptCommand_executeWithDifferentArgs_isCorrect() {
    String[] args = new String[10];
    args[0] = "MatrixTransposition";
    args[1] = "6304918257";
    args[2] = "ertprtrixih";
    args[3] = "edTiü";
    args[4] = "iiaselsdros";
    args[5] = "xeros";
    args[6] = "DwMnvetrans";
    args[7] = "Tt-tl";
    args[8] = "emisc";
    args[9] = " ";
    DecryptCommand decrypt = new DecryptCommand();

    String result = decrypt.execute(args);

    assertThat(result).isEqualTo("DieserTextwirdmitderMatrix-Transpositionverschlüsselt");
  }

  @Test
  void unknownDecryption_execute_throwsException() {
    String[] args = new String[3];

    args[0] = "asdfhiuwetihqeruit";
    args[1] = "6304918257";
    args[2] = "DieserTextwirdmitderMatrix-Transpositionverschlüsselt";
    DecryptCommand decrypt = new DecryptCommand();

    assertThatThrownBy(() -> decrypt.execute(args)).isInstanceOf(UnsupportedOperationException.class)
        .hasMessage("The encryption \"asdfhiuwetihqeruit\" isn't implemented.");
  }
}
