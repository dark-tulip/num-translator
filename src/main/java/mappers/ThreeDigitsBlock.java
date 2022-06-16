package mappers;

import languages.Language;
import mappers.BlockPosition;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static mappers.DecimalsMapper.decimalToWordsMapper;
import static mappers.HundredsMapper.hundredsToWordsMapper;
import static mappers.UnitsMapper.unitToWordsMapper;


/**
 * ThreeDigitsBlock (класс числа) - это блок из трех чисел
 * Input: целое число от [0 до 999]
 * Returns: прописной вид числа на заданном языке
 */
public class ThreeDigitsBlock {

    /**
     * Именные названия степеней тысячи
     * (определят к какому блоку относится, тысячи, миллионы или миллиарды)
    */
    BlockPosition blockPosition;
    Language language;

    int hundreds;
    int decimals;
    int units;

    public ThreeDigitsBlock(int number, Language language, BlockPosition blockPosition) {
        this.hundreds = number / 100 > 0 ? number / 100 : 0;
        this.decimals = number / 10 % 10 > 0 ? number / 10 % 10 : 0;
        this.units = number % 10 > 0 ? number % 10 : 0;

        this.language = language;
        this.blockPosition = blockPosition;
    }

    public int getNumber() {
        return this.hundreds * 100 + this.decimals * 10 + this.units;
    }

    public int getHundreds() {
        return this.hundreds;
    }

    public int getDecimals() {
        return this.decimals;
    }

    public int getUnits() {
        return this.units;
    }

    public int getBlockPosition() {
        return this.blockPosition.getBlockPosition();
    }

    /**
     * Converter without Nominal names of degrees of a thousand,
     * переводит три цифры из блока в прописной вид,
     * БЕЗ суффикса миллиарды, миллионы, тысячи
     */
    public String getHundredsInWords() {
        return (this.hundreds > 0)
                ? hundredsToWordsMapper(this)
                : "";
    }

    public String getDecimalInWords() {
        return (this.decimals) > 0
                ? decimalToWordsMapper(this)
                : "";
    }

    public String getUnitInWords() {
        return (this.units > 0) || (this.getNumber() < 10)
                ? unitToWordsMapper(this)
                : "";
    }

    public Language getLanguage() {
        return this.language;
    }


    public String toWords() {
        return Stream.of(this.getHundredsInWords(),
                        this.getDecimalInWords(),
                        this.getUnitInWords(),
                        this.blockPosition.getBlockName())
                .filter(str -> !str.isBlank())
                .collect(Collectors.joining(" "));
    }
}
