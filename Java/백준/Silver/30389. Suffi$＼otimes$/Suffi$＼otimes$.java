import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        HashSet<String> s = new HashSet<String>();
        while (n-- > 0) {
            String str = br.readLine();

            for (int length = 1; length <= str.length(); length++) {
                if (!s.contains(str.substring(str.length() - length, str.length()))) {
                    s.add(str.substring(str.length() - length, str.length()));
                } else {
                    s.remove(str.substring(str.length() - length, str.length()));
                }
            }
        }

        System.out.println(s.size());
    }
}