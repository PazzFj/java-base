package net.pazz.base;

public class AddMain {

    public static void main(String[] args) {
        int x = 1;
        x++;
        x += x;
        int n;
        if((n = ++x) < 6 || n == ++x)
            n++;

        System.out.println(x + "  " + n);

        int y = 6;
        System.out.println(y++);
        System.out.println(y++);
        System.out.println(y++);
        int z;
        System.out.println((z = y));
    }

}
