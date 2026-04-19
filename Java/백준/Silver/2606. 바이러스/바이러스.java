import java.io.*;
import java.util.*;

public class Main {

    static boolean[][] graph;
    static boolean[] visited;
    static int N, res = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        graph = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a][b] = graph[b][a] = true;
        }

        System.out.println(DFS(1));
    }

    static int DFS(int node) {

        visited[node] = true;

        for (int i = 1; i <= N; i++) {
            if (graph[node][i] && !visited[i]) {
                res++;
                DFS(i);
            }
        }

        return res;
    }
}