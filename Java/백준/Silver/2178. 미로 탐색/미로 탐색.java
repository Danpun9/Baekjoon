import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] maze;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maze = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = line.charAt(j) - '0';
            }
        }

        BFS();

        System.out.println(maze[N - 1][M - 1]);
    }

    static void BFS() {
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[] { 0, 0 });
        visited[0][0] = true;

        int[] dx = new int[] { 1, -1, 0, 0 };
        int[] dy = new int[] { 0, 0, 1, -1 };

        while (!queue.isEmpty()) {
            int[] current = queue.remove();

            for (int i = 0; i < 4; i++) {
                int nextY = current[0] + dy[i];
                int nextX = current[1] + dx[i];

                if (nextY < 0 || nextX < 0 || nextY >= N || nextX >= M) {
                    continue;
                }
                if (visited[nextY][nextX] || maze[nextY][nextX] == 0) {
                    continue;
                }

                queue.add(new int[] { nextY, nextX });
                maze[nextY][nextX] = maze[current[0]][current[1]] + 1;
                visited[nextY][nextX] = true;
            }
        }
    }
}