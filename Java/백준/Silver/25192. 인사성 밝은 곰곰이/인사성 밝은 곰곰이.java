import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = 0;

        int N = Integer.parseInt(br.readLine());

        HashSet<String> chat = new HashSet<>();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            if (str.equals("ENTER")) {
                chat = new HashSet<>();
            } else if (chat.contains(str)) {
                continue;
            } else {
                chat.add(str);
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}