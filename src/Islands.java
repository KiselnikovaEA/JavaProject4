import java.util.ArrayDeque;

public class Islands {

    public static void main(String[] args) {
        int[][] grid = {{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 1, 1}, {0, 0, 0, 1, 1}};
        System.out.println(maxAreaOfIsland(grid));
    }

    public static int maxAreaOfIsland(int[][] grid) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        int biggestIsland = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new int[]{i, j});
                    grid[i][j] = 2;
                    biggestIsland = Math.max(biggestIsland, areaOfIsland(queue, grid));
                }
            }
        }
        return biggestIsland;
    }

    private static int areaOfIsland(ArrayDeque<int[]> queue, int[][] grid) {
        int[][] steps = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int count = 0;

        while (!queue.isEmpty()) {
            int[] curPoint = queue.poll();
            int curRow = curPoint[0];
            int curCol = curPoint[1];
            count++;

            for (int[] step : steps) {
                int newRow = curRow + step[0];
                int newCol = curCol + step[1];
                if (newRow >= 0 && newRow < grid.length &&
                        newCol >= 0 && newCol < grid[0].length &&
                        grid[newRow][newCol] == 1) {
                    queue.add(new int[]{newRow, newCol});
                    grid[newRow][newCol] = 2;
                }
            }

        }
        return count;
    }
}
