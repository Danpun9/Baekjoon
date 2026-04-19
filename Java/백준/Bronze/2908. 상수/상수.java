import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        String n1 = st.nextToken();
        String n2 = st.nextToken();

        String rn1 = "";
        String rn2 = "";

        for (int i = n1.length() - 1; i >= 0; i--) {
            rn1 = rn1 + n1.charAt(i);
        }
        for (int i = n2.length() - 1; i >= 0; i--) {
            rn2 = rn2 + n2.charAt(i);
        }

        if (Integer.parseInt(rn1) >= Integer.parseInt(rn2))
            System.out.println(rn1);
        else
            System.out.println(rn2);
    }
}
