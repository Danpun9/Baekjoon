import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] graph; // 정방향 그래프
    static ArrayList<Integer>[] r_graph; // 역방향 그래프
    static boolean[] visited;
    static Stack<Integer> s = new Stack<>();
    static ArrayList<ArrayList<Integer>> SCC = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // 변수 초기화
        st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[V + 1];
        r_graph = new ArrayList[V + 1];
        visited = new boolean[V + 1];
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
            r_graph[i] = new ArrayList<>();
        }

        // 그래프 간선 그리기
        while (E-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b); // 정방향
            r_graph[b].add(a); // 역방향
        }

        // 정방향 그래프에서 dfs 끝난 순서대로 스택에 삽입
        // 모든 노드 탐색
        for (int i = 1; i <= V; i++) {
            if (visited[i]) continue;
            dfs(i);
        }

        // 역방향 그래프에서 dfs
        int res = 0;
        Arrays.fill(visited, false);
        while (!s.isEmpty()) {
            int i = s.pop(); // 스택에서 pop
            if (visited[i]) continue;

            SCC.add(new ArrayList<>());
            r_dfs(i, res++);
        }

        // 정렬
        ArrayList<Order> orderList = new ArrayList<>();
        for (int i = 0; i < res; i++) {
            Collections.sort(SCC.get(i));
            orderList.add(new Order(SCC.get(i).get(0), i));
        }
        Collections.sort(orderList);

        // 출력
        bw.write(res + "\n");
        for (Order o : orderList) {
            for (int value : SCC.get(o.idx)) {
                bw.write(value + " ");
            }
            bw.write("-1\n");
        }

        bw.close();
        br.close();
    }

    // 코사라주 알고리즘
    static void dfs(int x) {
        visited[x] = true;

        for (int next : graph[x]) {
            if (visited[next]) continue;

            dfs(next);
        }

        // dfs가 끝난 후 스택에 삽입
        s.push(x);
    }

    static void r_dfs(int x, int group) {
        visited[x] = true;
        SCC.get(group).add(x); // 현재 노드를 그룹에 포함

        for (int next : r_graph[x]) {
            if (visited[next]) continue;

            r_dfs(next, group);
        }
    }

    // SCC 정렬
    static class Order implements Comparable<Order> {
        int value; // 그룹의 첫 번째 값
        int idx; // 그룹 번호

        Order(int value, int idx) {
            this.value = value;
            this.idx = idx;
        }

        // 그룹의 첫 번째 값을 기준으로 정렬
        @Override
        public int compareTo(Order o) {
            return this.value - o.value;
        }
    }
}