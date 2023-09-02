package chap9.Assignment;
// this will be testing chain inheritance in classes.
public class TasteTester
{
    public static void main(String args[])
    {
        Cake cake1 = new Cake();
        BirthdayCake birthdaycake= new BirthdayCake();

       String taste= birthdaycake.getTaste();
       String flavor= birthdaycake.getFlavor();

       WeddingCake weddingcake= new WeddingCake();
       weddingcake.getTiers();

    }

}
