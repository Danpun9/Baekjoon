import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        boolean[] arr = new boolean[21];
        int m = Integer.parseInt(br.readLine());

        while (m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if (cmd.equals("all")) {
                Arrays.fill(arr, true);
            } else if (cmd.equals("empty")) {
                Arrays.fill(arr, false);
            } else if (cmd.equals("add")) {
                arr[Integer.parseInt(st.nextToken())] = true;
            } else if (cmd.equals("remove")) {
                arr[Integer.parseInt(st.nextToken())] = false;
            } else if (cmd.equals("check")) {
                if (arr[Integer.parseInt(st.nextToken())]) {
                    sb.append("1\n");
                } else {
                    sb.append("0\n");
                }
            } else {
                int x = Integer.parseInt(st.nextToken());
                arr[x] = !arr[x];
            }
        }

        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }
}