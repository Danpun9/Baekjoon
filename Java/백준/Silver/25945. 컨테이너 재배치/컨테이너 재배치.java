import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;

        for (int i : arr) {
            sum += i;
        }
        int mid = (sum / n);

        int res1 = 0, res2 = 0;
        for (int i : arr) {
            if (i > mid + 1) {
                res1 += (i - mid - 1);
            } else if (i < mid) {
                res2 += (mid - i);
            }
        }

        bw.write(Math.max(res1, res2) + "\n");

        bw.close();
        br.close();
    }
}
