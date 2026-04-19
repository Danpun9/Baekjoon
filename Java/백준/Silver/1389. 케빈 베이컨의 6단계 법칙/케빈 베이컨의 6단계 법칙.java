import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] baconNum = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                baconNum[i][j] = 999999;
                if (i == j) {
                    baconNum[i][j] = 0;
                }
            }
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            baconNum[a][b] = baconNum[b][a] = 1;
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    baconNum[i][j] = Math.min(baconNum[i][j], baconNum[i][k] + baconNum[k][j]);
                }
            }
        }

        int[] res = { 999999, -1 };

        for (int i = 1; i <= N; i++) {
            int total = 0;
            for (int j = 1; j <= N; j++) {
                total += baconNum[i][j];
            }
            if (res[0] > total) {
                res[0] = total;
                res[1] = i;
            }
        }

        System.out.println(res[1]);
    }
}