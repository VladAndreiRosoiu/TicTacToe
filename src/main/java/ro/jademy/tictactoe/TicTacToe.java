package ro.jademy.tictactoe;


import java.util.Scanner;

public class TicTacToe {
    public static char[][] board = new char[3][3];
    public static int row, col;
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println();
        System.out.println("Welcome to TicTacToe game!");

        do {
            printBoard();
            System.out.println();
            boolean isXTurn = true;
            do {
                playGame(isXTurn);
                isXTurn = !isXTurn;
            } while (!weHaveWin(!isXTurn) && !isATie());
        } while (replayGame());
    }

    public static void printBoard() {
        for (int i = 0; i < board.length; i++) {
            System.out.println();
            for (int j = 0; j < board.length; j++) {
                board[i][j] = '_';
                System.out.print("| " + board[i][j] + " |");
            }
        }
    }

    public static void playGame(boolean isXTurn) {
        char turn = isXTurn ? 'X' : '0';

        System.out.println();
        System.out.println("Player " + "\"" + turn + "\"" + ": Enter row and column:");
        row = sc.nextInt() - 1;
        col = sc.nextInt() - 1;
        checkForOverwriting();
        board[row][col] = turn;
        for (char[] chars : board) {
            System.out.println();
            for (int j = 0; j < board.length; j++) {
                System.out.print("| " + chars[j] + " |");
            }
        }
    }

    public static boolean weHaveWin(boolean isXTurn) {
        char turn = isXTurn ? 'X' : '0';
        if ((board[0][0] == turn && board[1][0] == turn && board[2][0] == turn) ||
                (board[0][1] == turn && board[1][1] == turn && board[2][1] == turn) ||
                (board[0][2] == turn && board[1][2] == turn && board[2][2] == turn) ||
                (board[0][0] == turn && board[0][1] == turn && board[0][2] == turn) ||
                (board[1][0] == turn && board[1][1] == turn && board[1][2] == turn) ||
                (board[2][0] == turn && board[2][1] == turn && board[2][2] == turn) ||
                (board[0][0] == turn && board[1][1] == turn && board[2][2] == turn) ||
                (board[0][2] == turn && board[1][1] == turn && board[2][0] == turn)) {
            System.out.println("\n" + turn + " wins!");
            return true;
        }
        return false;
    }

    public static void checkForOverwriting() {
        while (board[row][col] == 'X' || board[row][col] == '0') {
            System.out.println("Box is already filled!");
            System.out.println("Please enter row and column again!");
            row = sc.nextInt() - 1;
            col = sc.nextInt() - 1;
        }
    }

    public static boolean isATie() {
        for (char[] c : board) {
            for (int i = 0; i < board.length; i++) {
                if (c[i] == '_') {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean replayGame() {
        System.out.println("Game Over!");
        System.out.println("Play again?! Y/N:");
        String anotherGame = sc.next();

        if (anotherGame.equalsIgnoreCase("Y")) {
            return true;
        } else {
            System.out.println("Thank you for playing!");
            return false;
        }
    }
}

