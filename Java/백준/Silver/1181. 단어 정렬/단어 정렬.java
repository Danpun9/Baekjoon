import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] data = new String[N];

        for (int i = 0; i < N; i++) {
            data[i] = br.readLine();
        }

        Arrays.sort(data, new Comparator<String>() {
            public int compare(String str1, String str2) {

                if (str1.length() == str2.length()) {
                    return str1.compareTo(str2);
                } else {
                    return str1.length() - str2.length();
                }
            }
        });

        System.out.println(data[0]);
        for (int i = 1; i < N; i++) {
            if (!data[i].equals(data[i - 1])) {
                System.out.println(data[i]);
            }
        }
    }
}