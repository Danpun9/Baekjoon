import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String str = br.readLine();

            if (str.equals("end")) {
                break;
            }

            boolean acceptable = true;
            boolean isMouemContained = false;
            char prev = '.';
            int cnt = 0;

            for (int i = 0; i < str.length(); i++) {
                if (!acceptable) {
                    break;
                }

                if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o'
                        || str.charAt(i) == 'u') {
                    isMouemContained = true;
                    if (prev == 'a' || prev == 'e' || prev == 'i' || prev == 'o' || prev == 'u') {
                        cnt++;
                    } else {
                        cnt = 1;
                    }

                } else {
                    if (prev != 'a' && prev != 'e' && prev != 'i' && prev != 'o' && prev != 'u') {
                        cnt++;
                    } else {
                        cnt = 1;
                    }
                }

                if (cnt >= 3) {
                    acceptable = false;
                }

                if (str.charAt(i) == prev) {
                    if (prev != 'e' && prev != 'o') {
                        acceptable = false;
                    }
                }
                prev = str.charAt(i);
            }

            if (acceptable && isMouemContained) {
                sb.append("<").append(str).append("> is acceptable.\n");
            } else {
                sb.append("<").append(str).append("> is not acceptable.\n");
            }
        }

        System.out.println(sb);
    }
}