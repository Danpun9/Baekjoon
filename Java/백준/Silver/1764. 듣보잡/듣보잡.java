import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Boolean> data = new HashMap<String, Boolean>();

        for (int i = 0; i < N; i++) {
            data.put(br.readLine(), false);
        }

        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            if (data.containsKey(name)) {
                list.add(name);
            }
        }

        Collections.sort(list);
        System.out.println(list.size());
        for (String i : list) {
            System.out.println(i);
        }
    }
}