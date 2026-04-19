import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        String res = "int";

        while (n >= 1) {
            res = "long " + res;
            n -= 4;
        }

        System.out.println(res);
    }
}