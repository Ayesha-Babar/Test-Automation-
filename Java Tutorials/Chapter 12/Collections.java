import java.util.*;

public class Collections
{
    // sets can have duplicate elements
    public static void main(String args[])
    {
        System.out.println("For a Set");
        Set fruit = new HashSet();
        fruit.add("apple");
        fruit.add("lemon");
        fruit.add("banana");
        fruit.add("lemon");

        System.out.println(fruit.size());
        System.out.println("args = " + Arrays.toString(args));
        System.out.println(fruit.iterator());

        //List
        System.out.println("For a list: ");
        List fruit1 = new ArrayList();
        fruit1.add("apple");
        fruit1.add("lemon");
        fruit1.add("banana");
        fruit1.add("lemon");

        System.out.println(fruit1.get(2));
        System.out.println(fruit.size());
        System.out.println(fruit);

        //queues
        System.out.println("For a queue");
        Queue fruit3= new LinkedList();
        fruit3.add("apple");
        fruit3.add("lemon");
        fruit3.add("banana");
        fruit3.add("lemon");

        System.out.println(fruit3.size());
        System.out.println(fruit3);

        // removes the first element: apple
        fruit3.remove();
        System.out.println(fruit3);

        //prints out the last element: lemon
        System.out.println(fruit3.peek());

        //Maps
        Map fruit4= new HashMap();
        fruit4.put("apple",95);
        fruit4.put("oranges",87);
        fruit4.put("mangoes",45);

        System.out.println(fruit4.size());
        System.out.println(fruit4);

        System.out.println(fruit4.get("apple"));

        System.out.println(fruit4.entrySet());

        fruit4.remove("orange");
        System.out.println(fruit4);



    }

}
