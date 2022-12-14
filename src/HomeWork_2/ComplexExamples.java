package HomeWork_2;

import java.util.*;
import java.util.stream.Collectors;

public class ComplexExamples {

    static class Person {
        final int id;

        final String name;

        Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Person person)) return false;
            return getId() == person.getId() && getName().equals(person.getName());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getId(), getName());
        }
    }

    private static Person[] RAW_DATA = new Person[]{
            new Person(0, "Harry"),
            new Person(0, "Harry"), // дубликат
            new Person(1, "Harry"), // тёзка
            new Person(2, "Harry"),
            new Person(3, "Emily"),
            new Person(4, "Jack"),
            new Person(4, "Jack"),
            new Person(5, "Amelia"),
            new Person(5, "Amelia"),
            new Person(6, "Amelia"),
            new Person(7, "Amelia"),
            new Person(8, "Amelia"),
    };
        /*  Raw data:

        0 - Harry
        0 - Harry
        1 - Harry
        2 - Harry
        3 - Emily
        4 - Jack
        4 - Jack
        5 - Amelia
        5 - Amelia
        6 - Amelia
        7 - Amelia
        8 - Amelia

        **************************************************

        Duplicate filtered, grouped by name, sorted by name and id:

        Amelia:
        1 - Amelia (5)
        2 - Amelia (6)
        3 - Amelia (7)
        4 - Amelia (8)
        Emily:
        1 - Emily (3)
        Harry:
        1 - Harry (0)
        2 - Harry (1)
        3 - Harry (2)
        Jack:
        1 - Jack (4)
     */

    public static void main(String[] args) {
        System.out.println("Raw data:");
        System.out.println();

        for (Person person : RAW_DATA) {
            System.out.println(person.id + " - " + person.name);
        }

        System.out.println();
        System.out.println("**************************************************");
        System.out.println();
        System.out.println("Duplicate filtered, grouped by name, sorted by name and id:");
        System.out.println();

        System.out.println("Task 1 result:");
        processingArrayOfObjects(RAW_DATA);

        System.out.println("\nTask 2 result:");
        int[] arrayOfNumbers = new int[]{3, 4, 2, 7};
        System.out.println(Arrays.toString(getPairOfNumbers(arrayOfNumbers, 10)));
        System.out.println("\nTask 3 result:");
        System.out.println(fuzzySearch("car", "ca6$$#_rtwheel")); // true
        System.out.println(fuzzySearch("cwhl", "cartwheel")); // true
        System.out.println(fuzzySearch("cwhee", "cartwheel")); // true
        System.out.println(fuzzySearch("cartwheel", "cartwheel")); // true
        System.out.println(fuzzySearch("cwheeel", "cartwheel")); // false
        System.out.println(fuzzySearch("lw", "cartwheel")); // false

        /*
        Task1:
            Убрать дубликаты, отсортировать по идентификатору, сгруппировать по имени.
            Что должно получиться:
                Key: Amelia
                Value:4
                Key: Emily
                Value:1
                Key: Harry
                Value:3
                Key: Jack
                Value:1

        Task2:
            [3, 4, 2, 7], 10 -> [3, 7] - вывести пару менно в скобках, которые дают сумму - 10.

        Task3:
            Реализовать функцию нечеткого поиска:
                    fuzzySearch("car", "ca6$$#_rtwheel"); // true
                    fuzzySearch("cwhl", "cartwheel"); // true
                    fuzzySearch("cwhee", "cartwheel"); // true
                    fuzzySearch("cartwheel", "cartwheel"); // true
                    fuzzySearch("cwheeel", "cartwheel"); // false
                    fuzzySearch("lw", "cartwheel"); // false
         */
    }

    public static void processingArrayOfObjects(Person[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }
        Map<String, Long> map = Arrays.stream(array)
                .distinct()
                .sorted(Comparator.comparingInt(Person::getId))
                .collect(Collectors.groupingBy(Person::getName, HashMap::new, Collectors.counting()));
        map.forEach((k, v) -> System.out.print("Key: " + k + "\nValue:" + v + "\n"));
    }

    public static int[] getPairOfNumbers(int[] array, int target) {
        if (array == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }
        Map<Integer, Integer> setsOfNumbers = new HashMap<>();
        for (int number : array) {
            Integer set = setsOfNumbers.get(number);
            if (set != null) {
                return new int[]{set, number};
            }
            setsOfNumbers.put(target - number, number);
        }
        throw new NoSuchElementException("For target " + target + " no such elements");
    }

    public static boolean fuzzySearch(String required, String source) {
        if (required == null || source == null) {
            throw new IllegalArgumentException("Arguments cannot be null");
        }
        StringBuilder tmpString = new StringBuilder();
        int index = 0;
        int count = 0;
        while (index < required.length() && count < source.length()) {
            if (source.charAt(count) == required.charAt(index)) {
                tmpString.append(source.charAt(count));
                index++;
            }
            count++;
        }
        return required.equals(String.valueOf(tmpString));
    }
}
