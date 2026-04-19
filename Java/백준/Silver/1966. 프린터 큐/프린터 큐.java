import java.io.*;
import java.util.*;

class doc {
    public int num;
    public int importance;

    doc(int num, int importance) {
        this.num = num;
        this.importance = importance;
    }
}

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Queue<doc> q = new LinkedList<>();

            int N = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            int[] importance = new int[N];

            for (int i = 0; i < N; i++) {
                int a = Integer.parseInt(st.nextToken());
                q.add(new doc(i, a));
                importance[i] = a;
            }

            Arrays.sort(importance);

            int cnt = 1;

            while (!q.isEmpty()) {
                doc a = q.remove();
                if (a.importance != importance[q.size()]) {
                    q.add(a);
                } else {
                    if (a.num == num) {
                        sb.append(cnt).append("\n");
                    } else {
                        cnt++;
                    }
                }
            }
        }

        System.out.println(sb);
    }
}