import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int time = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        double[][] store = new double[4][4];

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int start = (int) (st.nextToken().charAt(0) - 'A');
            int end = (int) (st.nextToken().charAt(0) - 'A');
            store[start][end] = Double.parseDouble(st.nextToken());
        }

        double[] A = { 25, 25, 25, 25 };

        while (time-- > 0) {
            double[] a = new double[4];

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    a[i] += A[j] * store[j][i];
                }
            }

            A = a;
        }

        for (double persent : A) {
            System.out.println(persent);
        }
    }
}