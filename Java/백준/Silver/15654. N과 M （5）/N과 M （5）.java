import java.io.*;
import java.util.*;

public class Main {
    static int[] arr, value;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[m];
        visited = new boolean[n];
        value = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            value[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(value);

        dfs(n, m, 0);

        bw.write(sb.toString());

        bw.close();
        br.close();
    }

    static void dfs(int n, int m, int depth) {
        if (depth == m) {
            for (int v : arr) {
                sb.append(value[v]).append(' ');
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i;
                dfs(n, m, depth + 1);
                visited[i] = false;
            }
        }
    }
}