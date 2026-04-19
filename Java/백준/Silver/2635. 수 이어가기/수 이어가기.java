import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int res = 0;
        int start = Integer.parseInt(br.readLine());
        ArrayList<Integer> resList = new ArrayList<Integer>();

        for (int i = start; i > 0; i--) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(start);
            list.add(i);

            while (list.get(list.size() - 1) >= 0) {
                list.add(list.get(list.size() - 2) - list.get(list.size() - 1));
            }

            list.remove(list.size() - 1);

            if (res < list.size()) {
                res = list.size();
                resList = list;
            }
        }

        sb.append(res).append("\n");

        for (int i = 0; i < resList.size(); i++) {
            sb.append(resList.get(i)).append(" ");
        }

        System.out.println(sb);
    }
}