package ru.dme.t;

public class Main {
    /*
    �������:
    * �� ���� ���������� �������� ��� ��/��
    * ���������� ���������� ���� �� ��������� ��������� �������� ��������� ��������� � ������������ (ws2.doc).
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
