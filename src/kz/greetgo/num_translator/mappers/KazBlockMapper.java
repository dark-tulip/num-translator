package kz.greetgo.num_translator.mappers;

import kz.greetgo.num_translator.languages.Language;

import java.util.HashMap;


public class KazBlockMapper implements IBlockMapper {

  private static final HashMap<Integer, String> unitToWordsKaz = new HashMap<>() {{
    put(0, "нөл");
    put(1, "бір");
    put(2, "екі");
    put(3, "үш");
    put(4, "төрт");
    put(5, "бес");
    put(6, "алты");
    put(7, "жеті");
    put(8, "сегіз");
    put(9, "тоғыз");
  }};
  private static final HashMap<Integer, String> decimalsInWordsKaz = new HashMap<>() {{
    put(1, "он");
    put(2, "жиырма");
    put(3, "отыз");
    put(4, "қырық");
    put(5, "елу");
    put(6, "алпыс");
    put(7, "жетпіс");
    put(8, "сексен");
    put(9, "тоқсан");
  }};

  private static final HashMap<Language, String> hundredBlockNameMapper = new HashMap<>() {{
    put(Language.KAZ, " жүз");
  }};

  public String unitToWordsMapper(ThreeDigitsBlock num) {
    return unitToWordsKaz.get(num.getUnits());
  }

  public String decimalToWordsMapper(ThreeDigitsBlock num) {
    return decimalsInWordsKaz.get(num.getDecimals());
  }

  public String hundredToWordsMapper(ThreeDigitsBlock num) {
    return unitToWordsKaz.get(num.getHundreds()) + hundredBlockNameMapper.get(Language.KAZ);
  }

}
