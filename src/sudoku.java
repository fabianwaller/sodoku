import java.util.Arrays;
import java.util.stream.IntStream;

public class sudoku {

    public static void main(String[] args) {
        System.out.println("\n" +
                "  ____            _       _          \n" +
                " / ___|  ___   __| | ___ | | ___   _ \n" +
                " \\___ \\ / _ \\ / _` |/ _ \\| |/ / | | |\n" +
                "  ___) | (_) | (_| | (_) |   <| |_| |\n" +
                " |____/ \\___/ \\__,_|\\___/|_|\\_\\\\__,_|\n" +
                "                                     \n" +
                "Solver version: 1.0.0\n");
        solve(board);
        printBoard();
    }

    static int[][] board =  {
            { 7, 4, 0, 0, 0, 0, 3, 6, 0 },
            { 9, 0, 0, 5, 0, 4, 0, 0, 0 },
            { 5, 8, 0, 0, 0, 0, 1, 0, 0 },
            { 8, 0, 0, 6, 0, 0, 9, 0, 0 },
            { 0, 0, 0, 2, 4, 9, 0, 0, 0 },
            { 0, 0, 7, 0, 0, 8, 0, 0, 4 },
            { 0, 0, 8, 0, 0, 0, 0, 1, 6 },
            { 0, 0, 0, 1, 0, 2, 0, 0, 3 },
            { 0, 5, 3, 0, 0, 0, 0, 9, 8 }
    };

    private static boolean solve(int[][] board) {
        for(int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                if (board[row][column] == 0) {
                    for (int t = 1; t <= 9; t++) {
                        board[row][column] = t;
                        if (isValid(board, row, column) && solve(board)) {
                            return true;
                        }
                        board[row][column] = 0;
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValid(int[][] board, int row, int column) {
        return (rowConstraint(board, row) && columnConstraint(board, column) && subsectionConstraint(board, row, column));
    }

    private static boolean rowConstraint(int[][] board, int row) {
        boolean[] constraint = new boolean[9];
        return IntStream.range(0, 9).allMatch(column -> checkConstrait(board, row, constraint, column));
    }

    private static boolean columnConstraint(int[][] board, int column) {
        boolean[] constrait = new boolean[9];
        return IntStream.range(0, 9).allMatch(row -> checkConstrait(board, row, constrait, column));
    }

    private static boolean subsectionConstraint(int[][] board, int row, int column) {
        boolean[] constrait = new boolean[9];
        int subsectionRowStart = (row / 3) * 3;
        int subsectionRowEnd = subsectionRowStart + 3;
        int subsectionColumnStart = (column / 3) * 3;
        int subsectionColumnEnd = subsectionColumnStart + 3;

        for(int r = subsectionRowStart; r < subsectionRowEnd; r++) {
            for(int c = subsectionColumnStart; c < subsectionColumnEnd; c++) {
                if(!checkConstrait(board, r, constrait, c)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean checkConstrait(int[][] board, int row, boolean[] constraint, int column) {
        if(board[row][column] != 0) {
            if(!constraint[board[row][column] - 1]) {
                constraint[board[row][column] - 1] = true;
            } else {
                return false;
            }
        }
        return true;
    }

    private static void printBoard() {
        System.out.println(" ⸻ ⸻ ⸻ ⸻ ⸻ ⸻ ⸻ ");
        int rowSeperatorCounter = 0;
        for(int row = 0; row < 9; row++) {
            StringBuilder line = new StringBuilder();
            int columnSeperatorCounter = 0;
            for(int column = 0; column < 9; column++) {
                if(column == 0) {
                    line.append("|");
                }
                if(board[row][column] == 0) {
                    line.append(" ").append(" ").append(" ");
                } else {
                    line.append(" ").append(board[row][column]).append(" ");
                }
                columnSeperatorCounter++;
                if(columnSeperatorCounter == 3) {
                    line.append("|");
                    columnSeperatorCounter = 0;
                }
            }
            System.out.println(line);
            rowSeperatorCounter++;
            if(rowSeperatorCounter == 3) {
                System.out.println(" ⸻ ⸻ ⸻ ⸻ ⸻ ⸻ ⸻ ");
                rowSeperatorCounter = 0;
            }
        }
    }
}