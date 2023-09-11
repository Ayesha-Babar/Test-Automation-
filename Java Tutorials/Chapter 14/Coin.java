import java.util.Random;

public class Coin
{
    public static final String heads="Heads";
    public static final String tails="Tails";
    private static String side;



    public static int flip()
    {
        // define a range(0,1) for random class to generate numbers
        Random random= new Random();
        int randomNumber= random.nextInt(2);

        if(randomNumber==1)
        {
            side= heads;

        }
        else
        {
            side=tails;
        }
        return randomNumber;
    }


}

