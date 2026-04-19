import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int res = 0;
        int max;

        for (int i = 0; i < arr.length; i++) {
            max = arr[i];
            int cnt = 1;
            while (cnt < max) {
                cnt++;
                i++;
            }
            res++;
        }

        System.out.println(res);
    }
}