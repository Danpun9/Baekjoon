import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();

        ArrayList<Integer> data = new ArrayList<Integer>();
        for (int i = 0; i < str.length(); i++) {
            data.add(Integer.parseInt(String.valueOf(str.charAt(i))));
        }

        Collections.sort(data, Comparator.reverseOrder());

        for (int i : data) {
            sb.append(i);
        }
        System.out.println(sb);
    }
}