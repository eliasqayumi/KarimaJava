import java.util.Random;
import java.util.Scanner;

public class Main {
    private static char[][] game = new char[3][4];
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int columnIndex;
        int rowIndex;
        gameStart();
        displayGame();
        while (true) {
            System.out.println("First Player: please swap vertical or horizental");
            System.out.println("which row index");
            rowIndex = scanner.nextInt();
            System.out.println("which column index");
            columnIndex = scanner.nextInt();
            char temp = game[rowIndex][columnIndex];
            game[rowIndex][columnIndex] = game[rowIndex + 1][columnIndex + 1];
            game[rowIndex + 1][columnIndex + 1] = temp;
            for (int i = rowIndex; i < 2; i++)
                for (int j = columnIndex + 1; j < 3; j++)
                    if (game[rowIndex + 1][columnIndex + 1] == game[i + 1][j + 1])
                        game[i + 1][j + 1] = 0;
            displayGame();

            System.out.println("Second Player: please swap vertical or horizental");
            System.out.println("which row index");
            rowIndex = scanner.nextInt();
            System.out.println("which column index");
            columnIndex = scanner.nextInt();
            temp = game[rowIndex][columnIndex];
            game[rowIndex][columnIndex] = game[rowIndex + 1][columnIndex + 1];
            game[rowIndex + 1][columnIndex + 1] = temp;
            for (int i = rowIndex; i < 2; i++)
                for (int j = columnIndex + 1; j < 3; j++)
                    if (game[rowIndex + 1][columnIndex + 1] == game[i + 1][j + 1])
                        game[i + 1][j + 1] = 0;
            displayGame();
        }
    }

    public static void gameStart() {
        Random random = new Random();
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 4; j++)
                game[i][j] = (char) (64 + (Math.abs(random.nextInt()) % 24));
    }

    public static void displayGame() {
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 4; j++)
                System.out.print(game[i][j] + " | ");
            System.out.println();
        }
    }
}
