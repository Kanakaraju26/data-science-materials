package week10;

import java.util.*;

public class day67_Find_the_string_in_grid {
    static int[] dx = {0, 0, 1, -1, 1, 1, -1, -1};
    static int[] dy = {1, -1, 0, 0, 1, -1, 1, -1};
    
    public int[][] searchWord(char[][] grid, String word) {
        int n = grid.length;
        int m = grid[0].length;
        Set<String> seen = new HashSet<>();
        List<int[]> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int dir = 0; dir < 8; dir++) {
                    if (checkWord(grid, word, i, j, dir)) {
                        String key = i + "," + j;
                        if (!seen.contains(key)) {
                            result.add(new int[]{i, j});
                            seen.add(key);
                        }
                    }
                }
            }
        }

        // Sort lexicographically
        result.sort((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });

        // Convert List<int[]> to int[][]
        int[][] resArray = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            resArray[i][0] = result.get(i)[0];
            resArray[i][1] = result.get(i)[1];
        }

        return resArray;
    }

    // Check if the word exists starting at (x, y) in direction dir
    private static boolean checkWord(char[][] grid, String word, int x, int y, int dir) {
        int n = grid.length;
        int m = grid[0].length;
        for (int k = 0; k < word.length(); k++) {
            int ni = x + k * dx[dir];
            int nj = y + k * dy[dir];

            if (ni < 0 || ni >= n || nj < 0 || nj >= m) return false; // out of bounds
            if (grid[ni][nj] != word.charAt(k)) return false;          // mismatch
        }
        return true;
    }
}