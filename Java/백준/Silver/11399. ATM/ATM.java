import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        for (int i = 1; i < n; i++) {
            arr[i] = arr[i] + arr[i - 1];
        }

        int sum = 0;
        for (int a : arr) {
            sum += a;
        }

        bw.write(String.valueOf(sum));

        bw.close();
        br.close();
    }
}