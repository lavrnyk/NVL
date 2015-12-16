package Miftakhov.Alex.employeePack;
import java.util.Random;

public class EmployeeTest {
    public static void main(String[] args) {


        Employee[] outPutEmployees = generateEmployees(4);
        for (Employee outPutEmployee : outPutEmployees) {
            //System.out.println(outPutEmployees[i].tellAboutYourself1());
            System.out.println(outPutEmployee);
        }

        System.out.println();

    }

    static Employee[] generateEmployees(int size) {
        String[] firstNames = {"Alex", "Oleg", "Misha", "Mykola", "Tolik", "Vasja", "Petja"};
        String[] secondNames = {"Ivanov", "Petrov", "Sidorov", "Smirnov", "Familiya1", "Familiya3", "Familiya3"};
        Employee[] employees = new Employee[size];
        Random random = new Random();

        /*for (int i = 0; i < size; i++) {
            if(random.nextBoolean()) {
                employees[i] = new Miftakhov.Alex.employeePack.Developer();
                employees[i].setId(i);
                employees[i].setFirstName(firstNames[random.nextInt(firstNames.length)]);
                employees[i].setLastName(secondNames[random.nextInt(secondNames.length)]);
                employees[i].setSalary(random.nextDouble() + 1000);
                employees[i].setAge(random.nextInt(10) + 18);


            } else {
                employees[i] = new Miftakhov.Alex.employeePack.Manager();
                employees[i].setId(i);
                employees[i].setFirstName(firstNames[random.nextInt(firstNames.length)]);
                employees[i].setLastName(secondNames[random.nextInt(secondNames.length)]);
                employees[i].setSalary(random.nextDouble() + 1000);
                employees[i].setAge(random.nextInt(10) + 18);

            }*/
        //employees[i] = new Miftakhov.Alex.employeePack.Employee(identify, firstNameR, lastNameR, salaryR, ageR);
        // System.out.println((employees).tellAboutYourself1());
        for (int i = 0; i < size; i++) {
/*            employees[i] = new Miftakhov.Alex.employeePack.Employee(i+1, firstNames[random.nextInt(firstNames.length)]
                    , secondNames[random.nextInt(secondNames.length)]
                    , random.nextInt(1000) + 1000
                    , random.nextInt(10) + 18);*/
            if (random.nextBoolean()) {
                Developer employee1 = new Developer();
                employee1.setCodedLines(random.nextInt(1000));
                //employees[i].codedLines = employee1.codedLines;
                employees[i] = employee1;
            } else {
                Manager employee2 = new Manager();
                employee2.setSales(random.nextInt(1000));
                //employees[i].sales = (employee2.sales);
                employees[i] = employee2;
            }
            Employee employee = employees[i];
            employee.setId(i + 1);
            employee.setFirstName(firstNames[random.nextInt(firstNames.length)]);
            employee.setLastName(secondNames[random.nextInt(secondNames.length)]);
            employee.setSalary(random.nextInt(1000) + 1000);
            employee.setAge(random.nextInt(10) + 18);


        }

        return employees;
    }

}
