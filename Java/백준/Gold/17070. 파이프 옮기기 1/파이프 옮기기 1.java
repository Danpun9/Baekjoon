import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int res = 0;
    static boolean[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        map = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                if (st.nextToken().equals("1")) {
                    map[i][j] = true;
                }
            }
        }

        dfs(0, 1, 0);

        bw.write(String.valueOf(res));

        bw.close();
        br.close();
    }

    static void dfs(int y, int x, int status) {
        if (y == n - 1 && x == n - 1) { // 도착
            res++;
            return;
        }

        boolean horizontal = false, vertical = false, diagonal = false;
        if (status == 0) { // ㅡ 모양
            horizontal = diagonal = true;
        } else if (status == 1) { // ㅣ 모양
            vertical = diagonal = true;
        } else if (status == 2) { // \ 모양
            horizontal = vertical = diagonal = true;
        }

        if (horizontal) {
            if (x + 1 < n && !map[y][x + 1]) {
                dfs(y, x + 1, 0);
            }
        }

        if (vertical) {
            if (y + 1 < n && !map[y + 1][x]) {
                dfs(y + 1, x, 1);
            }
        }

        if (diagonal) {
            if (y + 1 < n && x + 1 < n && !map[y + 1][x] && !map[y][x + 1] && !map[y + 1][x + 1]) {
                dfs(y + 1, x + 1, 2);
            }
        }
    }
}