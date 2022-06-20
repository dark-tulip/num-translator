package mappers;

import languages.Language;

import java.util.HashMap;


public class BlockPosition {

  final static HashMap<Integer, String>   thousandsDegreesKaz = new HashMap<>() {{
    put(0, "");
    put(1, "мың");
    put(2, "миллион");
    put(3, "миллиард");
    put(4, "триллион");
  }};
  final static HashMap<Integer, String>   thousandsDegreesQaz = new HashMap<>() {{
    put(0, "");
    put(1, "myń");
    put(2, "mıllıon");
    put(3, "mıllıard");
    put(4, "trıllıon");
  }};
  final static HashMap<Integer, String>   thousandsDegreesEng = new HashMap<>() {{
    put(0, "");
    put(1, "thousand");
    put(2, "million");
    put(3, "billion");
    put(4, "trillion");
  }};
  final static HashMap<Integer, String[]> thousandsDegreesRus = new HashMap<>() {{
        /*
         Смотрим на окончание третьей цифры в блоке из трех чисел
         **1 тысяча
         **[2-4] тысячи
         **[5-9], *[10-19], **0, *00 тысяч
         * */
    put(0, new String[]{""});
    put(1, new String[]{"тысяча", "тысячи", "тысяч"});
    put(2, new String[]{"миллион", "миллиона", "миллионов"});
    put(3, new String[]{"миллиард", "миллиарда", "миллиардов"});
    put(4, new String[]{"триллион", "триллиона", "триллионов"});
  }};

  int      posNumber;
  int      threeDigits;
  Language language;

  public BlockPosition(int posNumber, Language language, int threeDigits) {
    this.posNumber   = posNumber;
    this.language    = language;
    this.threeDigits = threeDigits;
  }

  public int getBlockPosition() {
    return this.posNumber;
  }

  public String getBlockName() {

    switch (this.language) {
      case KAZ:
        return thousandsDegreesKaz.get(this.posNumber);

      case QAZ:
        return thousandsDegreesQaz.get(this.posNumber);

      case ENG:
        return thousandsDegreesEng.get(this.posNumber);

      default:
        int lastTwoDigit = threeDigits % 100;
        int lastDigit = threeDigits % 10;

        /* Вот он, Великий, Могучий Русский язык */
        if (lastDigit == 1 && lastTwoDigit != 11 || this.posNumber == 0) {
          // *[2-9]1 тысяча, или позиция числа нулевая (блок ДО тысячных)
          return thousandsDegreesRus.get(this.posNumber)[0];

        } else if (lastDigit >= 2 && lastDigit <= 4 && lastTwoDigit / 10 != 1) {
          // *[2-9][2-4] тысячи
          return thousandsDegreesRus.get(this.posNumber)[1];

        } else {
          // **[5-9], *[10-19], **0, *00 тысяч
          return thousandsDegreesRus.get(this.posNumber)[2];

        }
    }
  }

}
