package week10;

public class day66_Count_occurrences_of_a_given_word_in_a_2_d_array {
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};

    int R, C;
    char[][] grid;
    String word;
    int count;

    public int findOccurrence(char mat[][], String target) {
        this.grid = mat;
        this.word = target;
        this.R = mat.length;
        this.C = mat[0].length;
        this.count = 0;

        boolean[][] visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j] == word.charAt(0)) {
                    dfs(i, j, 0, visited);
                }
            }
        }
        return count;
    }

    void dfs(int r, int c, int idx, boolean[][] visited) {
        if (idx == word.length() - 1) {
            count++;
            return;
        }

        visited[r][c] = true;

        // explore 4 directions
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (isValid(nr, nc, visited) && grid[nr][nc] == word.charAt(idx + 1)) {
                dfs(nr, nc, idx + 1, visited);
            }
        }

        visited[r][c] = false; // backtrack
    }

    boolean isValid(int r, int c, boolean[][] visited) {
        return (r >= 0 && r < R && c >= 0 && c < C && !visited[r][c]);
    }
}
