import java.io.*;

public class Main {
    static boolean[][] pattern;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        pattern = new boolean[N][N];

        star(0, 0, N, false);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (pattern[i][j]) {
                    sb.append("*");
                } else {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void star(int x, int y, int N, boolean isVoid) {
        if (isVoid) {
            for (int i = x; i < x + N; i++) {
                for (int j = y; j < y + N; j++) {
                    pattern[i][j] = false;
                }
            }
            return;
        }

        if (N == 1) {
            pattern[x][y] = true;
            return;
        }

        int lowerN = N / 3;
        int cnt = 0;
        for (int i = x; i < x + N; i += lowerN) {
            for (int j = y; j < y + N; j += lowerN) {
                cnt++;
                if (cnt == 5) {
                    star(i, j, lowerN, true);
                } else {
                    star(i, j, lowerN, false);
                }
            }
        }
    }
}