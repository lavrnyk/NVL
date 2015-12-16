package Miftakhov.Alex.employeePack;

/**
 * Created by omiftakhov on 24.11.2015.
 */
public class Developer extends Employee implements Comparable<Employee> {

    private int codedLines;

    public int compareTo(Employee emp) {
        return Double.compare(getSalary(), emp.getSalary());
    }



    public Developer(long id, String firstName, String lastName, double salary, int age, int codedLines) {
        super(id, firstName, lastName, salary, age);
        this.codedLines = codedLines;
    }

    public int getCodedLines() {
        return codedLines;
    }

    public void setCodedLines(int codedLines) {
        this.codedLines = codedLines;
    }


    //17
    public String toString() {
        return super.toString() + " and I am DEV, so my coded lines = " + codedLines;
    }

    //18
    double calculateSalary() {
        return codedLines * 2 + this.getSalary();
    }

    Developer() {
        this.setFirstName("SomeDev");
    }

    Developer(int codelines) {
        this.setFirstName("SomeDev");
        this.codedLines = codelines;

    }

}
