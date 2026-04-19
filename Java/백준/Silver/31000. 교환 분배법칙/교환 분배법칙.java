import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int res = 0;

        for (int a = -n; a <= n; a++) {
            if (a == 0) {
                res += Math.pow(2 * n + 1, 2);
                continue;
            }

            for (int b = -n; b <= n; b++) {
                int c = 1 - a - b;
                if (c >= -n && c <= n) {
                    res++;
                }
            }
        }

        System.out.println(res);
    }
}