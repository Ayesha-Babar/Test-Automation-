package chap9;

public class inheritanceTester
{
    public static void main(String[] args)
    {
        person p= new person(); // prints " this is person's class"
        /* prints " this is person's class , this is employee constructor" */
        employee e= new employee();
        e.gender= "male";
        e.employeeID=0;
        e.employeeTitle="d";

        System.out.println(e.getGender());
        p.setAge(23);
        e.setEmployeeID(2);
        int employeeID = e.getEmployeeID();
        e.setEmployeeTitle("doctor");
        String title= e.getEmployeeTitle();

        // it shows that the child class can access all the methods and variables of the parent class.
    }
}
