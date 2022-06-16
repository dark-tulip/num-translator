package mappers;

import numberToWordsConverter.ThreeDigitsBlock;

import java.util.HashMap;

public class DecimalsMapper {

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

    public static String decimalToWordsMapper(ThreeDigitsBlock num) {

        switch (num.getLanguage()) {
            case KAZ:
                return decimalsInWordsKaz.get(num.getDecimals());

            case QAZ:
                return decimalsInWordsQaz.get(num.getDecimals());

            case ENG:
                return decimalsInWordsEng.get(num.getDecimals());

            default:
                if (num.getNumber() % 100 >= 11 && num.getNumber() % 100 <= 19){
                    return decimalsInWordsRusForTens.get(num.getUnits());
                }
                return decimalsInWordsRus.get(num.getDecimals());
        }
    }

}
