public class EmployeeBook {
    private final Employee[] employees;

    public EmployeeBook() {
        employees = new Employee[10];
    }

    public boolean addEmployee(String lastName, String name, String middleName, int department, int salary) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = new Employee(lastName, name, middleName, department, salary);
                System.out.println("Добавлен новый сотрудник!");
                System.out.println(employees[i]);
                return true;
            }
        }
        System.out.println("Массив переполнен!");
        return false;
    }

    public boolean removeEmployeeByID(int requiredID) {
        for (int i = 0; i < employees.length && employees[i] != null; i++) {
            if (employees[i].ID == requiredID) {
                System.out.println("Сотрудник для удаления найден. Происходит удаление...");
                for (int j = i + 1; j < employees.length; j++) {
                    employees[j - 1] = employees[j];
                }
                employees[9] = null;
                return true;
            }
        }
        System.out.println("Сотрудник с таким айди не был найден. Удаление не произошло.");
        return false;
    }

    public void printAllData(int requiredDepartment) {
        if (requiredDepartment == -1) {
            System.out.println("Производится печать информации всех сотрудников...\n===========================");
            for (int i = 0; i < employees.length && employees[i] != null; i++) {
                System.out.println(employees[i]);
            }
            System.out.println("===========================");
        } else {
            System.out.println("Производится печать информации сотрудников отдела: " + requiredDepartment + "...");
            for (int i = 0; i < employees.length && employees[i] != null; i++) {
                if (employees[i].getDepartment() == requiredDepartment) {
                    System.out.println("ID: " + employees[i].ID + " | " + String.join(" ", employees[i].getLastName(), employees[i].getName(), employees[i].getMiddleName()) + ". Зарплата: " + employees[i].getSalary());
                }
            }
        }
    }

    public void printAllData() {
        printAllData(-1);
    }

    public int sumAllSalaries(int requiredDepartment) {
        int sum = 0;
        if (requiredDepartment == -1) {
            System.out.println("Производится подсчёт суммы всех зарплат сотрудников...");
            for (int i = 0; i < employees.length && employees[i] != null; i++) {
                sum += employees[i].getSalary();
            }
            return sum;
        }
        System.out.println("Производится подсчёт суммы зарплат сотрудников отдела: " + requiredDepartment + "...");
        for (int i = 0; i < employees.length && employees[i] != null; i++) {
            if (employees[i].getDepartment() == requiredDepartment) {
                sum += employees[i].getSalary();
            }
        }
        if (sum == 0) {
            throw new IllegalArgumentException("Ни одного работника соответствующего отдела не найдено");
        }
        return sum;
    }

    public int sumAllSalaries() {
        return sumAllSalaries(-1);
    }

    public Employee findLowestSalary(int requiredDepartment) {
        int index = -1;
        if (requiredDepartment == -1) {
            System.out.println("Поиск сотрудника с наименьшей зарплатой...");
            index = 0;
            for (int i = index + 1; i < employees.length && employees[i] != null; i++) {
                if (employees[i].getSalary() < employees[index].getSalary()) {
                    index = i;
                }
            }
            return employees[index];
        }
        for (int i = 0; i < employees.length && employees[i] != null; i++) {
            if (employees[i].getDepartment() == requiredDepartment) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            throw new IllegalArgumentException("Ни одного работника соответствующего отдела не найдено");
        }
        System.out.println("Поиск сотрудника с наименьшей зарплатой отдела: " + requiredDepartment + "...");
        for (int i = index + 1; i < employees.length && employees[i] != null; i++) {
            if (employees[i].getDepartment() == requiredDepartment) {
                if (employees[i].getSalary() < employees[index].getSalary()) {
                    index = i;
                }
            }
        }
        return employees[index];
    }

    public Employee findLowestSalary() {
        return findLowestSalary(-1);
    }

    public Employee findHighestSalary(int requiredDepartment) {
        int index = -1;
        if (requiredDepartment == -1) {
            System.out.println("Поиск сотрудника с наибольшей зарплатой...");
            index = 0;
            for (int i = index + 1; i < employees.length && employees[i] != null; i++) {
                if (employees[i].getSalary() > employees[index].getSalary()) {
                    index = i;
                }
            }
            return employees[index];
        }
        for (int i = 0; i < employees.length && employees[i] != null; i++) {
            if (employees[i].getDepartment() == requiredDepartment) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            throw new IllegalArgumentException("Ни одного работника соответствующего отдела не найдено");
        }
        System.out.println("Поиск сотрудника с наибольшей зарплатой отдела: " + requiredDepartment + "...");
        for (int i = index + 1; i < employees.length && employees[i] != null; i++) {
            if (employees[i].getDepartment() == requiredDepartment) {
                if (employees[i].getSalary() > employees[index].getSalary()) {
                    index = i;
                }
            }
        }
        return employees[index];
    }

    public Employee findHighestSalary() {
        return findHighestSalary(-1);
    }

    public int findAverageSalary(int requiredDepartment) {
        System.out.println("Поиск средней зарплаты по отделу: " + requiredDepartment + "...");
        int counter = 0;
        for (int i = 0; i < employees.length && employees[i] != null; i++) {
            if (employees[i].getDepartment() == requiredDepartment) {
                counter++;
            }
        }
        return sumAllSalaries(requiredDepartment)/counter;
    }

    public int findAverageSalary() {
        System.out.println("Поиск средней зарплаты...");
        return (int) sumAllSalaries(-1) / Employee.getCounter();
    }

    public void indexSalary(int percent, int requiredDepartment) {
        double multiplier = (double) percent / 100 + 1;
        if (requiredDepartment == -1) {
            System.out.println("Производится индексация зарплат всех сотрудников на процент: " + percent + "...");
            for (int i = 0; i < employees.length && employees[i] != null; i++) {
                employees[i].setSalary((int) (employees[i].getSalary() * multiplier));
            }
        } else {
            System.out.println("Производится индексация зарплат сотрудников отдела: " + requiredDepartment + " на процент: " + percent + "...");
            for (int i = 0; i < employees.length && employees[i] != null; i++) {
                if (employees[i].getDepartment() == requiredDepartment) {
                    employees[i].setSalary((int) (employees[i].getSalary() * multiplier));
                }
            }
        }
    }

    public void indexSalary(int percent) {
        indexSalary(percent, -1);
    }

    public void printAllFullNames() {
        System.out.println("Производится печать списка всех сотрудников в формате |ФИО|\n===========================");
        for (int i = 0; i < employees.length && employees[i] != null; i++) {
            System.out.println(String.join(" ", employees[i].getLastName(), employees[i].getName(), employees[i].getMiddleName()));
        }
        System.out.println("===========================");
    }

    public void printIfLesserSalaryThan(int requiredSalary) {
        System.out.println("Производится печать сотрудников с зарплатой меньше: " + requiredSalary);
        for (int i = 0; i < employees.length && employees[i] != null; i++) {
            if (employees[i].getSalary() < requiredSalary) {
                System.out.println("ID: " + employees[i].ID + " | " + String.join(" ", employees[i].getLastName(), employees[i].getName(), employees[i].getMiddleName()) + ". Зарплата: " + employees[i].getSalary());
            }
        }
    }

    public void printIfGreaterSalaryThan(int requiredSalary) {
        System.out.println("Производится печать сотрудников с зарплатой больше: " + requiredSalary);
        for (int i = 0; i < employees.length && employees[i] != null; i++) {
            if (employees[i].getSalary() > requiredSalary) {
                System.out.println("ID: " + employees[i].ID + " | " + String.join(" ", employees[i].getLastName(), employees[i].getName(), employees[i].getMiddleName()) + ". Зарплата: " + employees[i].getSalary());
            }
        }
    }
}
