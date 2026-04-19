import java.io.*;
import java.util.*;

public class Main {
    static int[] arr, value;
    static boolean[] visited;
    static int n, m;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];
        value = new int[n];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; ++i) {
            value[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(value);

        dfs(0);

        bw.write(sb.toString());

        bw.close();
        br.close();
    }

    static void dfs(int depth) {
        if (depth == m) {
            for (int i : arr) {
                sb.append(i + " ");
            }
            sb.append("\n");
            return;
        }

        int previous = -1;
        for (int i = 0; i < n; i++) {
            if (!visited[i] && previous != value[i]) {
                arr[depth] = previous = value[i];
                visited[i] = true;
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}
