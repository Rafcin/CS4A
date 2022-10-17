public class Stairs {
    public static int climb(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        return climb(n - 1) + climb(n - 2);
    }
    public static int skipper(int n, int[] sk) {
        if (n == 0) return 1;
        if (n < 0) return 0;
        int count = 0;
        for (int i = 0; i < sk.length; i++) {
            count += skipper(n - sk[i], sk);
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(skipper(9, new int[]{1, 2, 4})); //13
    }
}
