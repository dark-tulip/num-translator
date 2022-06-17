package mappers;

import languages.Language;

import java.util.HashMap;

import static languages.Language.ENG;

public class EngBlockMapper implements IBlockMapper {

  private static final HashMap<Integer, String> unitToWordsEng = new HashMap<>() {{
    put(0, "zero");
    put(1, "one");
    put(2, "two");
    put(3, "three");
    put(4, "four");
    put(5, "five");
    put(6, "six");
    put(7, "seven");
    put(8, "eight");
    put(9, "nine");
  }};

  private static final HashMap<Integer, String> decimalsInWordsEng = new HashMap<>() {{
    put(1, "ten");
    put(2, "twenty");
    put(3, "thirty");
    put(4, "forty");
    put(5, "fifty");
    put(6, "sixty");
    put(7, "seventy");
    put(8, "eighty");
    put(9, "ninety");
  }};

  private static final HashMap<Language, String> hundredBlockNameMapper = new HashMap<>() {{
    put(ENG, " hundred");
  }};

  public String unitToWordsMapper(ThreeDigitsBlock num) {
    return unitToWordsEng.get(num.getUnits());
  }

  public String decimalToWordsMapper(ThreeDigitsBlock num) {
    return decimalsInWordsEng.get(num.getDecimals());
  }

  public String hundredToWordsMapper(ThreeDigitsBlock num) {
    return unitToWordsEng.get(num.getHundreds()) + hundredBlockNameMapper.get(num.getLanguage());
  }

}
