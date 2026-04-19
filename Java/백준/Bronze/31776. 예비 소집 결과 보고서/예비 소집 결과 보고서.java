import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int res = 0;
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t1 = Integer.parseInt(st.nextToken());
            int t2 = Integer.parseInt(st.nextToken());
            int t3 = Integer.parseInt(st.nextToken());

            if (t1 == -1) {
                continue;
            } else if (t2 == -1 && t3 == -1) {
                res++;
            } else if (t3 == -1 && t1 <= t2) {
                res++;
            } else if (t1 <= t2 && t2 <= t3) {
                res++;
            }

        }

        System.out.println(res);
    }
}