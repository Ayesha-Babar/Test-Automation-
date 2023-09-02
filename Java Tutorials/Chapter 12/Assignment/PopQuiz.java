package Assignment;

import java.util.HashMap;
import java.util.Map;

public class PopQuiz
{
    public static void main(String args[])
    {
        Map<String,Integer>OriginalGrades= getOriginalGrades();
        Map<String,Integer>MakeupGrades= getMakeUpGrades();
        Map<String,Integer>FinalGrades= new HashMap();

        for (Map.Entry<String, Integer> entry : OriginalGrades.entrySet()) {
            String student = entry.getKey();
            int originalGrade = entry.getValue();
            int makeupGrade = MakeupGrades.getOrDefault(student, -1);

            // If makeup grade exists and is higher, use it; otherwise, use the original grade
            int finalGrade = makeupGrade > originalGrade ? makeupGrade : originalGrade;

            FinalGrades.put(student, finalGrade);
        }

        // Display the final grades
        for (Map.Entry<String, Integer> entry : FinalGrades.entrySet()) {
            String student = entry.getKey();
            int finalGrade = entry.getValue();
            System.out.println(student + ": " + finalGrade);
        }
    }


    public static Map getOriginalGrades()
    {
        Map grades = new HashMap();
        grades.put("Angie", 24);
        grades.put("Dave", 32);
        grades.put("Lisi", 80);
        grades.put("Raja", 50);
        grades.put("Shashi", 79);
        grades.put("Bas", 40);
        grades.put("Carlos", 59);
        grades.put("Amber", 55);
        grades.put("Rex", 95);
        grades.put("Jason", 63);
        grades.put("Nikolay", 32);

        return grades;
    }

    public static Map getMakeUpGrades()
    {

        Map grades = new HashMap();
        grades.put("Angie", 97);
        grades.put("Dave", 82);
        grades.put("Lisi", 76);
        grades.put("Raja", 89);
        grades.put("Shashi", 79);
        grades.put("Bas", 98);
        grades.put("Carlos", 80);
        grades.put("Amber", 95);
        grades.put("Rex", 90);
        grades.put("Jason", 62);
        grades.put("Nikolay", 79);

        return grades;
    }

}
