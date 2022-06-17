package mappers;

import languages.Language;

import java.util.HashMap;

import static languages.Language.*;

public class QazBlockMapper implements IBlockMapper {

  public static HashMap<Integer, String> unitToWordsQaz = new HashMap<>() {{
    put(0, "nól");
    put(1, "bir");
    put(2, "eki");
    put(3, "úsh");
    put(4, "tórt");
    put(5, "bes");
    put(6, "alty");
    put(7, "jeti");
    put(8, "segiz");
    put(9, "toǵyz");
  }};

  private static final HashMap<Integer, String> decimalsInWordsQaz = new HashMap<>() {{
    put(1, "on");
    put(2, "jıyrma");
    put(3, "otyz");
    put(4, "qyryq");
    put(5, "elý");
    put(6, "alpys");
    put(7, "jetpis");
    put(8, "seksen");
    put(9, "toqsan");
  }};

  private static final HashMap<Language, String> hundredBlockNameMapper = new HashMap<>() {{
    put(QAZ, " júz");
  }};


  public String unitToWordsMapper(ThreeDigitsBlock num) {
    return unitToWordsQaz.get(num.getUnits());
  }

  public String decimalToWordsMapper(ThreeDigitsBlock num) {
    return decimalsInWordsQaz.get(num.getDecimals());
  }

  public String hundredToWordsMapper(ThreeDigitsBlock num) {
    return unitToWordsQaz.get(num.getHundreds()) + hundredBlockNameMapper.get(QAZ);
  }


}
