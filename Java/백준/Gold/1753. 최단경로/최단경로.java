import java.io.*;
import java.util.*;
import java.math.*;

class Node {
    int end;
    int weight;

    public Node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }
}

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        boolean[] visited = new boolean[V + 1];
        int[] res = new int[V + 1];
        List<Node>[] list = new List[V + 1];

        for (int i = 1; i <= V; i++) {
            list[i] = new ArrayList<Node>();
            res[i] = 300001;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list[start].add(new Node(end, weight));
        }

        PriorityQueue<Node> q = new PriorityQueue<>((node1, node2) -> node1.weight - node2.weight);
        res[K] = 0;
        q.add(new Node(K, 0));

        while (!q.isEmpty()) {
            Node cur = q.remove();
            if (!visited[cur.end]) {
                visited[cur.end] = true;
            }
            for (int i = 0; i < list[cur.end].size(); i++) {
                Node next = list[cur.end].get(i);

                if (!visited[next.end] && cur.weight + next.weight < res[next.end]) {
                    res[next.end] = cur.weight + next.weight;
                    q.add(new Node(next.end, res[next.end]));
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            if (res[i] == 300001) {
                sb.append("INF\n");
            } else {
                sb.append(res[i]).append("\n");
            }
        }

        System.out.println(sb);
    }
}