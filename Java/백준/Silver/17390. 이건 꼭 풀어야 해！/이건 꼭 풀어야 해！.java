import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        for (int i = 0; i < n - 1; i++) {
            arr[i + 1] += arr[i];
        }

        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken()) - 2;
            int r = Integer.parseInt(st.nextToken()) - 1;

            if (l == -1 && r == 0) {
                bw.write(0 + "\n");
                continue;
            } else if (l == -1) {
                bw.write(arr[r] + "\n");
                continue;
            } else {
                bw.write((arr[r] - arr[l]) + "\n");
            }
        }

        bw.close();
        br.close();
    }
}
