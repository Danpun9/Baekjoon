import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> nameKeyMap = new HashMap<>();
        HashMap<Integer, String> numKeyMap = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            nameKeyMap.put(name, i);
            numKeyMap.put(i, name);
        }

        for (int i = 0; i < M; i++) {
            String key = br.readLine();
            try {
                sb.append(numKeyMap.get(Integer.parseInt(key))).append("\n");
            } catch (NumberFormatException e) {
                sb.append(nameKeyMap.get(key)).append("\n");
            }
        }
        System.out.println(sb);
    }
}