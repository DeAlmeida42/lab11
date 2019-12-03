import java.util.*;
public class ConnectFour
{
    public static void printBoard(char[][] array)
    {
        for(int row = 0; row < array.length; row++)
        {
            System.out.println(String.valueOf(array[row]));
        }
    }
    public static void initializeBoard(char[][] array)
    {
        for(int row = 0; row < array.length; row++)
        {
            for(int column = 0; column < array[0].length; column++)
            {
                array[row][column] = '-';
            }
        }
    }
    public static int insertChip(char[][] array, int col, char chipType)
    {
        int row = array.length - 1;
        while(row >= 0)
        {
            if (array[row][col] == '-')
            {
                array[row][col] = chipType;
                break;
            }
            row--;
        }
        return row;
    }

    public static boolean checkIfWinner(char[][] array, int col, int row, char chipType)
    {
        int consecutive = 0;
        for(int count = 0; count < array[row].length; count++)
        {
            if(array[row][count] == chipType)
            {
                consecutive++;
                if(consecutive == 4)
                {
                    return true;
                }
            }
            else
            {
                consecutive = 0;
            }
        }
        for(int count = 0; count < array.length; count++)
        {
            if(array[count][col] == chipType)
            {
                consecutive++;
                if(consecutive == 4)
                {
                    return true;
                }
            }
            else
            {
                consecutive = 0;
            }
        }
        return false;
    }
    public static void main (String [] args)
    {
        Scanner reader = new Scanner(System.in);
        boolean winner = false;
        int boardHeight = 0, boardLength = 0;

        System.out.print("What would you like the height of the board to be? ");
        boardHeight = reader.nextInt();
        System.out.print("What would you like the length of the board to be? ");
        boardLength = reader.nextInt();

        char boardSize[][]= new char[boardHeight][boardLength];

        initializeBoard(boardSize);
        printBoard(boardSize);

        System.out.println("Player 1: x");
        System.out.println("Player 2: o");

        for(int count = 1; winner == false; count++)
        {
            if(count % 2 == 1)
            {
                int columnChoice = 0;
                System.out.print("Player 1: Which column would you like to choose? ");
                columnChoice = reader.nextInt();
                int rowDrop = insertChip(boardSize, columnChoice, 'x');
                printBoard(boardSize);
                winner = checkIfWinner(boardSize, columnChoice, rowDrop, 'x');
                if(winner == true)
                {
                    System.out.println("Player 1 won the game!");
                }

            }
            else if(count % 2 == 0)
            {
                int columnChoice = 0;
                System.out.print("Player 2: Which column would you like to choose? ");
                columnChoice = reader.nextInt();
                int rowDrop = insertChip(boardSize, columnChoice, 'o');
                printBoard(boardSize);
                winner = checkIfWinner(boardSize, columnChoice, rowDrop, 'o');
                if(winner == true)
                {
                    System.out.println("Player 2 won the game!");
                }
            }
            if(count == boardHeight * boardLength)
            {
                System.out.println("Draw. Nobody wins.");
                break;
            }
        }
    }


}
