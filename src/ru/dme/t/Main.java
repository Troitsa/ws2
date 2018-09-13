package ru.dme.t;

public class Main {
    /*
    Задание:
    * На вход приложению подается ИНН ЮЛ/ФЛ
    * приложение возвращает один из возможных вариантов признака состояния описанных в документации (ws2.doc).
    */
    public static void main(String[] args) {
        Checker checker;
        if (args.length == 0) {
            checker = new Checker();
            checker.checkInn();
        }
        else {
            for (int i = 0; i < args.length; i++) {
                checker = new Checker(Long.parseLong(args[i]));
                checker.checkInn();
            }
        }
    }
}
