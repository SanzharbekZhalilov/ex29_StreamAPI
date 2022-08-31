import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Employee aidana = new Employee("Aidana", "Kamchybekova", 18, 220_000, Gender.FEMALE, "Google");
        Employee samira = new Employee("Samira", "Kadyrova", 24, 110_000, Gender.FEMALE, "Yandex");
        Employee artur = new Employee("Artur", "Akynov", 40, 250_000, Gender.MALE, "Google");
        Employee samir = new Employee("Samir", "Samirov", 31, 190_000, Gender.MALE, "Microsoft");
        Employee dana = new Employee("Dana", "Daniliva", 18, 120_000, Gender.FEMALE, "EPAM");
        Employee azat = new Employee("Azat", "Azatov", 22, 140_000, Gender.MALE, "Google");
        Employee malik = new Employee("Malik", "Malikov", 27, 130_000, Gender.MALE, "EPAM");
        Employee kubat = new Employee("Kubat", "Kubatov", 18, 110_000, Gender.MALE, "Google");
        Employee bekbolot = new Employee("Bekbolot", "Bekbolotov", 24, 150_000, Gender.MALE, "Google");
        Employee madina = new Employee("Madina", "Madinova", 23, 260_000, Gender.FEMALE, "EPAM");
        List<Employee> employees = new ArrayList<>();
        employees.add(aidana);
        employees.add(samir);
        employees.add(samira);
        employees.add(artur);
        employees.add(dana);
        employees.add(azat);
        employees.add(malik);
        employees.add(kubat);
        employees.add(bekbolot);
        employees.add(madina);

        System.out.println("***** 1) Вывести всех сотрудников, у которых возраст больше 25 и отсортировать сотрудников по имени");
        employees.stream()
                .filter(e -> e.getAge() > 25)
                .sorted(Comparator.comparing(Employee::getName))
                .forEach(System.out::println);

        System.out.println("\n***** 2) Вывести сотрудников, которые не работают в Google");
        employees.stream()
                .filter(e -> !e.getCompanyName().equals("Google"))
                .forEach(System.out::println);

        System.out.println("\n***** 3) Найти первого сотрудника по имени в алфавитном порядке // min по возрасту");
        Employee employee = employees.stream()
                .min(Comparator.comparing(Employee::getAge))
                .get();
        System.out.println(employee);

        System.out.println("\n***** 5) Найти сумму зарплат всех сотрудников и сумму возрастов");
        double sumSalary = employees.stream()
                .mapToDouble(Employee::getSalary)
                .sum();
        System.out.println("Сумма зарплат: " + sumSalary);
        int sumAge = employees.stream()
                .mapToInt(Employee::getAge)
                .sum();
        System.out.println("Сумма возрастов: " + sumAge);

        System.out.println("\n***** 6) Найти среднюю зарплату всех сотрудников");
        double averageSalary = employees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .getAsDouble();
        System.out.println("Средняя зарплата: " + averageSalary);

        System.out.println("\n***** 7) Вывести всех женщин и количество женщин");
        long countFemale = employees.stream()
                .filter(e -> e.getGender().equals(Gender.FEMALE))
                .peek(System.out::println)
                .count();
        System.out.println("Количество женщин: " + countFemale);

        System.out.println("\n***** 8) Вывести всех сотрудников, у которых имя не начинается на букву А");
        employees.stream()
                .filter(e -> !e.getName().startsWith("A"))
                .forEach(System.out::println);

        System.out.println("\n***** 9) Вывести сотрудников, которые работают в Google и у которых возраст больше 20");
        employees.stream()
                .filter(e -> e.getCompanyName().equals("Google") && e.getAge() > 20)
                .forEach(System.out::println);

        System.out.println("\n*****Группировка по компании");
        employees.stream()
                .collect(Collectors.groupingBy(Employee::getCompanyName))
                .forEach((k, v) -> System.out.println(k + ": " + v));
    }
}