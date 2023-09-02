import static java.lang.Character.isUpperCase;

public class tutorial8b
{
    // datatypes
    // write a method to count the number of words in a string
    // and print them individually on a new line
    public static void main(String args[]){
        countWords("I love test automation");
        reverseString("Hello tau world");
        addSpaces("HeyWorldIt'sMeAngie");
    }
    public static void countWords(String text)
    {
        // space is a dilimiter
        var words= text.split("");
        int numberOfwords=words.length;

        String message=String.format("You text contains %d words:",numberOfwords);
        System.out.println(message);

        for(int i=0;i<numberOfwords;i++)
        {
            System.out.println(words[i]);
        }
    }

    public static void reverseString(String text)
    {
        for(int i=text.length()-1;i>0;i--)
            System.out.println(text.charAt(i));
    }

    public static void addSpaces(String text)
    {
        var ModifiedText= new StringBuilder(text);
        for(int i=0;i<ModifiedText.length();i++)
        {
            if((i!= 0) && isUpperCase(ModifiedText.charAt(i)))
            {
                ModifiedText.insert(i, "");
                i++;
            }

        }
    }
}
