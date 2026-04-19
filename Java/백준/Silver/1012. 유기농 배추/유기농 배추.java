import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] farm;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            farm = new int[M][N];
            visited = new boolean[M][N];

            while (K-- > 0) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                farm[x][y] = 1;
            }

            int cnt = 0;

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (farm[i][j] == 1 && !visited[i][j]) {
                        BFS(i, j);
                        cnt++;
                    }
                }
            }

            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }

    static void BFS(int x, int y) {
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[] { x, y });

        int[] dx = new int[] { 1, -1, 0, 0 };
        int[] dy = new int[] { 0, 0, 1, -1 };

        while (!q.isEmpty()) {
            int[] current = q.remove();

            for (int i = 0; i < 4; i++) {
                int nextX = current[0] + dx[i];
                int nextY = current[1] + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= M || nextY >= N) {
                    continue;
                }
                if (visited[nextX][nextY] || farm[nextX][nextY] == 0) {
                    continue;
                }

                q.add(new int[] { nextX, nextY });
                visited[nextX][nextY] = true;
            }
        }
    }
}
