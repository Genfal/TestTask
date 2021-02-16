package com.company;

public class Parser {

    //
    private Calculator calculator = new Calculator();

    //    Массив разрешенных арабских чисел
    private int[] arabianNumbers = {1,2,3,4,5,6,7,8,9,10};

    //    Массив в виде разрешённых римских чисел
    private String[] romanNumbers = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};

//    Метод для вызова из других классов, ищет числа и знаки в строке
    public void ParseNumbers(String readedLine) throws Exception
    {
//        Разделяет строку на 3 разных для удобства поиска
        String[] splitedString = readedLine.split(" ", 0);
//        Если это не арабские и не римские, либо меньше 0 или больше 10 закрываем программу
        if (!ArabianChecker(splitedString) && !RomanChecker(splitedString))
        {
            try
            {
                Main.closeTheProgram(1);
            } catch (Exception e) {}
        }
    }


//      Проверка на арабские цифры
    private boolean ArabianChecker(String[] splitedNumbers) throws Exception
    {
//        Переменные для определения одинаковые ли числа
        boolean firstCheck = false;
        boolean secondCheck = false;
//        Массив для конвертированных значений
        int[] convertedArabian = new int[2];

//        Пробуем взять из строки целочисленное значение
        try
        {
            convertedArabian[0] = Integer.parseInt(splitedNumbers[0]);
            convertedArabian[1] = Integer.parseInt(splitedNumbers[2]);
        }
//        В случае неудачи возвращаем false и пробуем римские
        catch (NumberFormatException e)
        {
            return false;
        }

//        Проверяем на соответствие с разрешенными числами
        for (int i = 0; i < arabianNumbers.length; i++)
        {
            if (convertedArabian[0] == arabianNumbers[i])
            {
                firstCheck = true;
            }
            if (convertedArabian[1] == arabianNumbers[i])
            {
                secondCheck = true;
            }
        }

//        Если все совпало вызываем метод Calculate в экзмепляре класса Calculator
        if (firstCheck && secondCheck)
        {
            calculator.Calculate(convertedArabian, splitedNumbers[1].charAt(0), false);
            return  true;
        }
//        Иначе возвращем false
        else return false;
    }


//      Проверка на римские цифры
    private boolean RomanChecker(String[] splitedNumbers) throws Exception
    {
//        Переменные для определения одинаковые ли числа
        boolean firstCheck = false;
        boolean secondCheck = false;
//        Массив для конвертированных значений
        int[] convertedRoman = new int[2];

//        Провреяем совпадение между строкой и римскими цифрами, используется equals т.к. именно оно проверяет содержание, в отличии от == который проверяет ссылку
        for (int i = 0; i < romanNumbers.length; i++)
        {
            if (splitedNumbers[0].equals(romanNumbers[i]))
            {
                firstCheck = true;
//                При совпадении конвертируем в арабские
                convertedRoman[0] = i + 1;
            }
            if (splitedNumbers[2].equals(romanNumbers[i]))
            {
                secondCheck = true;
//                При совпадении конвертируем в арабские
                convertedRoman[1] = i + 1;
            }
        }

//        Если все совпало вызываем метод Calculate в экзмепляре класса Calculator
        if (firstCheck && secondCheck)
        {
            calculator.Calculate(convertedRoman, splitedNumbers[1].charAt(0), true);
            return  true;
        }
//        Иначе возвращем false
        else return false;
    }
}