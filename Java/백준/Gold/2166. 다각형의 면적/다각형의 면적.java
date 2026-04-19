import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        long[] x = new long[n + 1];
        long[] y = new long[n + 1];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }
        x[n] = x[0];
        y[n] = y[0];

        long sum1 = 0, sum2 = 0;

        for (int i = 0; i < n; i++) {
            sum1 += x[i] * y[i + 1];
            sum2 += x[i + 1] * y[i];
        }

        double area = Math.abs(sum1 - sum2) / 2.0;

        bw.write(String.format("%.1f", area));

        bw.close();
        br.close();
    }
}