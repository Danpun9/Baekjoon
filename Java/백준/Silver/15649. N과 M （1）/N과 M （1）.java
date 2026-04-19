import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[m];
        visited = new boolean[n];

        dfs(n, m, 0);

        System.out.println(sb);
    }

    static void dfs(int n, int m, int start) {
        if (start == m) {
            for (int v : arr) {
                sb.append(v).append(' ');
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[start] = i + 1;
                dfs(n, m, start + 1);
                visited[i] = false;
            }
        }
    }
}