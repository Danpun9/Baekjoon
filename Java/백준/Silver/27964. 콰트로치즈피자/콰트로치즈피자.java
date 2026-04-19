import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        HashSet<String> cheese = new HashSet<>();

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int res = 0;
        while (n-- > 0) {
            String str = st.nextToken();
            if (str.length() >= 6 && str.substring(str.length() - 6).equals("Cheese")) {
                if (!cheese.contains(str)) {
                    res++;
                    cheese.add(str);
                }
            }
        }

        if (res >= 4) {
            bw.write("yummy");
        } else {
            bw.write("sad");
        }

        bw.flush();
    }
}