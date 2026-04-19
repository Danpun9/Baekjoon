import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] data = new int[N];
        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(br.readLine());
        }

        // 자바 util Arrays 정렬 이용
        Arrays.sort(data);

        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i]);
        }
    }
}