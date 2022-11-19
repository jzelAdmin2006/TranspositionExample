package tech.bison.trainee2021.userInterface.command;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class KnownCommandTest {
  @Test
  void encryptKnownCommandSpelling_translate_isCorrectCommand() {
    KnownCommand knownCommand = KnownCommand.translate(KnownCommand.KnownSpellings.ENCRYPT);

    String result = knownCommand.getSpellingOfCommand();

    assertThat(knownCommand).isEqualTo(KnownCommand.ENCRYPT);
    assertThat(result).isEqualTo(KnownCommand.KnownSpellings.ENCRYPT);
  }

  @Test
  void decryptKnownCommandSpelling_translate_isCorrectCommand() {
    KnownCommand knownCommand = KnownCommand.translate(KnownCommand.KnownSpellings.DECRYPT);

    String result = knownCommand.getSpellingOfCommand();

    assertThat(knownCommand).isEqualTo(KnownCommand.DECRYPT);
    assertThat(result).isEqualTo(KnownCommand.KnownSpellings.DECRYPT);
  }
}
