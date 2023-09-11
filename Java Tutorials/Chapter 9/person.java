package chap9;

public class person
{
    String name;
    int age;
    String gender;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    // constructor
    // the constructor of the parent class is called before that of a child class while instantiating a child class
    public person()
    {
        System.out.println("this is person's constuctor");
    }

    // create another constructor which takes name
    public person(String name)
    {
        System.out.println(" In person's second constructor, name is set.");
    }
}
