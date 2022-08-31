public class Employee {

    private String name;
    private String lastName;
    private int age;
    private double salary;
    private Gender gender;
    private String companyName;

    public Employee(String name, String lastName, int age, double salary, Gender gender, String companyName) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
        this.gender = gender;
        this.companyName = companyName;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public Gender getGender() {
        return gender;
    }

    public String getCompanyName() {
        return companyName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", gender=" + gender +
                ", companyName='" + companyName + '\'' +
                '}';
    }
}
