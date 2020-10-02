//Simple Tic Tac Toe game made in Java, user takes turns
// between playing as X and O, user inputs move through
// row and column (i.e. 1 2). The console outputs board
// state and outputs the result of the math. Game can be
// played as many times as possible.

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Import Scanner
        Scanner sc = new Scanner(System.in);

        boolean run = true;
        while (run) {
            //Grid
            String[][] grid = new String[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    grid[i][j] = "-";
                }
            }

            //Counter
            int c = 0;
            while (check_state(grid)) {

                String player = "";
                if (c % 2 == 0) {
                    player = "X";
                } else {
                    player = "O";
                }

                while (not_empty(grid)) {
                    print_grid(grid);
                    System.out.println("Player " + player + ", please enter your move (row column)");
                    String input = sc.nextLine();
                    String[] split = input.split(" ");
                    if (grid[Integer.parseInt(split[0]) - 1][Integer.parseInt(split[1]) - 1].equals("-")) {
                        grid[Integer.parseInt(split[0]) - 1][Integer.parseInt(split[1]) - 1] = player;
                        c++;
                        break;
                    } else {
                        System.out.println("invalid input, please try again");
                    }
                }
            }

            //Match result
            print_grid(grid);
            if (not_empty(grid)) {
                int num_of_X = 0;
                int num_of_O = 0;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (grid[i][j].equals("X")) {
                            num_of_X++;
                        }
                        if (grid[i][j].equals("O")) {
                            num_of_O++;
                        }
                    }
                }
                if (num_of_X > num_of_O) {
                    System.out.println("Player X has won the game");
                } else {
                    System.out.println("Player O has won the game");
                }
            } else {
                System.out.println("The game has ended in a tie");
            }
            System.out.println("Play again? (Y/N)");
            while (true) {
                String play_again = sc.nextLine();
                if (play_again.equals("N")) {
                    run = false;
                    break;
                } else if (play_again.equals("Y")) {
                    break;
                }
                else {
                    System.out.println("Invalid input: please print Y or N");
                }
            }
        }
    }

    //Print grid
    static void print_grid(String[][] grid) {
        for (int i = 0; i < 3; i++) {
            String linex = "";
            for (int j = 0; j < 3; j++) {
                linex = linex + grid[i][j] + " ";
            }
            System.out.println(linex);
        }
    }

    //Check board state
    static boolean check_state(String[][] grid) {
        for (int i = 0; i < 3; i++) {
            if (grid[i][0].equals("X")&&grid[i][1].equals("X")&&grid[i][2].equals("X")){
                return false;
            }
            if (grid[i][0].equals("O")&&grid[i][1].equals("O")&&grid[i][2].equals("O")){
                return false;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (grid[0][i].equals("X")&&grid[1][i].equals("X")&&grid[2][i].equals("X")){
                return false;
            }
            if (grid[0][i].equals("O")&&grid[1][i].equals("O")&&grid[2][i].equals("O")){
                return false;
            }
        }
        if (grid[0][0].equals("X")&&grid[1][1].equals("X")&&grid[2][2].equals("X")){
            return false;
        }
        if (grid[0][0].equals("O")&&grid[1][1].equals("O")&&grid[2][2].equals("O")){
            return false;
        }
        if (grid[2][0].equals("X")&&grid[1][1].equals("X")&&grid[0][2].equals("X")){
            return false;
        }
        if (grid[2][0].equals("O")&&grid[1][1].equals("O")&&grid[0][2].equals("O")){
            return false;
        }
        if (!not_empty(grid)) {
            return false;
        }
        return true;
    }

    //Board not empty
    static boolean not_empty(String[][] grid) {
        int num_of_empty = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j].equals("-")) {
                    num_of_empty++;
                }
            }
        }
        if (num_of_empty == 0) {
            return false;
        }
        return true;
    }
}


