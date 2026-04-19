import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        for (int i = 0; i < k; i++)
            sum += arr[i];

        int res = sum;

        int in = k, out = 0;
        for (int i = 0; i < n - k; i++) {
            sum = sum + arr[in++] - arr[out++];
            res = Math.max(res, sum);
        }

        System.out.println(res);
    }
}