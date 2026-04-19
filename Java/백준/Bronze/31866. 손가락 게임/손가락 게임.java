import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int j = Integer.parseInt(st.nextToken());
        int i = Integer.parseInt(st.nextToken());

        if (j == i) {
            System.out.println("=");
            return;
        }

        if (j == 0) {
            if (i == 2 || i != 5) {
                System.out.println(">");
                return;
            }
            if (i == 5) {
                System.out.println("<");
                return;
            }
        } else if (j == 2) {
            if (i == 5 || i != 0) {
                System.out.println(">");
                return;
            }
            if (i == 0) {
                System.out.println("<");
                return;
            }
        } else if (j == 5) {
            if (i == 0 || i != 2) {
                System.out.println(">");
                return;
            }
            if (i == 2) {
                System.out.println("<");
                return;
            }
        } else {
            if (i != 0 && i != 2 && i != 5) {
                System.out.println("=");
                return;
            } else {
                System.out.println("<");
                return;
            }
        }
    }
}