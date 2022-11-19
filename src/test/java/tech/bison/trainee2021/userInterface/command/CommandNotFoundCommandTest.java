package tech.bison.trainee2021.userInterface.command;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CommandNotFoundCommandTest {
  @Test
  void newUnknownCommand_execute_showsCorrectMessage() {
    CommandNotFoundCommand commandNotFoundCommand = new CommandNotFoundCommand();

    String result = commandNotFoundCommand.execute(null);

    assertThat(result).isEqualTo("Invalid command!");
  }
}
