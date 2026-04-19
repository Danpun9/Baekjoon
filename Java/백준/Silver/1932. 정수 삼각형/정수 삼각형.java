import java.io.*;
import java.util.*;

public class Main {

    static int[][] data;
    static Integer[][] memo;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        data = new int[n][n];
        memo = new Integer[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++)
            memo[n - 1][i] = data[n - 1][i];

        bw.write(String.valueOf(dfs(0, 0)));

        bw.close();
    }

    static int dfs(int depth, int idx) {
        if (depth == n - 1)
            return memo[depth][idx];

        if (memo[depth][idx] == null)
            memo[depth][idx] = data[depth][idx] + Math.max(dfs(depth + 1, idx), dfs(depth + 1, idx + 1));

        return memo[depth][idx];
    }
}
