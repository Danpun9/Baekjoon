import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Deque<Integer> s = new LinkedList<>();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int v = 1;
        int idx = 0;
        boolean success = true;

        StringBuilder sb = new StringBuilder();

        while (success) {
            if (!s.isEmpty() && s.peekFirst() == arr[idx]) {
                idx++;
                sb.append("-\n");
                s.removeFirst();
            } else if (v <= n) {
                s.offerFirst(v++);
                sb.append("+\n");
            } else if (idx == n) {
                break;
            } else {
                success = false;
                sb = new StringBuilder().append("NO");
            }
        }

        bw.write(sb.toString());

        bw.close();
    }
}