import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int s = Integer.parseInt(st.nextToken());
            arr[i] = s;
        }

        int res = 0;
        int s = 0;
        int e = 0;
        int[] cnt = new int[10];


        while (e < n) {
            cnt[arr[e++]]++;

            int kind = 0;
            for (int i : cnt)
                if (i > 0) kind++;

            while (kind > 2)
                if (--cnt[arr[s++]] == 0) kind--;

            res = Math.max(res, e - s);
        }

        bw.write(String.valueOf(res));

        bw.close();
        br.close();
    }
}