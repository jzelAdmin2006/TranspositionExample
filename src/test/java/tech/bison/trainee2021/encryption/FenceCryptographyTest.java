package tech.bison.trainee2021.encryption;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class FenceCryptographyTest {
  @Test
  void newFenceCryptographyWithPlainText_getPlainText_isTheSame() {
    FenceCryptography fenceCryptography = new FenceCryptography("super secret text", 2);

    String result = fenceCryptography.getPlainText();

    assertThat(result).isEqualTo("super secret text");
  }

  @Test
  void newFenceCryptographyWithDifferentPlainText_getPlainText_isTheSame() {
    FenceCryptography fenceCryptography = new FenceCryptography("super secret text version 2", 2);

    String result = fenceCryptography.getPlainText();

    assertThat(result).isEqualTo("super secret text version 2");
  }

  @Test
  void newFenceCryptographyWithCipher_getCipher_isTheSame() {
    FenceCryptography fenceCryptography = new FenceCryptography(2, "encrypted stuff");

    String result = fenceCryptography.getCipher();

    assertThat(result).isEqualTo("encrypted stuff");
  }

  @Test
  void newFenceCryptographyWithDifferentCipher_getCipher_isTheSame() {
    FenceCryptography fenceCryptography = new FenceCryptography(2, "encrypted stuff version 2");

    String result = fenceCryptography.getCipher();

    assertThat(result).isEqualTo("encrypted stuff version 2");
  }

  @Test
  void newFenceCryptographyWithPlainText_getCipher_isCorrect() {
    FenceCryptography fenceCryptography = new FenceCryptography("super secret text", 2);

    String result = fenceCryptography.getCipher();

    assertThat(result).isEqualTo("sprsce etue erttx");
  }

  @Test
  void newFenceCryptographyWithDifferentPlainText_getCipher_isCorrect() {
    FenceCryptography fenceCryptography = new FenceCryptography("super secret text version 2", 2);

    String result = fenceCryptography.getCipher();

    assertThat(result).isEqualTo("sprsce etvrin2ue erttx eso ");
  }

  @Test
  void newFenceCryptographyWithCipher_getPlainText_isCorrect() {
    FenceCryptography fenceCryptography = new FenceCryptography(2, "sprsce etue erttx");

    String result = fenceCryptography.getPlainText();

    assertThat(result).isEqualTo("super secret text");
  }

  @Test
  void newFenceCryptographyWithDifferentCipher_getPlainText_isCorrect() {
    FenceCryptography fenceCryptography = new FenceCryptography(2, "sprsce etvrin2ue erttx eso ");

    String result = fenceCryptography.getPlainText();

    assertThat(result).isEqualTo("super secret text version 2");
  }

  @Test
  void newFenceCryptographyWithPlainTextAndDifferentKey_getCipher_isCorrect() {
    FenceCryptography fenceCryptography = new FenceCryptography("super secret text", 8);

    String result = fenceCryptography.getCipher();

    assertThat(result).isEqualTo("seutxp tetre rsce");
  }

  @Test
  void newFenceCryptographyWithDifferentPlainTextAndDifferentKey_getCipher_isCorrect() {
    FenceCryptography fenceCryptography = new FenceCryptography("super secret text version 2", 8);

    String result = fenceCryptography.getCipher();

    assertThat(result).isEqualTo("seutxp t2et  revn reoscries");
  }

  @Test
  void newFenceCryptographyWithCipherAndDifferentKey_getPlainText_isCorrect() {
    FenceCryptography fenceCryptography = new FenceCryptography(5, "sctuerxpseee ttr ");

    String result = fenceCryptography.getPlainText();

    assertThat(result).isEqualTo("super secret text");
  }

  @Test
  void newFenceCryptographyWithDifferentCipherAndDifferentKey_getPlainText_isCorrect() {
    FenceCryptography fenceCryptography = new FenceCryptography(5, "sctnuerx o pseevi2e ttesr r");

    String result = fenceCryptography.getPlainText();

    assertThat(result).isEqualTo("super secret text version 2");
  }

  @Test
  void newFenceCryptographyWithPlainTextAndInvalidKey_throwsException_isCorrectInstance() {
    assertThatThrownBy(() -> new FenceCryptography(1, "")).isInstanceOf(IllegalArgumentException.class)
        .hasMessage("The encryption key 1 is invalid. This encryption key must have a value of at least 2.");
  }

  @Test
  void newFenceCryptographyWithPlainTextAndDifferentInvalidKey_throwsException_isCorrectInstance() {
    assertThatThrownBy(() -> new FenceCryptography(0, "")).isInstanceOf(IllegalArgumentException.class)
        .hasMessage("The encryption key 0 is invalid. This encryption key must have a value of at least 2.");
  }

  @Test
  void newFenceCryptographyWithCipherAndInvalidKey_throwsException_isCorrectInstance() {
    assertThatThrownBy(() -> new FenceCryptography("", 1)).isInstanceOf(IllegalArgumentException.class)
        .hasMessage("The encryption key 1 is invalid. This encryption key must have a value of at least 2.");
  }

  @Test
  void newFenceCryptographyWithCipherAndDifferentInvalidKey_throwsException_isCorrectInstance() {
    assertThatThrownBy(() -> new FenceCryptography("", 0)).isInstanceOf(IllegalArgumentException.class)
        .hasMessage("The encryption key 0 is invalid. This encryption key must have a value of at least 2.");
  }
}
