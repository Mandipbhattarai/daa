import java.util.Scanner;

public class KnightTour {

    static int N;

    static boolean isSafe(int x, int y, int[][] solution) {
        return (x >= 0 && x < N && y >= 0 && y < N && solution[x][y] == -1);
    }

    static void printSolution(int[][] solution) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.printf("%2d ", solution[i][j]);
            }
            System.out.println();
        }
    }

    static boolean solveKnightTour(int x, int y) {
        int[][] solution = new int[N][N];

        // Initialize solution matrix
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                solution[i][j] = -1;
            }
        }

        // Define all possible moves of a knight
        int[] xMove = {2, 1, -1, -2, -2, -1, 1, 2};
        int[] yMove = {1, 2, 2, 1, -1, -2, -2, -1};

        // Start the knight at the initial position
        solution[x][y] = 0;

        // Try to solve the Knight's Tour problem
        if (!solveKTUtil(x, y, 1, solution, xMove, yMove)) {
            System.out.println("No solution exists for the given board size and starting point.");
            return false;
        } else {
            printSolution(solution);
        }
        return true;
    }

    static boolean solveKTUtil(int x, int y, int movei, int[][] solution, int[] xMove, int[] yMove) {
        if (movei == N * N) {
            return true;
        }

        for (int i = 0; i < 8; i++) {
            int next_x = x + xMove[i];
            int next_y = y + yMove[i];

            if (isSafe(next_x, next_y, solution)) {
                solution[next_x][next_y] = movei;

                if (solveKTUtil(next_x, next_y, movei + 1, solution, xMove, yMove)) {
                    return true;
                }

                // Backtrack
                solution[next_x][next_y] = -1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the chessboard (N): ");
        N = sc.nextInt();

        System.out.print("Enter the starting position (x, y): ");
        int x = sc.nextInt();
        int y = sc.nextInt();

        if (x < 0 || x >= N || y < 0 || y >= N) {
            System.out.println("Invalid starting position. It must be within the bounds of the board.");
        } else if (N <= 1) {
            System.out.println("Invalid board size. N must be greater than 1.");
        } else {
            solveKnightTour(x, y);
        }

        sc.close();
    }
}
