import java.util.Objects;

public class Employee {
    private static int counter = 0;
    public final int ID;
    private String name;
    private String lastName;
    private String middleName;
    private int department;
    private int salary;

    public Employee (String lastName, String name, String middleName, int department, int salary) {
        counter++;
        ID = counter;
        this.name = name;
        this.lastName = lastName;
        this.middleName = middleName;
        this.department = department;
        this.salary = salary;
    }

    public static int getCounter() {
        return counter;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return ID == employee.ID;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(ID);
    }

    @Override
    public String toString() {
        return "ID: " + ID + " | " + String.join(" ", lastName, name, middleName) + ". \t Отдел: " + department + ". \t Зарплата: " + salary;
    }
}
