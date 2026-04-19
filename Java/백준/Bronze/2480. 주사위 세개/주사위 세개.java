import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        if (a == b && b == c)
            System.out.println(10000 + (1000 * a));
        else {
            if (a == b)
                System.out.println(1000 + (100 * a));
            else if (a == c)
                System.out.println(1000 + (100 * a));
            else if (b == c)
                System.out.println(1000 + (100 * b));
            else {
                int max = Math.max(a, b);
                max = Math.max(max, c);
                System.out.println(100 * max);

            }
        }
    }
}