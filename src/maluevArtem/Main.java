package maluevArtem;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static Logger logger = Logger.getLog();

    public static void main(String[] args) {

        logger.log("Запуск программы");
        int sizeList;
        int valueBoundary;

        start();
        try {
            logger.log("Ввод размера списка");
            System.out.print("Размер списка: ");
            sizeList = scanner.nextInt();

            logger.log("Ввод границы значений");
            System.out.print("Верхняя граница значений: ");
            valueBoundary = scanner.nextInt();

        } catch (InputMismatchException ex) {
            logger.log("Ошибка ввода");
            System.out.println("Введено не верное значение");
            return;
        }

        List<Integer> list = createList(sizeList, valueBoundary);
        System.out.print("Список: ");
        list.forEach(x -> System.out.print(x + " "));
        System.out.println();

        int valueFilter = inputValueFilter();

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

    public static int inputValueFilter() {
        logger.log("Ввод значения для фильтрации");
        System.out.print("Введите значение для фильтрации: ");
        try {
            return scanner.nextInt();
        } catch (InputMismatchException ex) {
            logger.log("Ошибка ввода");
            System.out.println("Введено не верное значение");
            return 0;
        }
    }
}
