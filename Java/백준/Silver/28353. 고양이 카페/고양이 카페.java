import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] cat = new int[n];
        for (int i = 0; i < n; i++) {
            cat[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cat);

        int res = 0, p1 = 0, p2 = n - 1;

        while (p1 < p2) {
            if (cat[p1] + cat[p2] <= k) {
                res++;
                p1++;
                p2--;
            } else {
                p2--;
            }
        }

        System.out.println(res);
    }
}