# numbers-to-text-converter

#### !!! ONLY FOR INTEGER NUMBERS, IN RANGE [0; 999 999 999 999] !!!

### Перевод числа в текстовый вариант (прописью) для языков:

* Казахский 
* Русский
* Латинский Казахский 
* Английский

#### Call the function:
Call the instance of class ``` Three digits block manager ``` by function ``` toWords() ```


#### Example of using:
```
assertEquals(new ThreeDigitsManager(0, RUS).toWords(), "ноль");
assertEquals(new ThreeDigitsManager(0, KAZ).toWords(), "нөл");
assertEquals(new ThreeDigitsManager(0, QAZ).toWords(), "nól");
assertEquals(new ThreeDigitsManager(0, ENG).toWords(), "zero");
        
assertEquals(new ThreeDigitsManager(999_999_999_999L, RUS).toWords(), "девятьсот девяносто девять миллиардов девятьсот девяносто девять миллионов девятьсот девяносто девять тысяч девятьсот девяносто девять");
assertEquals(new ThreeDigitsManager(999_999_999_999L, KAZ).toWords(), "тоғыз жүз тоқсан тоғыз миллиард тоғыз жүз тоқсан тоғыз миллион тоғыз жүз тоқсан тоғыз мың тоғыз жүз тоқсан тоғыз");
assertEquals(new ThreeDigitsManager(999_999_999_999L, QAZ).toWords(), "toǵyz júz toqsan toǵyz mıllıard toǵyz júz toqsan toǵyz mıllıon toǵyz júz toqsan toǵyz myń toǵyz júz toqsan toǵyz");
assertEquals(new ThreeDigitsManager(999_999_999_999L, ENG).toWords(), "nine hundred ninety nine billion nine hundred ninety nine million nine hundred ninety nine thousand nine hundred ninety nine");
```
