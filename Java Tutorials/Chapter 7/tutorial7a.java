import java.util.Arrays;
import java.util.Random;
public class tutorial7b {
   // searching arrays
    // SEQUENTIAL SEARCH METHOD
    // BINARY SEARCH METHOD
    private static final int LENGTH=6;
    private static final int MAX_TICKET_NUMBER=69;
    public static void main(String args[])
    {

        int ticket[]=generateNumbers();
        printTicket(ticket);


    }
    public static int[] generateNumbers()
    {
        int [] ticket=new int[LENGTH];
        //randomly generate numbers
        Random random= new Random();

        for(int i=0;i<LENGTH;i++)
        {   int randomNumber;
            // see if the number already exists in the array, we are doing this to avoid any duplicates in our array.
            do{
                randomNumber=random.nextInt(MAX_TICKET_NUMBER)+1;
            }while(search(ticket,randomNumber));
                //number is unique if we get here
                ticket[i]=randomNumber;
        }
        return ticket;
    }

    /**
     * does a sequential search
     * @param array  array to search through
     * @param numberToSearchFor value to search for
     * @return true if found and false if not
     */
    public static boolean search(int[]array, int numberToSearchFor)
    {
        // this is called an enhanced loop, iterates through array
        // each time assigns the current element to value
        for(int value: array)
        {
            if(value==numberToSearchFor)
                return true;
        }
        // entire array is searched and the value isnt found
        return false;

    }
    public static void printTicket(int ticket[])
    {
        for(int i=0;i<LENGTH;i++)
        {
            System.out.println(ticket[i]+"|");
        }
    }
    //Binary search
    public static boolean binarySearch(int[] array,int NumberToSearchFor)
    {
        // sort the array first
        Arrays.sort(array);
        int index=Arrays.binarySearch(array,NumberToSearchFor);

        if(index>=0)
            return true;
        else return false;
    }

}
