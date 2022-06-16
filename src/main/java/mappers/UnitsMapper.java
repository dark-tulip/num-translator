package mappers;

import numberToWordsConverter.ThreeDigitsBlock;

import java.util.HashMap;

public class UnitsMapper {

    public static HashMap<Integer, String> unitToWordsKaz = new HashMap<>() {{
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
    public static HashMap<Integer, String> unitToWordsEng = new HashMap<>() {{
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
    public static HashMap<Integer, String[]> unitToWordsRus = new HashMap<>() {{
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


    public static String unitToWordsMapper(ThreeDigitsBlock num) {

        switch (num.getLanguage()) {
            case KAZ:
                return unitToWordsKaz.get(num.getUnits());

            case QAZ:
                return unitToWordsQaz.get(num.getUnits());

            case ENG:
                return unitToWordsEng.get(num.getUnits());

            default:
                // *1* - empty
                if (num.getDecimals() == 1) {
                    return " ";

                } else if (num.getBlockPosition() == 1 && (num.getUnits() == 1 || num.getUnits() == 2)) {
                    // женский род для блока тысячных, цифры одна, две --- единичный случай
                    return unitToWordsRus.get(num.getUnits())[1];

                }
                return unitToWordsRus.get(num.getUnits())[0];

        }
    }
}
