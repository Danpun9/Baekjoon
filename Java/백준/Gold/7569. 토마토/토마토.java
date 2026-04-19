import java.io.*;
import java.util.*;

public class Main {

    static int[][][] box;
    static int[][][] day;
    static int N, M, H;

    static class Tomato {
        int x, y, z;

        Tomato(int y, int x, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    static Queue<Tomato> q = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        box = new int[N][M][H];
        day = new int[N][M][H];
        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    box[i][j][k] = Integer.parseInt(st.nextToken());
                    if (box[i][j][k] == 1) {
                        q.add(new Tomato(i, j, k));
                    }
                }
            }
        }
        BFS();

        System.out.println(maxDay());
    }

    static void BFS() {
        int[] dx = { 1, -1, 0, 0, 0, 0 };
        int[] dy = { 0, 0, 1, -1, 0, 0 };
        int[] dz = { 0, 0, 0, 0, 1, -1 };

        while (!q.isEmpty()) {
            Tomato tomato = q.remove();

            for (int i = 0; i < 6; i++) {
                int nx = tomato.x + dx[i];
                int ny = tomato.y + dy[i];
                int nz = tomato.z + dz[i];

                if (nx < 0 || ny < 0 || nx >= M || ny >= N || nz < 0 || nz >= H) {
                    continue;
                }
                if (box[ny][nx][nz] == 0) {
                    box[ny][nx][nz] = 1;
                    day[ny][nx][nz] = day[tomato.y][tomato.x][tomato.z] + 1;
                    q.add(new Tomato(ny, nx, nz));
                }
            }
        }
    }

    static int maxDay() {
        int max = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < H; k++) {
                    if (box[i][j][k] == 0) {
                        return -1;
                    }
                    max = Math.max(max, day[i][j][k]);
                }

            }
        }

        return max;
    }
}