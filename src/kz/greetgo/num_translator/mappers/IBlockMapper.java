package kz.greetgo.num_translator.mappers;

/**
 * Перевод блока в прописной вариант, без определения какой этот блок (тысячный / миллионный / миллиардный)
 * just mapping of three digits
 */
public interface IBlockMapper {

  String decimalToWordsMapper(ThreeDigitsBlock num);

  String unitToWordsMapper(ThreeDigitsBlock num);

  String hundredToWordsMapper(ThreeDigitsBlock num);

}
