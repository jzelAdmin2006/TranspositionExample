package tech.bison.trainee2021.userInterface.command;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import tech.bison.trainee2021.userInterface.command.encryptionHandling.DecryptCommand;
import tech.bison.trainee2021.userInterface.command.encryptionHandling.EncryptCommand;

public class CommandFactoryTest {
  @Test
  void createCommand_spellingEncrypt_isCorrectInstance() {
    Command result = CommandFactory.create(KnownCommand.KnownSpellings.ENCRYPT);

    assertThat(result).isInstanceOf(EncryptCommand.class);
  }

  @Test
  void createCommand_spellingDecrypt_isCorrectInstance() {
    Command result = CommandFactory.create(KnownCommand.KnownSpellings.DECRYPT);

    assertThat(result).isInstanceOf(DecryptCommand.class);
  }

  @Test
  void createCommand_unknownSpelling_isCorrectInstance() {
    Command result = CommandFactory.create("asdfh984wht43263i4oh63126");

    assertThat(result).isInstanceOf(CommandNotFoundCommand.class);
  }
}
