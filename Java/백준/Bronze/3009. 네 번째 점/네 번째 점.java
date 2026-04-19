import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        int[] x = new int[3];
        int[] y = new int[3];

        for (int i = 0; i < x.length; i++) {
            st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x.length; j++) {
                if (x[i] == x[j] && i != j) {
                    x[i] = 0;
                    x[j] = 0;
                }
                if (y[i] == y[j] && i != j) {
                    y[i] = 0;
                    y[j] = 0;
                }
            }
        }
        for (int i = 0; i < x.length; i++)
            if (x[i] != 0)
                sb.append(x[i]).append(" ");
        for (int i = 0; i < y.length; i++)
            if (y[i] != 0)
                sb.append(y[i]);

        System.out.println(sb);
    }
}
