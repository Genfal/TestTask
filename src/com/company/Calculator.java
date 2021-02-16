package com.company;

import java.security.Key;
import java.util.LinkedHashMap;
import java.util.Map;

public class Calculator {
    private int result;

    //    Метод принимаемый конвертированные числа и знак
    public void Calculate(int[] numsToCalculate, char sign, boolean roman) throws Exception
    {
//        Если знак совпадает с одним из знаков ниже, то производится соответствующая операция
        switch (sign)
        {
            case '+' :
                result = numsToCalculate[0] + numsToCalculate[1];
                break;
            case '-' :
                result = numsToCalculate[0] - numsToCalculate[1];
                break;
            case '/' :
                result = numsToCalculate[0] / numsToCalculate[1];
                break;
            case '*', 'x', 'х' :
                result = numsToCalculate[0] * numsToCalculate[1];
                break;
            default:
                Main.closeTheProgram(3);
                break;
        }
//        Если передано значение roman = false, значит числа - арабские, иначе конвертировать в римские
        if (roman == false) System.out.println(result);
        else ArabianToRoman(result);
    }

    private void ArabianToRoman(int number)
    {
//        Создаём строку, в случае если число отрицательное, добавляем в начало -
        String convertedArabian;
        if (number < 0) convertedArabian = "-";
        else convertedArabian = "";

//        Берём модуль, т.к. это позволит работать как с отрицательными, так и с положительными одинаково (код ранее уже определил отрицательное или нет)
        number=Math.abs(number);

//        Хэш карта для удобства
        LinkedHashMap<String, Integer> romanNumbers = new LinkedHashMap<>();
        romanNumbers.put("C", 100);
        romanNumbers.put("XC", 90);
        romanNumbers.put("L", 50);
        romanNumbers.put("XL", 40);
        romanNumbers.put("X", 10);
        romanNumbers.put("IX", 9);
        romanNumbers.put("VIII", 8);
        romanNumbers.put("VII", 7);
        romanNumbers.put("VI", 6);
        romanNumbers.put("V", 5);
        romanNumbers.put("IV", 4);
        romanNumbers.put("III", 3);
        romanNumbers.put("II", 2);
        romanNumbers.put("I", 1);

//        Число больше 0, отнимаем от него максимально возможное значение из карты и приписываем ключ в строку
        while (number > 0)
        {
            for (Map.Entry<String, Integer> entry : romanNumbers.entrySet())
            {
                while (number >= entry.getValue())
                {
                    convertedArabian+=entry.getKey();
                    number-=entry.getValue();
                }
            }
        }
//        Вывод результата в римских числах
        System.out.println(convertedArabian);
    }

}
