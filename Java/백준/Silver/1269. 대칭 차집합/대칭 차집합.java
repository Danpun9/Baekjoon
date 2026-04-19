import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<Integer> data1 = new HashSet<Integer>();
        HashSet<Integer> data2 = new HashSet<Integer>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            data1.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            data2.add(Integer.parseInt(st.nextToken()));
        }

        int cnt = 0;
        for (int i : data1) {
            if (!data2.contains(i)) {
                cnt++;
            }
        }
        for (int i : data2) {
            if (!data1.contains(i)) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}