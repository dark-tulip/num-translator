package kz.greetgo.num_translator.translator;

import kz.greetgo.num_translator.languages.Language;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static kz.greetgo.num_translator.languages.Language.ENG;
import static kz.greetgo.num_translator.languages.Language.KAZ;
import static kz.greetgo.num_translator.languages.Language.QAZ;
import static kz.greetgo.num_translator.languages.Language.RUS;
import static org.assertj.core.api.Assertions.assertThat;

public class NumTranslatorTest {

  @SuppressWarnings("SpellCheckingInspection")
  @DataProvider
  private Object[][] translateDataProvider() {
    return new Object[][]{
      {KAZ, 123_123_120_100L, "бір жүз жиырма үш миллиард бір жүз жиырма үш миллион бір жүз жиырма мың бір жүз"},
      {QAZ, 123_123_120_100L, "bir júz jıyrma úsh mıllıard bir júz jıyrma úsh mıllıon bir júz jıyrma myń bir júz"},
      {ENG, 123_123_120_100L, "one hundred twenty three billion one hundred twenty three million one hundred twenty thousand one hundred"},
      {RUS, 123_123_120_100L, "сто двадцать три миллиарда сто двадцать три миллиона сто двадцать тысяч сто"},
      {RUS, 0, "ноль"},
      {KAZ, 0, "нөл"},
      {QAZ, 0, "nól"},
      {ENG, 0, "zero"},
      {ENG, 9, "nine"},
      {ENG, 10, "ten"},
      {ENG, 20, "twenty"},
      {ENG, 19, "nineteen"},
      {ENG, 12, "twelve"},
      {ENG, 111, "one hundred eleven"},
      {RUS, 999_999_999_999L, "девятьсот девяносто девять миллиардов девятьсот девяносто девять миллионов девятьсот девяносто девять тысяч девятьсот девяносто девять"},
      {KAZ, 999_999_999_999L, "тоғыз жүз тоқсан тоғыз миллиард тоғыз жүз тоқсан тоғыз миллион тоғыз жүз тоқсан тоғыз мың тоғыз жүз тоқсан тоғыз"},
      {QAZ, 999_999_999_999L, "toǵyz júz toqsan toǵyz mıllıard toǵyz júz toqsan toǵyz mıllıon toǵyz júz toqsan toǵyz myń toǵyz júz toqsan toǵyz"},
      {ENG, 999_999_999_999L, "nine hundred ninety nine billion nine hundred ninety nine million nine hundred ninety nine thousand nine hundred ninety nine"},
      {ENG, 100_000_003L, "one hundred million three"},
      {RUS, 111, "сто одиннадцать"},
      {RUS, 1111, "одна тысяча сто одиннадцать"},
    };
  }

  @Test(dataProvider = "translateDataProvider")
  public void translate(Language language, long number, String expectedStr) {

    final NumTranslator numTranslator = new NumTranslator(language);

    //
    //
    final String translatedStr = numTranslator.translate(number);
    //
    //

    assertThat(translatedStr).isEqualTo(expectedStr);

  }
}