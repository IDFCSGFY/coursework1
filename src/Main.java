public class Main {
    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook();

        employeeBook.addEmployee("Васильев", "Василий",  "Васильевич",   1, 70000);
        employeeBook.addEmployee("Петров",   "Пётр",     "Петрович",     2, 130000);
        employeeBook.addEmployee("Петров",   "Владимир", "Петрович",     3, 40000);
        employeeBook.addEmployee("Меладзе",  "Валерий",  "Шотаевич",     4, 1000000);
        employeeBook.addEmployee("Крид",     "Егор",     "Николаевич",   4, 800000);
        employeeBook.addEmployee("Дирк",     "Роге",     "Чепушилович",  5, 160000);
        employeeBook.addEmployee("Гений",    "Владислав","Эйнштейнович", 5, 100000);
        employeeBook.addEmployee("Негей",    "Никита",   "Натуралович",  3, 30000);
        employeeBook.addEmployee("Колмаз",   "Анна",     "Владимировна", 1, 15000);
        employeeBook.addEmployee("Путин",    "Владимир", "Владимирович", 1, 100);

        //1
        System.out.println("\nчасть 1\n");
        employeeBook.printAllData();
        System.out.println("employeeBook.sumAllSalaries() = " + employeeBook.sumAllSalaries());
        System.out.println("employeeBook.findLowestSalary() = " + employeeBook.findLowestSalary());
        System.out.println("employeeBook.findHighestSalary() = " + employeeBook.findHighestSalary());
        System.out.println("employeeBook.findAverageSalary() = " + employeeBook.findAverageSalary());
        employeeBook.printAllFullNames();

        //2
        System.out.println("\nчасть 2\n");
        employeeBook.indexSalary(10);
        System.out.println("employeeBook.findLowestSalary(1) = " + employeeBook.findLowestSalary(1));
        System.out.println("employeeBook.findHighestSalary(1) = " + employeeBook.findHighestSalary(1));
        System.out.println("employeeBook.findAverageSalary(1) = " + employeeBook.findAverageSalary(1));
        employeeBook.indexSalary(10, 1);
        employeeBook.printAllData(1);
        employeeBook.printIfLesserSalaryThan(50000);
        employeeBook.printIfGreaterSalaryThan(50000);

        //3
        System.out.println("\nчасть 3\n");
        employeeBook.removeEmployeeByID(10);
        employeeBook.printAllData();
        employeeBook.addEmployee("Ааа", "Ббб", "Ввв", 5, 555);
        employeeBook.printAllData();
    }
}
