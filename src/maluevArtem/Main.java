package maluevArtem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static Logger logger = Logger.getLog();

    public static void main(String[] args) {

        logger.log("Запуск программы");
        start();

        logger.log("Ввод размера списка");
        System.out.print("Размер списка: ");
        int sizeList = inputValue("Размер списка: ");

        logger.log("Ввод границы значений");
        System.out.print("Верхняя граница значений: ");
        int valueBoundary = inputValue("Верхняя граница значений: ");

        List<Integer> list = createList(sizeList, valueBoundary);
        System.out.print("Список: ");
        list.forEach(x -> System.out.print(x + " "));
        System.out.println();

        logger.log("Ввод значения для фильтрации");
        System.out.print("Введите значение для фильтрации: ");
        int valueFilter = inputValue("Введите значение для фильтрации: ");

        Filter filter = new Filter(valueFilter);
        List<Integer> filterList = filter.filterOut(list);
        System.out.print("Отфильтрованный список: ");
        filterList.forEach(x -> System.out.print(x + " "));
        System.out.println();

        logger.log("Завершение программы");
        System.out.println("Программа завершена");
    }

    public static void start() {
        logger.log("Приветствие");
        System.out.println("Приветствую тебя, Пользователь!");
        logger.log("Просим ввести данные");
        System.out.println("Введи, пожалуйста, два числа, которые определят размер списка и " +
                "верхнюю границу значений элементов в списке");
    }

    public static List<Integer> createList(int sizeList, int valueBoundary) {
        logger.log("Создание списка");
        List<Integer> list = new ArrayList<>(sizeList);
        for (int i = 0; i < sizeList; i++) {
            list.add((int) (Math.random() * (valueBoundary + 1)));
        }
        return list;
    }

    public static int inputValue(String msg) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException ex) {
                logger.log("Ошибка ввода");
                System.out.println("Введено не верное значение");
                System.out.print(msg);
            }
        }
    }
}
