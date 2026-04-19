import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int res = 0;

        for (int i = 0; i < str.length(); i++) {

            int num = str.charAt(i);
            if (num >= 65 && num <= 67) // ABC
                res += 3;
            else if (num >= 68 && num <= 70) // DEF
                res += 4;
            else if (num >= 71 && num <= 73) // GHI
                res += 5;
            else if (num >= 74 && num <= 76) // JKL
                res += 6;
            else if (num >= 77 && num <= 79) // MNO
                res += 7;
            else if (num >= 80 && num <= 83) // PQRS
                res += 8;
            else if (num >= 84 && num <= 86) // TUV
                res += 9;
            else if (num >= 87 && num <= 90) // WXYZ
                res += 10;
        }

        System.out.println(res);
    }
}
