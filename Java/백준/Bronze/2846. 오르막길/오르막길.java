import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int res = 0;
        int low = -1, high = -1;
        for (int i = 0; i < n; i++) {
            int height = Integer.parseInt(st.nextToken());
            if (low == -1 || high >= height) {
                low = height;
                high = height;
            } else {
                res = Math.max(res, height - low);
                high = height;
            }
        }

        System.out.println(res);
    }
}