import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long k = Long.parseLong(st.nextToken());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        long res;

        if ((a < 0 && b < 0) || (a >= 0 && b >= 0)) {
            a = Math.abs(a);
            b = Math.abs(b);

            if (a > b) {
                long temp = a;
                a = b;
                b = temp;
            }

            res = b / k - a / k;
            if (a % k == 0) {
                res++;
            }
        } else {
            a = Math.abs(a);
            b = Math.abs(b);

            res = b / k + a / k + 1;
        }

        System.out.println(res);
    }
}