import java.io.*;
import java.util.*;

public class Main {

    static int time;

    static int recusion(String str, int l, int r) {
        time++;
        if (l >= r)
            return 1;
        else if (str.charAt(l) != str.charAt(r))
            return 0;
        else
            return recusion(str, l + 1, r - 1);
    }

    static int isPalindrome(String str) {
        return recusion(str, 0, str.length() - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            time = 0;
            sb.append(isPalindrome(br.readLine())).append(" ").append(time).append("\n");
        }

        System.out.println(sb);
    }
}