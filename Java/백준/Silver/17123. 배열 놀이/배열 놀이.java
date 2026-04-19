import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[][] arr = new int[n][n];
            int[] rsum = new int[n];
            int[] csum = new int[n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    int v = Integer.parseInt(st.nextToken());
                    arr[i][j] = v;
                    rsum[i] += v;
                    csum[j] += v;
                }
            }

            while (m-- > 0) {
                st = new StringTokenizer(br.readLine());
                int r1 = Integer.parseInt(st.nextToken()) - 1;
                int c1 = Integer.parseInt(st.nextToken()) - 1;
                int r2 = Integer.parseInt(st.nextToken()) - 1;
                int c2 = Integer.parseInt(st.nextToken()) - 1;
                int v = Integer.parseInt(st.nextToken());

                for (int i = r1; i <= r2; i++) {
                    rsum[i] += v * (c2 - c1 + 1);
                }
                for (int i = c1; i <= c2; i++) {
                    csum[i] += v * (r2 - r1 + 1);
                }
            }
            for (int rres : rsum)
                sb.append(rres).append(" ");
            sb.append("\n");
            for (int cres : csum)
                sb.append(cres).append(" ");
            sb.append("\n");
        }

        System.out.println(sb);
    }
}