package WordHuntSolver;

import java.io.*;
import java.util.*;

public class WordHuntBot {
    private Trie trie;
    private static final int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static final int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public WordHuntBot(String filename) throws IOException {
        trie = new Trie();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String word;
            while ((word = br.readLine()) != null) {
                trie.insert(word);
            }
        }
    }

    public Set<String> findWords(char[][] board) {
        Set<String> result = new HashSet<>();
        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dfs(board, visited, "", i, j, result);
            }
        }
        return result;
    }

    private void dfs(char[][] board, boolean[][] visited, String prefix, int x, int y, Set<String> result) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || visited[x][y]) {
            return;
        }

        prefix += Character.toUpperCase(board[x][y]);

        if (!trie.startsWith(prefix)) {
            return;
        }

        if (trie.search(prefix) && prefix.length() >= 3) {
            result.add(prefix);
        }

        visited[x][y] = true;

        for (int direction = 0; direction < 8; direction++) {
            int newX = x + dx[direction];
            int newY = y + dy[direction];
            dfs(board, visited, prefix, newX, newY, result);
        }

        visited[x][y] = false;
    }

}
