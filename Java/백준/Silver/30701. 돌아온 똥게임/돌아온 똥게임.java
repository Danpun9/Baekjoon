import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long d = Long.parseLong(st.nextToken());

        ArrayList<Integer> monster = new ArrayList<Integer>();
        ArrayList<Integer> item = new ArrayList<Integer>();

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());

            if (st.nextToken().equals("1")) {
                monster.add(Integer.parseInt(st.nextToken()));
            } else {
                item.add(Integer.parseInt(st.nextToken()));
            }
        }

        Collections.sort(monster);
        Collections.sort(item);

        int res = 0;

        while (true) {
            if (!monster.isEmpty() && d > monster.get(0)) {
                d += monster.remove(0);
                res++;
            } else if (!item.isEmpty()) {
                d *= item.remove(0);
                res++;
            } else {
                break;
            }
        }

        System.out.println(res);
    }
}