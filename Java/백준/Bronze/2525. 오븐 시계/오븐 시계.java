import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int m = sc.nextInt();
        int t = sc.nextInt();

        int pm = t % 60;
        int ph = t / 60;

        if (m + pm >= 60) {
            if (h + 1 == 24)
                h = 0;
            else
                h += 1;
            m = m + pm - 60;
        } else
            m += pm;
        if (h + ph >= 24) {
            h = h + ph - 24;
        } else
            h += ph;

        System.out.println(h + " " + m);
    }
}