import java.io.*;
import java.util.*;

public class Main {
    static int[][] maze;
    static boolean[][] visited;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static int n, m;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int startX = 0;
        int startY = 0;

        maze = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                maze[i][j] = Integer.parseInt(st.nextToken());
                if (maze[i][j] == 2) {
                    startX = j;
                    startY = i;
                }
            }
        }

        BFS(startX, startY);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(maze[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void BFS(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { y, x });
        visited[y][x] = true;
        maze[y][x] = 0;

        while (!q.isEmpty()) {
            int[] cur = q.remove();

            for (int i = 0; i < 4; i++) {
                int nx = cur[1] + dx[i];
                int ny = cur[0] + dy[i];

                if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                    continue;
                } else if (maze[ny][nx] != 0 && !visited[ny][nx]) {
                    q.add(new int[] { ny, nx });
                    visited[ny][nx] = true;
                    maze[ny][nx] = maze[cur[0]][cur[1]] + 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && maze[i][j] != 0) {
                    maze[i][j] = -1;
                }
            }
        }
    }
}
