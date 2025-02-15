import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[n][n];
        
        for (int dist = 1; dist < n; dist++) {
            for (int start = 0; start + dist < n; start++) {
                int end = start + dist;

                dp[start][end] = Integer.MAX_VALUE;

                for (int i = start; i < end; i++) {
                    dp[start][end] = Math.min(dp[start][end], dp[start][i] + dp[i + 1][end] + arr[start][0] * arr[i][1] * arr[end][1]);
                }
            }
        }

        bw.write(String.valueOf(dp[0][n - 1]));

        bw.close();
        br.close();
    }
}