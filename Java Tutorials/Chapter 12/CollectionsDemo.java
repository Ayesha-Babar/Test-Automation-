import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CollectionsDemo
{
    public static void main(String args[])
    {
        setDemo();
        mapDemo();
    }

    public static void setDemo()
    {
        Set<String>fruit= new HashSet();
        fruit.add("apple");
        fruit.add("lemon");
        fruit.add("banana");
        fruit.add("orange");

        System.out.println(fruit.size());
        System.out.println(fruit);

        // iterate through sets
        System.out.println("This will print the set through iterator: ");
        var i=fruit.iterator();
        while(i.hasNext())
        {
            System.out.println(i.next());
        }

        // enhanced loops
        System.out.println("This will print the set through enhanced loops");
        for (String item:fruit)
        {
            System.out.println(item);
        }

        // for each method
        System.out.println("This will print the set through for each method");
        fruit.forEach(x-> System.out.println(x));

    }

    public static void mapDemo()
    {
        Map<String,Integer> fruit2= new HashMap();
        fruit2.put("apple",95);
        fruit2.put("orange",45);
        fruit2.put("lemons",5);

        System.out.println(fruit2.size());
        System.out.println(fruit2);

        System.out.println("iterate through enhanced loops");

        for(var entry:fruit2.entrySet() )
        {
            System.out.println(entry.getValue());
        }

        System.out.println("through for each method");
        fruit2.forEach(
                (k,v)->System.out.println("Fruit: "+k+",calories: "+v));






    }
}
