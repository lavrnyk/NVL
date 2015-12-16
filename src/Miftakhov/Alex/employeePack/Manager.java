package Miftakhov.Alex.employeePack;

public class Manager extends Employee {


    private int sales;

    //10
    public int compareTo(Employee emp) {
        return Double.compare(this.getSalary(), emp.getSalary());
    }




    public Manager(long id, String firstName, String lastName, double salary, int age, int sales) {
        super(id, firstName, lastName, salary, age);
        this.sales = sales;
    }

    public Manager(int sales) {
        this.sales = sales;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }


    //13
    public String toString() {
        return "Hi, My name is " + this.getFirstName() + " " + this.getLastName() + " and I am a MANAGER , my id is " + this.getId() +
                ". My age is " + this.getAge() +
                ", my salary is " + calculateSalary();

    }

    //14
    double calculateSalary() {
        return this.getSalary() + this.getSales() * 100;

    }

    Manager() {
        this.setFirstName("SomeManager");
    }

}
