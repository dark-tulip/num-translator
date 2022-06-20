package kz.greetgo.num_translator.mappers;

import kz.greetgo.num_translator.languages.Language;

import java.util.stream.Collectors;
import java.util.stream.Stream;

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
  IBlockMapper mapper;
  BlockPosition blockPosition;
  Language      language;

  int hundreds;
  int decimals;
  int units;

  public ThreeDigitsBlock(int number, Language language, int position) {
    this.hundreds = Math.max(number / 100, 0);
    this.decimals = Math.max(number / 10 % 10, 0);
    this.units = Math.max(number % 10, 0);

    this.language = language;
    this.blockPosition = new BlockPosition(position, language, number);

    this.mapper =
      language.toString().equalsIgnoreCase("kaz") ? new KazBlockMapper()
        : language.toString().equalsIgnoreCase("eng") ? new EngBlockMapper()
        : language.toString().equalsIgnoreCase("qaz") ? new QazBlockMapper()
        : new RusBlockMapper();
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
      ? mapper.hundredToWordsMapper(this)
      : "";
  }

  public String getDecimalInWords() {
    return (this.decimals) > 0
      ? mapper.decimalToWordsMapper(this)
      : "";
  }

  public String getUnitInWords() {
    return (this.units > 0) || (this.getNumber() < 10)
      ? mapper.unitToWordsMapper(this)
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
