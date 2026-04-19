import java.io.*;
import java.util.*;

public class Main {

    static int K;
    static int time[] = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int res = BFS(N);

        System.out.println(res);

    }

    static int BFS(int node) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        time[node] = 1;

        while (!q.isEmpty()) {
            int x = q.remove();

            if (x == K) {
                return time[x] - 1;
            }
            if (x - 1 >= 0 && time[x - 1] == 0) {
                time[x - 1] = time[x] + 1;
                q.add(x - 1);
            }
            if (x + 1 <= 100000 && time[x + 1] == 0) {
                time[x + 1] = time[x] + 1;
                q.add(x + 1);
            }
            if (x * 2 <= 100000 && time[x * 2] == 0) {
                time[x * 2] = time[x] + 1;
                q.add(x * 2);
            }
        }
        return Integer.MIN_VALUE;
    }
}