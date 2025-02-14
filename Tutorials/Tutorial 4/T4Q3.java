public class T4Q3 {
    public static void main(String[] args) {
        int f1 = 1, f2 = 1;
        System.out.println(f1);
        System.out.println(f2);

        for (int i = 3; i <= 10; i++) {
            int fn = f1 + f2;
            System.out.println(fn);
            f1 = f2;
            f2 = fn;
        }
    }
}
