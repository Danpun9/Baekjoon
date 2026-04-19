import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int[] res = new int[26];
        for (int i = 0; i < 26; i++) {
            res[i] = -1;
        }

        for (int i = 0; i < input.length(); i++) {
            char temp = input.charAt(i);
            if (res[temp - 'a'] == -1) {
                res[temp - 'a'] = i;
            }
        }

        for (int i = 0; i < 26; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
