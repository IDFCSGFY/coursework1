public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[10];
        employees[0] = new Employee("Васильев", "Василий", "Васильевич", 1, 70000);
        employees[1] = new Employee("Петров", "Пётр", "Петрович", 2, 30000);
        employees[2] = new Employee("Петров", "Владимир", "Петрович", 3, 40000);
        employees[3] = new Employee("Петров", "Дмитрий", "Петрович", 2, 80000);

        printAllData(employees);
        System.out.println("sumAllSalaries(employees) = " + sumAllSalaries(employees));
        System.out.println("Нуждается в повышении: " + findLowestSalary(employees));
        System.out.println("Доволен своей зарплатой: " + findHighestSalary(employees));
        System.out.println("Средняя зарплата: " + findAverageSalary(employees));
        printAllFullNames(employees);
        System.out.println("=================================");
        indexSalary(employees, 10);
        printAllData(employees);
        System.out.println("=================================");
        indexSalary(employees, 10, 2);
        printAllData(employees, 2);
        System.out.println("findLowestSalary(employees, 1) = " + findLowestSalary(employees, 1));
        System.out.println("findAverageSalary(employees, 2) = " + findAverageSalary(employees, 2));
        printAllData(employees);
        printIfGreaterSalaryThan(employees, findAverageSalary(employees));
    }

    public static void printAllData(Employee[] employees, int requiredDepartment) {
        if (requiredDepartment == -1) {
            System.out.println("Производится печать информации сотрудников");
            for (int i = 0; i < employees[0].getCounter(); i++) {
                System.out.println(employees[i]);
            }
        } else {
            System.out.println("Производится печать информации сотрудников отдела: " + requiredDepartment);
            for (int i = 0; i < employees[0].getCounter(); i++) {
                if (employees[i].getDepartment() == requiredDepartment) {
                    System.out.println("ID: " + employees[i].ID + " | " + String.join(" ", employees[i].getLastName(), employees[i].getName(), employees[i].getMiddleName()) + ". Зарплата: " + employees[i].getSalary());
                }
            }
        }
    }

    public static void printAllData(Employee[] employees) {
        printAllData(employees, -1);
    }

    public static int sumAllSalaries(Employee[] employees, int requiredDepartment) {
        int sum = 0;
        if (requiredDepartment == -1) {
            for (int i = 0; i < employees[0].getCounter(); i++) {
                sum += employees[i].getSalary();
            }
            return sum;
        }
        for (int i = 0; i < employees[0].getCounter(); i++) {
            if (employees[i].getDepartment() == requiredDepartment) {
                sum += employees[i].getSalary();
            }
        }
        if (sum == 0) {
            throw new IllegalArgumentException("Ни одного работника соответствующего отдела не найдено");
        }
        return sum;
    }

    public static int sumAllSalaries(Employee[] employees) {
        return sumAllSalaries(employees, -1);
    }

    public static Employee findLowestSalary(Employee[] employees, int requiredDepartment) {
        int index = -1;
        if (requiredDepartment == -1) {
            index = 0;
            for (int i = index + 1; i < employees[0].getCounter(); i++) {
                if (employees[i].getSalary() < employees[index].getSalary()) {
                    index = i;
                }
            }
            return employees[index];
        }
        for (int i = 0; i < employees[0].getCounter(); i++) {
            if (employees[i].getDepartment() == requiredDepartment) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            throw new IllegalArgumentException("Ни одного работника соответствующего отдела не найдено");
        }
        for (int i = index + 1; i < employees[0].getCounter(); i++) {
            if (employees[i].getDepartment() == requiredDepartment) {
                if (employees[i].getSalary() < employees[index].getSalary()) {
                    index = i;
                }
            }
        }
        return employees[index];
    }

    public static Employee findLowestSalary(Employee[] employees) {
        return findLowestSalary(employees, -1);
    }

    public static Employee findHighestSalary(Employee[] employees, int requiredDepartment) {
        int index = -1;
        if (requiredDepartment == -1) {
            index = 0;
            for (int i = index + 1; i < employees[0].getCounter(); i++) {
                if (employees[i].getSalary() > employees[index].getSalary()) {
                    index = i;
                }
            }
            return employees[index];
        }
        for (int i = 0; i < employees[0].getCounter(); i++) {
            if (employees[i].getDepartment() == requiredDepartment) {
                index = i;
            }
        }
        if (index == -1) {
            throw new IllegalArgumentException("Ни одного работника соответствующего отдела не найдено");
        }
        for (int i = index + 1; i < employees[0].getCounter(); i++) {
            if (employees[i].getDepartment() == requiredDepartment) {
                if (employees[i].getSalary() > employees[index].getSalary()) {
                    index = i;
                }
            }
        }
        return employees[index];
    }

    public static Employee findHighestSalary(Employee[] employees) {
        return findHighestSalary(employees, -1);
    }

    public static int findAverageSalary(Employee[] employees, int requiredDepartment) {
        int counter = 0;
        for (int i = 0; i < employees[0].getCounter(); i++) {
            if (employees[i].getDepartment() == requiredDepartment) {
                counter++;
            }
        }
        return sumAllSalaries(employees, requiredDepartment)/counter;
    }

    public static int findAverageSalary(Employee[] employees) {
        return (int) sumAllSalaries(employees, -1) / employees[0].getCounter();
    }

    public static void indexSalary(Employee[] employees, int percent, int requiredDepartment) {
        double multiplier = (double) percent / 100 + 1;
        if (requiredDepartment == -1) {
            for (int i = 0; i < employees[0].getCounter(); i++) {
                employees[i].setSalary((int) (employees[i].getSalary() * multiplier));
            }
        }
        for (int i = 0; i < employees[0].getCounter(); i++) {
            if (employees[i].getDepartment() == requiredDepartment) {
                employees[i].setSalary((int) (employees[i].getSalary() * multiplier));
            }
        }
    }

    public static void indexSalary(Employee[] employees, int percent) {
        indexSalary(employees, percent, -1);
    }

    public static void printAllFullNames(Employee[] employees) {
        for (int i = 0; i < employees[0].getCounter(); i++) {
            System.out.println(String.join(" ", employees[i].getLastName(), employees[i].getName(), employees[i].getMiddleName()));
        }
    }

    public static void printIfLesserSalaryThan(Employee[] employees, int requiredSalary) {
        System.out.println("Производится печать сотрудников с зарплатой меньше: " + requiredSalary);
        for (int i = 0; i < Employee.getCounter(); i++) {
            if (employees[i].getSalary() < requiredSalary) {
                System.out.println("ID: " + employees[i].ID + " | " + String.join(" ", employees[i].getLastName(), employees[i].getName(), employees[i].getMiddleName()) + ". Зарплата: " + employees[i].getSalary());
            }
        }
    }

    public static void printIfGreaterSalaryThan(Employee[] employees, int requiredSalary) {
        System.out.println("Производится печать сотрудников с зарплатой больше: " + requiredSalary);
        for (int i = 0; i < Employee.getCounter(); i++) {
            if (employees[i].getSalary() > requiredSalary) {
                System.out.println("ID: " + employees[i].ID + " | " + String.join(" ", employees[i].getLastName(), employees[i].getName(), employees[i].getMiddleName()) + ". Зарплата: " + employees[i].getSalary());
            }
        }
    }
}