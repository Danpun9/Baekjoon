import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] data = new int[5];
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            data[i] = Integer.parseInt(br.readLine());
            sum += data[i];
        }

        Arrays.sort(data);

        sb.append(sum / 5).append("\n").append(data[2]);

        System.out.println(sb);

    }
}
