import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> data = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            data.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(data);

        for (int value : data) {
            sb.append(value).append("\n");
        }
        System.out.println(sb);
    }
}
