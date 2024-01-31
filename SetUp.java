import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.io.BufferedReader;
import java.io.FileReader;

public class SetUp 
{

    public static int cubeLength = 0;

    public static String[] getCube()
    {
        String cube = "vintage_cube.txt";

        Path path = Path.of(cube);

        String line = "";
        cubeLength = 0;
        
        try (BufferedReader reader = new BufferedReader(new FileReader(cube))) 
        {
                
            while ((line = reader.readLine()) != null) 
            {
                cubeLength++;
            }
        
            reader.close();
            BufferedReader reader2 = new BufferedReader(new FileReader(cube));
        
            String[] cubeList = new String[cubeLength];
        
            for (int i = 0; i < cubeLength; i++) 
            {
                line = reader2.readLine();
                cubeList[i] = line;
            }
        
            return cubeList;
        } 
        catch (IOException e) 
        {
            return new String[0];
        }
    }

    public static boolean[] usedCard;

    public static String[] getCard(String[] cube)
    {
        if (usedCard == null)
        {
            usedCard = new boolean[cubeLength];
        }

        int card = 0;

        do
        {
            card = (int)(Math.random() * cube.length);
        }
        while (usedCard[card]);

        usedCard[card] = true;

        String[] chosenCard = {cube[card]};

        return chosenCard;
    }
}
