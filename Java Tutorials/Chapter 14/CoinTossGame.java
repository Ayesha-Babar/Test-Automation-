import java.util.Arrays;
import java.util.Scanner;

public class CoinTossGame extends Coin
{
    public static void main(String args[])
    {
        Player player1 = new Player("tom");
        Player player2 = new Player("smith");

        System.out.println(player1.getName()+", Enter your guess");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        if (choice==1)
        {
            player1.setGuess(1);

            player2.setGuess(2);
        }
        else if(choice ==2)
        {
            player1.setGuess(1);
            player2.setGuess(2);

        }
        else {
            System.out.println("Invalid choice");
            return;
        }

        int  result= flip();
        if(result == player1.getGuess())
        {
            System.out.println("player 1 wins");
        }
        else
        {
            System.out.println("player 2 wins");
        }


    }

}

