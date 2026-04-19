import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        HashSet<String> data = new HashSet<String>();

        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                if (!data.contains(str.substring(i, j))) {
                    data.add(str.substring(i, j));
                }
            }
        }
        System.out.println(data.size());
    }
}
