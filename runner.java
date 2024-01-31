import java.util.Arrays;
import java.util.Scanner;

public class runner
{
    public static SetUp setUp = new SetUp();

    public static String[][][] packs = new String[8][15][];

    public static void main(String[] args) 
    {

        String[] deck = new String[packs[0].length * 3];

        clearScreen(9);

        String[] cubeList = setUp.getCube();

        int cardCount = 0;

        for (int p = 0; p < 3; p++)
        {

            for (int i = 0; i < packs.length; i++) 
            {
                for (int j = 0; j < packs[i].length; j++)
                {
                    packs[i][j] = setUp.getCard(cubeList);
                }
            }

            Scanner scan = new Scanner(System.in);
        
            for (int i = 0; i < packs[0].length; i++)
            {
                System.out.println();
                System.out.println();
                System.out.println("Pack " + (p + 1) + ": Pick " + (i + 1));
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();

                int pickNum = i;

                if (pickNum > 7)
                {
                    pickNum -= 8;
                }

                int packCount = 0;
                for (int j = 0; j < packs[0].length; j++)
                {
                    if (packs[pickNum][j] != null)
                    {
                        packCount++;

                        if (packCount < 10)
                        {
                            System.out.println(packCount + ":  " + Arrays.toString(packs[pickNum][j]));
                        }
                        else
                        {
                            System.out.println(packCount + ": " + Arrays.toString(packs[pickNum][j]));
                        }
                    }
                }
                
                int spaceCount = 0;
                
                for (int j = 0; j < packs[pickNum].length - packCount; j++)
                {
                    System.out.println();
                    spaceCount++;
                }
                
                System.out.println();
                System.out.println();
                System.out.print("Please enter the number of the card you would like to pick: ");
                
                int choice = scan.nextInt();
                
                deck[cardCount] = packs[pickNum][choice - 1][0];

                cardCount++;
                
                packs[pickNum][choice - 1] = null;

                
                
                clearScreen(packs[pickNum].length + 9 + spaceCount);
                takeAiCard(i);
            }
        }

        printDeck(deck);
    }

    public static void takeAiCard(int currentPack)
    {
        for (int i = 0; i < packs.length; i++)
        {
            if (i != currentPack)
            {
                int cardToTake = 0;
                do
                {
                    cardToTake = (int)(Math.random() * packs[i].length);
                }
                while (packs[i][cardToTake] == null);
            
                packs[i][cardToTake] = null;
            }
        }
    }

    public static void printDeck(String[] deckList)
    {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Decklist");
        System.out.println();
        System.out.println();
        for (int i = 0; i < deckList.length; i++)
        {
            System.out.println(deckList[i]);
        }
    }

    public static void clearScreen(int upAmount)
    {
        for (int i = 0; i < upAmount; i++)
        {
            System.out.print("\033[F\r");
        }

        for (int i = 0; i < upAmount; i++)
        {
            System.out.print("\033[2K");
            System.out.println();
        }
        
        for (int i = 0; i < upAmount; i++)
        {
            System.out.print("\033[F\r");
        }
    }
}