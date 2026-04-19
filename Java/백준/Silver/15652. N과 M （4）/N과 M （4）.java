import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int n, m;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];

        dfs(1, 0);

        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }

    static void dfs(int start, int depth) {
        if (depth == m) {
            for (int v : arr) {
                sb.append(v).append(' ');
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= n; i++) {
            arr[depth] = i;
            dfs(i, depth + 1);
        }
    }
}