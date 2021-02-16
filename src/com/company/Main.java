package com.company;

public class Main {

    public static void main(String[] args) throws Exception {
//        Создаём элемент класса Reader с названием reader
        Reader reader = new Reader();

//        Используем публичную (открытую для всех остальных функцию из класса Reader)
        reader.ReadNumbers();
    }

//    Метод закрытия программы с принимаемыми значениями ошибок
    public static void closeTheProgram(int errorIndex) throws Exception
    {
//        В зависимости от кода ошибки выводим разные тексты
        switch (errorIndex) {
            case 1:
                System.out.println("Оба числа должны быть одного вида, а также числа должны быть от 1 до 10");
                break;
            case 2:
                System.out.println("Введите корректные значения");
                System.out.println("Пример: 1 + 2");
                break;
            case 3:
                System.out.println("Неправильно введён символ операции");
                break;
        }
//        Кидаем исключение Exception
        throw new Exception("Некорректные данные");
    }
}
