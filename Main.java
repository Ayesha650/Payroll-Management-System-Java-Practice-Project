               /* Java Project on OOPs */
               /* Teachers Payroll Manangement System */

import java.util.ArrayList;
abstract class Teacher {  // (Abstraction)

    private int id;      //(Ecapsulation)
    private String name;
    private String address;

    public Teacher(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public int getId() { // (getters methods of encapsulation)
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public abstract double CalculateSalary();

    @Override
    public String toString() {
        return "Teachers: [id=" +id + ",name="+name+",address ="+address+"]";
    }
}
class FullTime extends Teacher {

    private double monthlySalary;

    public FullTime(int id, String name, String address, double monthlySalary) {
        super(id, name, address);
        this.monthlySalary = monthlySalary;

        }

    @Override
    public double CalculateSalary() {
        return monthlySalary;
    }
}

class Partime extends Teacher {

    private int hoursWorked;
    private double hourlyRate;

    public Partime(int id, String name, String address, int hoursWorked, double hourlyRate) {
        super(id, name, address);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double CalculateSalary() {
        return hoursWorked * hourlyRate;

    }
}
class PayrollSystem {

    private ArrayList<Teacher> teacherslist;

    public PayrollSystem() {
        teacherslist = new ArrayList<>();
    }
    public void addTeacher(Teacher teacher) {  // method of adding a teacher
         teacherslist.add(teacher);

    }

    public void removeTeacher(int id) { // method for removing a teacher
        Teacher RemoveTecher = null;
        for (Teacher teacher : teacherslist) {
            if (teacher.getId() == id) {
                RemoveTecher = teacher;
                break;
            }
        }
        if (RemoveTecher != null) {
            teacherslist.remove(RemoveTecher);
        }
    }
        public void display(){   //method of displaying teachers records
            for (Teacher teachers : teacherslist) {
                System.out.println(teachers);

            }

        }
    }
    public class Main {
        public static void main(String[] args) {

            PayrollSystem pay = new PayrollSystem();

            FullTime teacher1 = new FullTime(1,"Ayesha","Hyderabd",340000.0);
            Partime teacher2 = new Partime(2,"Ahmed","Karachi",4,20);

            pay.addTeacher(teacher1);
            pay.addTeacher(teacher2);

            System.out.println("Teachers Details: ");
            pay.display();

            System.out.println("Removing Teacher: ");
            pay.removeTeacher(2);

            System.out.println("see the Remaining Teachers available now: ");
            pay.display();



        }
    }
