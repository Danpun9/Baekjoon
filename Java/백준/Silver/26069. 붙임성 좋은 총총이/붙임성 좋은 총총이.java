import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashSet<String> s = new HashSet<>();

        s.add("ChongChong");

        int N = Integer.parseInt(br.readLine());

        int res = 1;

        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name1 = st.nextToken();
            String name2 = st.nextToken();

            if (s.contains(name1) || s.contains(name2)) {
                if (s.contains(name1) && s.contains(name2)) {
                    continue;
                }
                s.add(name1);
                s.add(name2);
                res++;
            }
        }

        System.out.println(res);
    }
}