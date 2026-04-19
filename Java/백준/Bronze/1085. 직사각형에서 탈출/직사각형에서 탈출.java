import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[4];
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (i == 2 || i == 3)
                arr[i] -= arr[i - 2];

            if (arr[i] < res)
                res = arr[i];
        }

        sb.append(res);
        System.out.println(sb);
    }
}
