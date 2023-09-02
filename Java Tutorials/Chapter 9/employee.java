package chap9;

public class employee extends person
{
    int employeeID;
    String employeeTitle;

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeTitle() {
        return employeeTitle;
    }

    public void setEmployeeTitle(String employeeTitle) {
        this.employeeTitle = employeeTitle;
    }

    // constructor
    public employee()
    {
        System.out.println(" this is employee constructor");
    }

}
