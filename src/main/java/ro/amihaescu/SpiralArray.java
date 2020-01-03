package ro.amihaescu;

public class SpiralArray {
    public static int[][] spiral(int n) {
        int[][] internalSpiral = new int[n][n];
        int val = 0, row = 0, column = 0;
        int[] dc = {1, 0, -1, 0};
        int[] dr = {0, 1, 0, -1};
        int dir = 0;

        while (val++ < n * n) {
            internalSpiral[row][column] = val;
            row += dr[dir];
            column += dc[dir];
            if (isInvalid(internalSpiral, row, column)) {
                row -= dr[dir];
                column -= dc[dir];
                dir = (dir + 1) % 4;
                row += dr[dir];
                column +=dc[dir];
            }
        }
        return internalSpiral;
    }

    private static boolean isInvalid(int[][] spiral, int row, int column) {
        return row < 0 || column < 0 || row >= spiral.length || column >= spiral.length || spiral[row][column] != 0;
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] spiral = spiral(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(spiral[i][j] + " ");
            }
            System.out.println();
        }
    }
}
