import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coin = new int[n];
        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        int i = n - 1;
        int res = 0;

        while (k > 0) {
            if (k - coin[i] >= 0) {
                res += k / coin[i];
                k = k % coin[i];
                i--;
            } else {
                i--;
            }
        }

        bw.write(String.valueOf(res));

        bw.flush();
    }
}