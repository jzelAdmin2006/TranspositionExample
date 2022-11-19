package tech.bison.trainee2021.userInterface.command.encryptionHandling;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class EncryptCommandTest {
  @Test
  void newFenceEncryptCommand_execute_isCorrect() {
    String[] args = new String[5];
    args[0] = "FenceCryptography";
    args[1] = "2";
    args[2] = "super";
    args[3] = "secret";
    args[4] = "text";
    EncryptCommand encrypt = new EncryptCommand();

    String result = encrypt.execute(args);

    assertThat(result).isEqualTo("sprsce etue erttx");
  }

  @Test
  void newFenceEncryptCommand_executeWithDifferentArgs_isCorrect() {
    String[] args = new String[7];
    args[0] = "FenceCryptography";
    args[1] = "2";
    args[2] = "super";
    args[3] = "secret";
    args[4] = "text";
    args[5] = "version";
    args[6] = "2";
    EncryptCommand encrypt = new EncryptCommand();

    String result = encrypt.execute(args);

    assertThat(result).isEqualTo("sprsce etvrin2ue erttx eso ");
  }

  @Test
  void newMatrixEncryptCommand_execute_isCorrect() {
    String[] args = new String[3];
    args[0] = "MatrixTransposition";
    args[1] = "6304918257";
    args[2] = "DieserTextwirdmitderMatrix-Transpositionverschlüssel";
    EncryptCommand encrypt = new EncryptCommand();

    String result = encrypt.execute(args);

    assertThat(result).isEqualTo("ertpr rixih edTiü iiaselsdros xeros DwMnvetrans Tt-tl emisc ");
  }

  @Test
  void newMatrixEncryptCommand_executeWithDifferentArgs_isCorrect() {
    String[] args = new String[3];
    args[0] = "MatrixTransposition";
    args[1] = "6304918257";
    args[2] = "DieserTextwirdmitderMatrix-Transpositionverschlüsselt";
    EncryptCommand encrypt = new EncryptCommand();

    String result = encrypt.execute(args);

    assertThat(result).isEqualTo("ertprtrixih edTiü iiaselsdros xeros DwMnvetrans Tt-tl emisc ");
  }

  @Test
  void unknownEncryption_execute_throwsException() {
    String[] args = new String[3];

    args[0] = "asdfhiuwetihqeruit";
    args[1] = "6304918257";
    args[2] = "DieserTextwirdmitderMatrix-Transpositionverschlüsselt";
    EncryptCommand encrypt = new EncryptCommand();

    assertThatThrownBy(() -> encrypt.execute(args)).isInstanceOf(UnsupportedOperationException.class)
        .hasMessage("The encryption \"asdfhiuwetihqeruit\" isn't implemented.");
  }
}
