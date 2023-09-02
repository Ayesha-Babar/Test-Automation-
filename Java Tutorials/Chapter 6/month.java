package chap6tutorials;
// TUTORIAL 6d
// overloading methods, methods with same name but diff bodies
// parameter list must be diff
public class month 
{
    public static String getMonth(int month)
    { 
        switch(month)
        {
            case 1: return "Jan";
            case 2: return "feb";
            case 3: return "mar";
            case 4: return "apr";
            case 5: return "Jun";
            case 6: return "Jul";
            case 7: return "Aug";
            case 8: return "sep";
            case 9: return "oct";
            case 10: return "nov";
            case 11: return "dec";
            default: return "Invalid month. please enter a valid month.";

        }

    }
    public static int getMonth(String month)
    {
       switch(month)
       {
        case "jan":return 1;
        case "feb": return 2;
        case "mar":return 3;
        case "apr":return 4;
        case "may":return 5;
        case "jun":return 6;
        case "jul":return 7;
        case "aug":return 8;
        case "sep":return 9;
        case "oct": return 10;
        case "nov":return 11;
        case "dec":return 12;
        default: return -1;
       }

    }
    public class MonthConverter{
        public static void main(String args[])
        {  
            // there is no need to instantiate static classes:
            System.out.println(month.getMonth(2));
            System.out.println(month.getMonth("jan"));
        }
    }
}
