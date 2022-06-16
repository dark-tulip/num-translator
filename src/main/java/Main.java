import languages.Language;
import translator.NumTranslator;

import java.util.Scanner;

import static languages.Language.*;
import static org.junit.Assert.assertEquals;

public class Main {

  public static void main(String[] args) {

    System.out.println(new NumTranslator(RUS).translate(100));

    System.out.println("=== STARTED PROGRAM ===");

    assertEquals(new NumTranslator(KAZ).translate(123_123_120_100L), "бір жүз жиырма үш миллиард бір жүз жиырма үш миллион бір жүз жиырма мың бір жүз");
    assertEquals(new NumTranslator(QAZ).translate(123_123_120_100L), "bir júz jıyrma úsh mıllıard bir júz jıyrma úsh mıllıon bir júz jıyrma myń bir júz");
    assertEquals(new NumTranslator(ENG).translate(123_123_120_100L), "one hundred twenty three billion one hundred twenty three million one hundred twenty thousand one hundred");
    assertEquals(new NumTranslator(RUS).translate(123_123_120_100L), "сто двадцать три миллиарда сто двадцать три миллиона сто двадцать тысяч сто");

    assertEquals(new NumTranslator(RUS).translate(0), "ноль");
    assertEquals(new NumTranslator(KAZ).translate(0), "нөл");
    assertEquals(new NumTranslator(QAZ).translate(0), "nól");
    assertEquals(new NumTranslator(ENG).translate(0), "zero");

    assertEquals(new NumTranslator(RUS).translate(999_999_999_999L), "девятьсот девяносто девять миллиардов девятьсот девяносто девять миллионов девятьсот девяносто девять тысяч девятьсот девяносто девять");
    assertEquals(new NumTranslator(KAZ).translate(999_999_999_999L), "тоғыз жүз тоқсан тоғыз миллиард тоғыз жүз тоқсан тоғыз миллион тоғыз жүз тоқсан тоғыз мың тоғыз жүз тоқсан тоғыз");
    assertEquals(new NumTranslator(QAZ).translate(999_999_999_999L), "toǵyz júz toqsan toǵyz mıllıard toǵyz júz toqsan toǵyz mıllıon toǵyz júz toqsan toǵyz myń toǵyz júz toqsan toǵyz");
    assertEquals(new NumTranslator(ENG).translate(999_999_999_999L), "nine hundred ninety nine billion nine hundred ninety nine million nine hundred ninety nine thousand nine hundred ninety nine");

    assertEquals(new NumTranslator(ENG).translate(100_000_003L), "one hundred million three");
    assertEquals(new NumTranslator(RUS).translate(111), "сто одиннадцать");
    assertEquals(new NumTranslator(RUS).translate(1111), "одна тысяча сто одиннадцать");

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

    Scanner sc = new Scanner(System.in);


    /* ------------------------------- INTERACTIVE MODE ------------------------------- */
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
