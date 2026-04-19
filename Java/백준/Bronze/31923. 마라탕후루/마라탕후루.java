import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int[] res = new int[N];
        int[] berry = new int[N];
        int[] cat = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            berry[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cat[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            res[i] = 0;
            while (berry[i] != cat[i] && res[i] < 10000) {
                berry[i] += P;
                cat[i] += Q;
                res[i]++;
            }

            if (res[i] >= 10000) {
                System.out.println("NO");
                System.exit(0);
            }
        }

        StringBuilder sb = new StringBuilder().append("YES\n");
        for (int i = 0; i < N; i++) {
            sb.append(res[i]).append(" ");
        }

        System.out.println(sb);
    }
}
