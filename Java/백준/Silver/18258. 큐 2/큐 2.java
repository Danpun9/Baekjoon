import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        Queue<Integer> queue = new LinkedList<>();
        int back = -1;

        for (int i = Integer.parseInt(br.readLine()); i > 0; i--) {
            st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push":
                    back = Integer.parseInt(st.nextToken());
                    queue.add(back);
                    break;
                case "pop":
                    try {
                        sb.append(queue.remove()).append("\n");
                        if (queue.size() == 0)
                            back = -1;
                    } catch (Exception e) {
                        sb.append("-1").append("\n");
                    }
                    break;
                case "size":
                    sb.append(queue.size()).append("\n");
                    break;
                case "empty":
                    if (queue.size() == 0)
                        sb.append("1").append("\n");
                    else
                        sb.append("0").append("\n");
                    break;
                case "front":
                    if (queue.peek() != null)
                        sb.append(queue.peek()).append("\n");
                    else
                        sb.append("-1").append("\n");
                    break;
                case "back":
                    sb.append(back).append("\n");
                    break;
                default:
                    break;
            }
        }

        System.out.println(sb);
    }
}