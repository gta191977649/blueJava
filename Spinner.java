import java.util.Random;
public class Spinner
{
    private int numberOfSegments;
    private String colorOne;
    private String colorTwo;
    
    
    Spinner(int InnumberOfSegments,String IncolorOne, String IncolorTwo)
    {
        numberOfSegments = InnumberOfSegments;
        colorOne = IncolorOne;
        colorTwo = IncolorTwo;
        
        displayColors();
   
    }
    
    void displayColors()
    {
        System.out.println(colorOne + " " + colorTwo);    
    }
    
    /*
     * Mapping Funcitons
     */
    void spin()
    {
        double rate = numberOfSegments * Math.random();
        System.out.println("Congratulations! You have spun a "+ rate);
    }
    void ColorIDMap2String(int colorID)
    {
        switch (colorID)
        {
            case 0: System.out.println("Red");
            case 1: System.out.println("Blue");
        }
    }
}
