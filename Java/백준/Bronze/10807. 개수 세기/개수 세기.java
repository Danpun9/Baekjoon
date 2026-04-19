import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {

            arr[i] = Integer.parseInt(st.nextToken());
        }

        int find = Integer.parseInt(br.readLine());
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if (find == arr[i])
                res++;
        }

        System.out.println(res);

        br.close();
        bw.flush();
        bw.close();

    }
}