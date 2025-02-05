import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge> {
    int end;
    int w;

    Edge(int b, int c) {
        end = b;
        w = c;
    }

    @Override
    public int compareTo(Edge o) {
        return w - o.w;
    }
}

public class Main {
    static int n, m, t, s, g, h;
    static ArrayList<Edge>[] graph;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); // 노드 개수
            m = Integer.parseInt(st.nextToken()); // 간선 개수
            t = Integer.parseInt(st.nextToken()); // 후보 개수

            graph = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken()); // 시작 노드
            g = Integer.parseInt(st.nextToken()); // 지나간 노드1
            h = Integer.parseInt(st.nextToken()); // 지나간 노드2

            // 그래프 생성
            int w = 0; // g-h 거리
            while (m-- > 0) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                if (a == g && b == h || a == h && b == g) w = c;

                graph[a].add(new Edge(b, c));
                graph[b].add(new Edge(a, c));
            }

            // 후보 탐색
            ArrayList<Integer> res = new ArrayList<>();
            while (t-- > 0) {
                int e = Integer.parseInt(br.readLine());


                int dist = Math.min(dijkstra(s, g) + dijkstra(h, e), dijkstra(s, h) + dijkstra(g, e)) + w; // 그래프에서 g와 h를 이용하는 길 중 최단거리 탐색
                if (dist == dijkstra(s, e)) res.add(e); // s->e 최단 거리가 s->g->h->e 최단 거리와 같으면 g와 h를 지나감
            }

            // 결과 출력
            res.sort(Comparator.naturalOrder());
            for (int i : res) bw.write(i + " ");
            bw.write("\n");
        }

        bw.close();
        br.close();
    }

    // 다익스트라
    static int dijkstra(int start, int end) {
        boolean[] visited = new boolean[n + 1];
        int[] dist = new int[n + 1];
        Arrays.fill(dist, 50000001);

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        pq.add(new Edge(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Edge curr = pq.remove();

            if (visited[curr.end]) continue;

            visited[curr.end] = true;

            for (Edge next : graph[curr.end]) {
                if (visited[next.end]) continue;
                if (dist[next.end] < dist[curr.end] + next.w) continue;

                dist[next.end] = dist[curr.end] + next.w;
                pq.add(new Edge(next.end, dist[next.end]));
            }
        }

        return dist[end];
    }
}