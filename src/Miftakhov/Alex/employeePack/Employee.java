package Miftakhov.Alex.employeePack;

public  abstract class Employee implements Comparable<Employee>{
    private long id;
    private String firstName;
    private  String lastName;
    private double salary;
    private int age;
    public abstract int compareTo(Employee emp) ;

    public Employee(long id, String firstName, String lastName, double salary, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.age = age;
    }
//15
    public String tellAboutYourself1() {
        return "Hi, My name is " + firstName + " " + lastName +
                ", my id is " + id + ". My age is " + age +
                ", my salary is " + calculateSalary();

    }
    public String toString() {
        return "Hi, My name is " + firstName + " " + lastName +
                ", my id is " + id + ". My age is " + age +
                ", my salary is " + calculateSalary();

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
//16
    double calculateSalary() {
        return salary * (double) (age - 18);

    }
    Employee() {
        firstName = "Unnamed";
    }


}
