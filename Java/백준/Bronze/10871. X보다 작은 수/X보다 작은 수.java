import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        String res = "";

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < arr.length; i++) {

            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] < x) {
                res = res + String.valueOf(arr[i]) + " ";
            }
        }
        System.out.println(res);
    }
}