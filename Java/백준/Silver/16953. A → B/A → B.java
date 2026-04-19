import java.io.*;
import java.util.*;

public class Main {

    static long A, B;
    static int cnt = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());

        System.out.println(BFS());

    }

    static int BFS() {
        Queue<Long> q = new LinkedList<>();
        q.add(A);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                long x = q.remove();

                if (x == B) {
                    return cnt + 1;
                }
                if (x * 10 + 1 <= B) {
                    q.add(x * 10 + 1);
                }
                if (x * 2 <= B) {
                    q.add(x * 2);
                }
            }
            cnt++;
        }
        return -1;
    }
}