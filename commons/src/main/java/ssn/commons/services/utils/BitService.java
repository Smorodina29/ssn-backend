package ssn.commons.services.utils;

public interface BitService {
    /**
     * проверить значение бита
     * @param data байт для изменения
     * @param bit номер бита от 0
     * @return истина, если установлен
     */
    boolean testBit(int data, int bit);

    /**
     * установить значение бита
     * @param data байт для изменения
     * @param bit номер бита от 0
     * @return изменённый байт
     */
   int setBit(int data, int bit);

    /**
     * Преобразует числовое значение каждого элемента указанного массива байтов
     * в эквивалентное ему шестнадцатеричное строковое представление.
     * @param value массив байт
     */
    String byteArrayToString(int[] value);
}
