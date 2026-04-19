import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        Long n = Long.parseLong(st.nextToken());
        Long m = Long.parseLong(st.nextToken());

        Long res = (n - 1) % (m + 1);

        if (res.equals(0l)) {
            System.out.println("Can't win");
        } else {
            System.out.println("Can win");
        }

    }
}