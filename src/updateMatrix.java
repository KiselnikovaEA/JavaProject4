import java.util.ArrayDeque;
import java.util.Arrays;

public class updateMatrix {
    public static void main(String[] args) {

        int[][] matrix = new int[][]{
                {1, 1, 0, 0, 1, 0, 0, 1, 1, 0},
                {1, 0, 0, 1, 0, 1, 1, 1, 1, 1},
                {1, 1, 1, 0, 0, 1, 1, 1, 1, 0},
                {0, 1, 1, 1, 0, 1, 1, 1, 1, 1},
                {0, 0, 1, 1, 1, 1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1, 1, 0, 1, 1, 1},
                {0, 1, 1, 1, 1, 1, 1, 0, 0, 1},
                {1, 1, 1, 1, 1, 0, 0, 1, 1, 1},
                {0, 1, 0, 1, 1, 0, 1, 1, 1, 1},
                {1, 1, 1, 0, 1, 0, 1, 1, 1, 1},
        };


        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
        System.out.println();

        int[][] newMatrix = updateMatrix(matrix);
        for (int i = 0; i < newMatrix.length; i++) {
            System.out.println(Arrays.toString(newMatrix[i]));
        }

    }

    public static int[][] updateMatrix(int[][] mat) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        int[][] steps = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // вниз, вправо, вверх, влево
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new int[]{i, j});
                } else {
                    mat[i][j] = -1;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] curPoint = queue.poll();
            int curRow = curPoint[0];
            int curCol = curPoint[1];
            for (int[] step : steps) {
                int newRow = curRow + step[0];
                int newCol = curCol + step[1];
                if (newRow >= 0 && newRow < mat.length && newCol >= 0
                        && newCol < mat[0].length && mat[newRow][newCol] == -1) {
                    mat[newRow][newCol] = mat[curRow][curCol] + 1;
                    queue.add(new int[]{newRow, newCol});
                }
            }
        }

        return mat;
    }
}
