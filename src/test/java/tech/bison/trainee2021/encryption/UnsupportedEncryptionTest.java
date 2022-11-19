package tech.bison.trainee2021.encryption;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class UnsupportedEncryptionTest {
  @Test
  void newUnsupportedEncryption_getPlainText_throwsException() {
    UnsupportedEncryption unsupportedEncryption = new UnsupportedEncryption();

    assertThatThrownBy(() -> unsupportedEncryption.getPlainText()).isInstanceOf(UnsupportedOperationException.class)
        .hasMessage(UnsupportedEncryption.MESSAGE);
  }

  @Test
  void newUnsupportedEncryption_getCipher_throwsException() {
    UnsupportedEncryption unsupportedEncryption = new UnsupportedEncryption();

    assertThatThrownBy(() -> unsupportedEncryption.getCipher()).isInstanceOf(UnsupportedOperationException.class)
        .hasMessage(UnsupportedEncryption.MESSAGE);
  }
}
