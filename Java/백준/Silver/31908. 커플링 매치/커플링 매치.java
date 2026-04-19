import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<String> names = new ArrayList<>();
        List<String> rings = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String ring = st.nextToken();
            names.add(name);
            rings.add(ring);
        }

        HashMap<String, List<String>> ringToPeople = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String name = names.get(i);
            String ring = rings.get(i);

            if (!ring.equals("-")) {
                ringToPeople.computeIfAbsent(ring, k -> new ArrayList<>()).add(name);
            }
        }

        List<String[]> couples = new ArrayList<>();

        for (Map.Entry<String, List<String>> entry : ringToPeople.entrySet()) {
            List<String> people = entry.getValue();
            if (people.size() == 2) {
                couples.add(new String[] { people.get(0), people.get(1) });
            }
        }

        StringBuilder sb = new StringBuilder();

        sb.append(couples.size()).append("\n");

        for (String[] couple : couples) {
            sb.append(couple[0]).append(" ").append(couple[1]).append("\n");
        }

        System.out.println(sb);
    }
}
