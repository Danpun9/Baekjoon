import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> tree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        parent = new int[N + 1];
        visited = new boolean[N + 1];

        tree = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        BFS();

        for (int i = 2; i <= N; i++) {
            sb.append(parent[i]).append("\n");
        }

        System.out.println(sb);
    }

    static void BFS() {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;

        while (!q.isEmpty()) {
            int v = q.remove();
            for (int node : tree.get(v)) {
                if (visited[node]) {
                    continue;
                }
                visited[node] = true;
                q.add(node);
                parent[node] = v;
            }
        }
    }
}