package tech.bison.trainee2021.userInterface;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class UserInterfaceTest {
  @Test
  void newUserInterface_generateOutputExit_outputIsCorrect() {
    UserInterface userInterface = new UserInterface();

    String result = userInterface.generateOutput("/exit");

    assertThat(result).isEqualTo("Terminating...");
  }

  @Test
  void newUserInterface_generateOutputNoEntry_outputIsCorrect() {
    UserInterface userInterface = new UserInterface();

    String result = userInterface.generateOutput("");

    assertThat(result).isEqualTo("");
  }

  @Test
  void newUserInterface_generateOutputEncryptFence_outputIsCorrect() {
    UserInterface userInterface = new UserInterface();

    String result = userInterface.generateOutput("/encrypt FenceCryptography 3 asdfqwert");

    assertThat(result).isEqualTo("aqtsfwrde");
  }

  @Test
  void newUserInterface_generateOutputDecryptFence_outputIsCorrect() {
    UserInterface userInterface = new UserInterface();

    String result = userInterface.generateOutput("/decrypt FenceCryptography 3 aqtsfwrde");

    assertThat(result).isEqualTo("asdfqwert");
  }

  @Test
  void newUserInterface_generateOutputEncryptFenceSpaceAtEnd_outputIsCorrect() {
    UserInterface userInterface = new UserInterface();

    String result = userInterface.generateOutput("/encrypt FenceCryptography 3 asdfqwert ");

    assertThat(result).isEqualTo("aqtsfwr de");
  }

  @Test
  void newUserInterface_generateOutputDecryptFenceSpaceAtEnd_outputIsCorrect() {
    UserInterface userInterface = new UserInterface();

    String result = userInterface.generateOutput("/decrypt FenceCryptography 3 aqtsfwr de");

    assertThat(result).isEqualTo("asdfqwert ");
  }
}
