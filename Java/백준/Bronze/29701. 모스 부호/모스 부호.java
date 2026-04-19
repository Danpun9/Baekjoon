import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        HashMap<String, String> h = new HashMap<String, String>();
        h.put(".-", "A");
        h.put("-...", "B");
        h.put("-.-.", "C");
        h.put("-..", "D");
        h.put(".", "E");
        h.put("..-.", "F");
        h.put("--.", "G");
        h.put("....", "H");
        h.put("..", "I");
        h.put(".---", "J");
        h.put("-.-", "K");
        h.put(".-..", "L");
        h.put("--", "M");
        h.put("-.", "N");
        h.put("---", "O");
        h.put(".--.", "P");
        h.put("--.-", "Q");
        h.put(".-.", "R");
        h.put("...", "S");
        h.put("-", "T");
        h.put("..-", "U");
        h.put("...-", "V");
        h.put(".--", "W");
        h.put("-..-", "X");
        h.put("-.--", "Y");
        h.put("--..", "Z");
        h.put(".----", "1");
        h.put("..---", "2");
        h.put("...--", "3");
        h.put("....-", "4");
        h.put(".....", "5");
        h.put("-....", "6");
        h.put("--...", "7");
        h.put("---..", "8");
        h.put("----.", "9");
        h.put("-----", "0");
        h.put("--..--", ",");
        h.put(".-.-.-", ".");
        h.put("..--..", "?");
        h.put("---...", ":");
        h.put("-....-", "-");
        h.put(".--.-.", "@");

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        while (n-- > 0) {
            sb.append(h.get(st.nextToken()));
        }

        System.out.println(sb);
    }
}