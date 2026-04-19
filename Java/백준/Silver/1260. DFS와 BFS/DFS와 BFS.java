import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] graph;
    static boolean[] visited;
    static int N;

    static StringBuilder res = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        graph = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x][y] = graph[y][x] = true;
        }

        DFS(V);
        res.append("\n");
        visited = new boolean[N + 1];
        BFS(V);

        System.out.println(res);
    }

    static void DFS(int node) {
        res.append(node).append(" ");
        visited[node] = true;
        
        for (int i = 1; i <= N; i++) {
            if (graph[node][i] && !visited[i]) {
                DFS(i);
            }
        }
    }

    static void BFS(int node) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(node);
        visited[node] = true;

        while (!queue.isEmpty()) {
            node = queue.poll();
            res.append(node).append(" ");

            for (int i = 1; i <= N; i++) {
                if (graph[node][i] && !visited[i]) {
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
    }
}