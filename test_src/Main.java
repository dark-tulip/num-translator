import kz.greetgo.num_translator.languages.Language;
import kz.greetgo.num_translator.translator.NumTranslator;

import java.util.Scanner;

import static kz.greetgo.num_translator.languages.Language.*;
import static org.assertj.core.api.Assertions.assertThat;

public class Main {

  @SuppressWarnings("SpellCheckingInspection")
  public static void main(String[] args) {

    System.out.println("=== STARTED PROGRAM ===");

    assertThat(new NumTranslator(KAZ).translate(123_123_120_100L)).isEqualTo("бір жүз жиырма үш миллиард бір жүз жиырма үш миллион бір жүз жиырма мың бір жүз");

    /* *

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

    /* */

    System.out.println(new NumTranslator(RUS).translate(3000));
    System.out.println(new NumTranslator(RUS).translate(123_123_120_100L));
    System.out.println(new NumTranslator(RUS).translate(200));
    System.out.println(new NumTranslator(RUS).translate(22_000));
    System.out.println(new NumTranslator(RUS).translate(1001));
    System.out.println(new NumTranslator(RUS).translate(11001));
    System.out.println(new NumTranslator(RUS).translate(1_000_000_011));
    System.out.println(new NumTranslator(RUS).translate(9_000_900_099L));

    System.out.println(new NumTranslator(RUS).translate(9_000_900_099L));
    System.out.println(new NumTranslator(QAZ).translate(9_000_900_099L));
    System.out.println(new NumTranslator(KAZ).translate(9_000_900_099L));
    System.out.println(new NumTranslator(ENG).translate(9_000_900_099L));

    System.out.println(new NumTranslator(RUS).translate(9));
    System.out.println(new NumTranslator(RUS).translate(11));
    System.out.println(new NumTranslator(RUS).translate(111));
    System.out.println(new NumTranslator(RUS).translate(100));

    Scanner sc = new Scanner(System.in);


    /* ------------------------------- INTERACTIVE MODE ------------------------------- */
    //noinspection InfiniteLoopStatement
    while (true) {

      System.out.println("Input number: ");
      long number = Long.parseLong(sc.nextLine());

      System.out.println("Input language (RUS, KAZ, ENG, QAZ): ");
      String language = sc.nextLine();

      if (language.length() != 3 || number < 0 || number > 999_999_999L) {
        System.out.println("Invalid input.");
        continue;
      }

      Language lang = language.equalsIgnoreCase("kaz")
        ? KAZ
        : language.equalsIgnoreCase("rus")
        ? RUS
        : language.equalsIgnoreCase("eng")
        ? ENG : QAZ;

      System.out.println(new NumTranslator(lang).translate(number));

    }
  }
}
