import java.io.*;
import java.util.*;

public class Main {

    static int[][] box;
    static int[][] day;
    static int N, M;

    static class Tomato {
        int x, y;

        Tomato(int y, int x) {
            this.x = x;
            this.y = y;
        }
    }

    static Queue<Tomato> q = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        box = new int[N][M];
        day = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 1) {
                    q.add(new Tomato(i, j));
                }
            }
        }

        BFS();

        System.out.println(maxDay());
    }

    static void BFS() {
        int[] dx = { 1, -1, 0, 0 };
        int[] dy = { 0, 0, 1, -1 };

        while (!q.isEmpty()) {
            Tomato tomato = q.remove();

            for (int i = 0; i < 4; i++) {
                int nx = tomato.x + dx[i];
                int ny = tomato.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= M || ny >= N) {
                    continue;
                }
                if (box[ny][nx] == 0) {
                    box[ny][nx] = 1;
                    day[ny][nx] = day[tomato.y][tomato.x] + 1;
                    q.add(new Tomato(ny, nx));
                }
            }
        }
    }

    static int maxDay() {
        int max = 0;
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 0) {
                    return -1;
                }
                max = Math.max(max, day[i][j]);
            }
        }

        return max;
    }
}