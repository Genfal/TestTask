package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reader {
    private Parser parser = new Parser();

    //    Метод прочтения строки
    public void ReadNumbers() throws Exception
    {
//        Читаем строку
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

//        Ловим исключение
        try
        {
            parser.ParseNumbers(reader.readLine());
        }
//        Закрываем программу при исключении
        catch (IOException e)
        {
            Main.closeTheProgram(2);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            Main.closeTheProgram(2);
        }
    }
}