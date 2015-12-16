package Miftakhov.Alex.employeePack;

public class EmployeeParser {

    public static void main(String[] args) {
        Developer notCodedDeveloper = new Developer(1, "Tolik", "Trubin", 1000, 25, 1500);
        Developer notCodedDeveloper2 = new Developer(1, "Tolik", "Trubin", 1001, 25, 1700);
        Manager notCodedManager = new Manager(1, "Tolik", "Trubin", 1000, 25, 1500);
        String codedStringDeveloper = "[Miftakhov.Alex.employeePack.Developer:1:Tolik:Trubin:1000.0:25:1500]";
        String codedStringManager = "[Miftakhov.Alex.employeePack.Manager:1:Tolik:Trubin:1000.0:25:1500]";

        System.out.println("Start Encode");
        System.out.println(encodeDeveloper(notCodedDeveloper));
        System.out.println(encodeDeveloper(notCodedManager));
        System.out.println("Start Decode");
        System.out.println(decodeDeveloper(codedStringDeveloper));
        System.out.println(decodeDeveloper(codedStringManager));
        System.out.println(notCodedDeveloper.compareTo(notCodedDeveloper2));

    }
    //11
    static String encodeDeveloper(Employee emp) {
        Developer dev = new Developer();
        Manager manager = new Manager();
        String result = ":" + emp.getId() + ":" + emp.getFirstName() + ":"
                + emp.getLastName() + ":" + emp.getSalary() + ":"
                + emp.getAge() + ":";

        if (emp instanceof Developer) {
            String position = "[Miftakhov.Alex.employeePack.Developer";
            dev.setCodedLines(1000);
            result = position + result + dev.getCodedLines() + "]";

        } else {
            String position = "[Miftakhov.Alex.employeePack.Manager";
            manager.setSales(1500);
            result = position + result + manager.getSales() + "]";
        }
        return result;
    }
    //12
    static Employee decodeDeveloper(String code) {
        Employee employee = new Developer();
        String[] codes = code.split(":");
        String devMatch = "[Miftakhov.Alex.employeePack.Developer";

        int codeLinesOrSales = Integer.valueOf(codes[6].replaceAll("]", ""));

        if (code.contains(devMatch)) {
            Developer developer = new Developer();
            developer.setCodedLines(codeLinesOrSales);
            employee = developer;
        } else {
            Manager manager = new Manager();
            manager.setSales(codeLinesOrSales);
            employee = manager;
        }

        employee.setId(Long.valueOf(codes[1]));
        employee.setFirstName(codes[2]);
        employee.setLastName(codes[3]);
        employee.setSalary(Double.parseDouble(codes[4]));//codedLines * 2 + salary from DEV and salary + sales*100  for Miftakhov.Alex.employeePack.Manager
        employee.setAge(Integer.valueOf(codes[5]));

        return employee;

    }

}
