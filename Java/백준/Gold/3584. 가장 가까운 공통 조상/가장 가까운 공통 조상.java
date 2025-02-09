import java.io.*;
import java.util.*;

public class Main {

    static int[] parent;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            parent = new int[n + 1];
            visited = new boolean[n + 1];

            for (int i = 0; i < n - 1; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                parent[b] = a;
            }

            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            bw.write(lca(x, y) + "\n");
        }

        bw.close();
        br.close();
    }

    static int lca(int x, int y) {
        while (x > 0) {
            visited[x] = true;
            x = parent[x];
        }

        while (y > 0) {
            if (visited[y]) break;
            y = parent[y];
        }
        return y;
    }
}