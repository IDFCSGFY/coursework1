public class EmployeeBook {
    private final Employee[] employees;

    public EmployeeBook() {
        employees = new Employee[10];
        employees[0] = new Employee("Васильев", "Василий",  "Васильевич",   1, 70000);
        employees[1] = new Employee("Петров",   "Пётр",     "Петрович",     2, 130000);
        employees[2] = new Employee("Петров",   "Владимир", "Петрович",     3, 40000);
        employees[3] = new Employee("Петров",   "Дмитрий",  "Петрович",     2, 80000);
        employees[4] = new Employee("Меладзе",  "Валерий",  "Шотаевич",     4, 1000000);
        employees[5] = new Employee("Дирк",     "Роге",     "Чепушилович",  5, 160000);
        employees[6] = new Employee("Гений",    "Владислав","Эйнштейнович", 5, 100000);
        employees[7] = new Employee("Негей",    "Никита",   "Натуралович",  3, 30000);
        employees[8] = new Employee("Анна",     "Колмаз",   "Владимировна", 1, 15000);
    }
}
