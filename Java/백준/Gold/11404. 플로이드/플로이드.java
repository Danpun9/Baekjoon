import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] city = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                city[i][j] = (i == j ? 0 : 9999999);
            }
        }

        while (m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());

            city[a][b] = Math.min(city[a][b], c);
        }

        for (int a = 0; a < n; a++) {
            for (int b = 0; b < n; b++) {
                for (int c = 0; c < n; c++) {
                    city[b][c] = Math.min(city[b][c], city[b][a] + city[a][c]);
                }
            }
        }

        for (int[] a : city) {
            for (int b : a) {
                bw.write((b == 9999999 ? "0" : String.valueOf(b)) + " ");
            }
            bw.write("\n");
        }

        bw.flush();
    }
}