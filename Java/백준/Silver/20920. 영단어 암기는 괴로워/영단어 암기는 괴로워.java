import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> word = new HashMap<String, Integer>();
        ArrayList<String> dict = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String newWord = br.readLine();
            if (newWord.length() < m) {
                continue;
            }

            if (word.containsKey(newWord)) {
                word.replace(newWord, word.get(newWord) + 1);
            } else {
                word.put(newWord, 1);
                dict.add(newWord);
            }
        }

        Collections.sort(dict, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (word.get(o1) != word.get(o2)) {
                    return word.get(o2) - word.get(o1);
                }

                if (o1.length() != o2.length()) {
                    return o2.length() - o1.length();
                }

                return o1.compareTo(o2);
            }
        });

        for (String str : dict) {
            sb.append(str).append("\n");
        }
        System.out.println(sb);
    }
}