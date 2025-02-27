import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<Integer>[] graph;
    static int[] inDegree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());

            // 위상 정렬
            inDegree = new int[n + 1];
            graph = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

            // 기존 순위
            int[] rank = new int[n + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) rank[i] = Integer.parseInt(st.nextToken());

            // 바뀐 순위 기록
            int m = Integer.parseInt(br.readLine());
            HashSet<String> set = new HashSet<>();
            for (int i = 0; i < m; i++) set.add(br.readLine());

            for (int i = 1; i <= n; i++) {
                for (int j = i + 1; j <= n; j++) {
                    if (set.contains(rank[i] + " " + rank[j]) || set.contains(rank[j] + " " + rank[i])) {
                        graph[rank[j]].add(rank[i]);
                        inDegree[rank[i]]++;
                    } else {
                        graph[rank[i]].add(rank[j]);
                        inDegree[rank[j]]++;
                    }
                }
            }

            // 위상 정렬
            Queue<Integer> q = new LinkedList<>();

            for (int i = 1; i <= n; i++)
                if (inDegree[i] == 0) q.add(i);

            StringBuilder sb = new StringBuilder();

            // 위상 정렬에 같은 순위가 있으면 IMPOSSIBLE
            HashSet<Integer> s = new HashSet<>();
            boolean res = true;
            for (int i = 1; i <= n; i++) {
                if (!s.contains(inDegree[i])) {
                    s.add(inDegree[i]);
                } else {
                    sb.append("IMPOSSIBLE");
                    res = false;
                    break;
                }
            }

            // 정상적인 순위면 순위 출력
            while (!q.isEmpty() && res) {
                int curr = q.remove();

                sb.append(curr).append(" ");

                for (int i : graph[curr]) {
                    if (--inDegree[i] == 0) q.add(i);
                }
            }

            // 결과 출력
            bw.write(sb.append("\n").toString());
        }

        bw.close();
        br.close();
    }
}