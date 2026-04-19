import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        HashMap<String, Integer> data = new HashMap<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            if (!data.containsKey(name)) {
                data.put(name, 0);
            } else {
                data.remove(name);
            }
        }

        ArrayList<String> list = new ArrayList<String>(data.keySet());
        Collections.sort(list, Collections.reverseOrder());

        for (var i : list) {
            System.out.println(i);
        }
    }
}