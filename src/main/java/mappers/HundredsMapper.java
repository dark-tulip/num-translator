package mappers;


import languages.Language;

import java.util.HashMap;

import static languages.Language.*;
import static mappers.UnitsMapper.*;

public class HundredsMapper {

    private static final HashMap<Language, String> hundredBlockNameMapper = new HashMap<>() {{
        put(KAZ, " жүз");
        put(QAZ, " júz");
        put(ENG, " hundred");
    }};

    private static final String[] hundredBlockNameMapperRus = new String[]{"", "сто", "двести", "триста", "четыреста", "пятьсот", "шестьсот", "семьсот", "восемьсот", "девятьсот"};

    public static String hundredsToWordsMapper(ThreeDigitsBlock num) {

        switch (num.getLanguage()) {
            case KAZ:
                return unitToWordsKaz.get(num.getHundreds()) + hundredBlockNameMapper.get(num.getLanguage());

            case QAZ:
                return unitToWordsQaz.get(num.getHundreds()) + hundredBlockNameMapper.get(num.getLanguage());

            case ENG:
                return unitToWordsEng.get(num.getHundreds()) + hundredBlockNameMapper.get(num.getLanguage());

            default:
                return hundredBlockNameMapperRus[num.getHundreds()];

        }
    }
}
