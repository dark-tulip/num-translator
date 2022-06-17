# numbers-to-text-converter

#### !!! ONLY FOR INTEGER NUMBERS, IN RANGE [0; 999 999 999 999] !!!

### Перевод числа в текстовый вариант (прописью) для языков:

* Казахский 
* Русский
* Латинский Казахский 
* Английский

#### How to use:
```String translatedNumber = new NumTranslator(Language.RUS).translate(long number);```


#### Example of using:
```
assertEquals(new NumTranslator(KAZ).translate(123_123_120_100L), "бір жүз жиырма үш миллиард бір жүз жиырма үш миллион бір жүз жиырма мың бір жүз");
assertEquals(new NumTranslator(QAZ).translate(123_123_120_100L), "bir júz jıyrma úsh mıllıard bir júz jıyrma úsh mıllıon bir júz jıyrma myń bir júz");
assertEquals(new NumTranslator(ENG).translate(123_123_120_100L), "one hundred twenty three billion one hundred twenty three million one hundred twenty thousand one hundred");
assertEquals(new NumTranslator(RUS).translate(123_123_120_100L), "сто двадцать три миллиарда сто двадцать три миллиона сто двадцать тысяч сто");

assertEquals(new NumTranslator(RUS).translate(0), "ноль");
assertEquals(new NumTranslator(KAZ).translate(0), "нөл");
assertEquals(new NumTranslator(QAZ).translate(0), "nól");
assertEquals(new NumTranslator(ENG).translate(0), "zero");
```

#### Как добавить новый язык?
1. Добавить в ```enum```
2. Создать класс ```CurrentLangBlockMapper implements IBlockMapper``` - реализовать 3 метода для перевода цифр в слова (units, decimals, hundreds)
3. В классе BlockPosition добавить перевод Классов числа (тысяч, млн, млрд)
4. Затронуть init ```mapper``` в конструкторе ```ThreeDigitsBlock```