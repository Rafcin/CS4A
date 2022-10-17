public class Sandbox {
    //A recursive function that takes an argument of int n and recursively prints all possible decimals of length n.
    public static void printDecimals(int size, int current) {
        if(!(String.valueOf(current).length() > size)) {
            System.out.println(current);
            printDecimals(size, current + 1);
        }
    }

    public static void printNumbers(int n) {
        if (n == 0) return ;
         printNumbers(n - 1);
        System.out.println(n);
    }

    public static void main(String[] args) {
        //printDecimals(2, 0);
        printNumbers(12);
    }
}
