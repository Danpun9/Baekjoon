import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static final int INF = 1_000_000_000;

    static int n, m;
    static long[][] map; // 플로이드 와샬
    static ArrayList<Edge>[] graph; // 다익스트라 간선 정보
    static ArrayList<Edge> edges; // 다익스트라 후 결과 계산용

    static class Edge implements Comparable<Edge> {
        int start;
        int end;
        long w;

        public Edge(int start, int end, Long w) {
            this.start = start;
            this.end = end;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return Long.compare(this.w, o.w);
        }
    }

    // 플로이드 와샬 알고리즘
    // 다른 정점으로 이동하는 간선이 여러개일 때 가장 빠른 간선만 필요
    static void floyd() {
        for (int k = 0; k < n; ++k)
            for (int i = 0; i < n; ++i)
                for (int j = 0; j < n; ++j)
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
    }

    static double dijkstra(int start) {
        // 다익스트라
        long[] dist = new long[n + 1];
        Arrays.fill(dist, INF);

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        pq.add(new Edge(0, start, 0L));

        dist[start] = 0;

        while (!pq.isEmpty()) {
            Edge curr = pq.remove();
            if (dist[curr.end] < curr.w) continue;
            for (Edge next : graph[curr.end]) {
                if (dist[next.end] > dist[curr.end] + next.w) {
                    dist[next.end] = dist[curr.end] + next.w;
                    pq.add(new Edge(curr.end, next.end, curr.w + next.w));
                }
            }
        }

        // 결과 계산
        double ret = 0;
        for (Edge edge : edges) {
            double temp = ((double) (edge.w + dist[edge.start] + dist[edge.end]) / 2); // 두 정점 사이의 모든 간선이 사라지는 시간
            if (ret < temp) ret = temp;
        }

        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // 입력
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new long[n + 1][n + 1];
        graph = new ArrayList[n + 1];
        edges = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            Arrays.fill(map[i], INF);
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            long w = Long.parseLong(st.nextToken());

            edges.add(new Edge(start, end, w));
            graph[start].add(new Edge(start, end, w));
            graph[end].add(new Edge(end, start, w));
            map[start][end] = Math.min(map[start][end], w);
            map[end][start] = Math.min(map[end][start], w);
        }

        // 플로이드 와샬로 두 정점을 잇는 가장 짧은 거리 구하기
        floyd();

        double res = INF;

        // 브루트포스로 모든 정점에서 다익스트라 실시
        for (int i = 1; i <= n; i++)
            res = Math.min(res, dijkstra(i));

        bw.write(res + "\n");

        bw.close();
        br.close();
    }
}
