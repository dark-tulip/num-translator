package translator;

import languages.Language;
import mappers.ThreeDigitsBlock;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class NumTranslator {

  Language language;

  public NumTranslator(Language lang) {
    this.language = lang;
  }

  /**
   * Translate(convert) number to words
   */
  public String translate(long number) {

    if (number == 0) {
      return new ThreeDigitsBlock(0, this.language, 0).toWords();
    }

    String[] numberBlocks = splitByThreeDigits(number);

    List<String> result = new ArrayList<>();

    for (int i = 0; i < numberBlocks.length; i++) {
      int threeDigits = Integer.parseInt(numberBlocks[i]);

      if (threeDigits > 0) {
        ThreeDigitsBlock block = new ThreeDigitsBlock(threeDigits, language, numberBlocks.length - i - 1);
        result.add(block.toWords());
      }
    }
    return String.join(" ", result);

  }


  private String[] splitByThreeDigits(long number) {
    return NumberFormat
      .getNumberInstance(Locale.US) // в Америке число разделяется запятыми, а не пробелами как у нас
      .format(number)
      .replace(",", " ")
      .split(" ");
  }

}
