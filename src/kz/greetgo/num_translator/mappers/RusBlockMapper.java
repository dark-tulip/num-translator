package kz.greetgo.num_translator.mappers;

import java.util.HashMap;

public class RusBlockMapper implements IBlockMapper {

  private static final HashMap<Integer, String[]> unitToWordsRus = new HashMap<>() {{
    /* index 0 - мужской род
     * index 1 - женский род
     * */
    put(0, new String[]{"ноль"});
    put(1, new String[]{"один", "одна"});
    put(2, new String[]{"два", "две"});
    put(3, new String[]{"три"});
    put(4, new String[]{"четыре"});
    put(5, new String[]{"пять"});
    put(6, new String[]{"шесть"});
    put(7, new String[]{"семь"});
    put(8, new String[]{"восемь"});
    put(9, new String[]{"девять"});
  }};

  private static final HashMap<Integer, String> decimalsInWordsRus = new HashMap<>() {{
    put(1, "десять");
    put(2, "двадцать");
    put(3, "тридцать");
    put(4, "сорок");
    put(5, "пятьдесят");
    put(6, "шестьдесят");
    put(7, "семьдесят");
    put(8, "восемьдесят");
    put(9, "девяносто");
  }};

  private static final HashMap<Integer, String> decimalsInWordsRusForTens = new HashMap<>() {{
    put(1, "одиннадцать");
    put(2, "двенадцать");
    put(3, "тринадцать");
    put(4, "четырнадцать");
    put(5, "пятнадцать");
    put(6, "шестнадцать");
    put(7, "семнадцать");
    put(8, "восемнадцать");
    put(9, "девятнадцать");
  }};

  private static final String[] hundredBlockNameMapperRus = new String[]{"", "сто", "двести", "триста", "четыреста", "пятьсот", "шестьсот", "семьсот", "восемьсот", "девятьсот"};


  public String unitToWordsMapper(ThreeDigitsBlock num) {
    // *1* - empty
    if (num.getDecimals() == 1) {
      return " ";
    } else if (num.getBlockPosition() == 1 && (num.getUnits() == 1 || num.getUnits() == 2)) {
      // женский род для блока тысячных, цифры одна, две --- единичный случай
      return unitToWordsRus.get(num.getUnits())[1];
    }
    return unitToWordsRus.get(num.getUnits())[0];
  }

  public String decimalToWordsMapper(ThreeDigitsBlock num) {
    if (num.getNumber() % 100 >= 11 && num.getNumber() % 100 <= 19) {
      return decimalsInWordsRusForTens.get(num.getUnits());
    }
    return decimalsInWordsRus.get(num.getDecimals());
  }

  public String hundredToWordsMapper(ThreeDigitsBlock num) {
    return hundredBlockNameMapperRus[num.getHundreds()];
  }

}
