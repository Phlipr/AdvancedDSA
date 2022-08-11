package recursion;

public class Fibonacci {
    public static int fibonacciTailRecursion(int n, int fib1, int fib2) {
        if (n == 0) return fib1;
        if (n == 1) return fib2;

        return fibonacciTailRecursion(n-1, fib2, fib1 +  fib2);
    }

    public static void fibonacciIteration(int n) {
        int fib_2 = 0;
        int fib_1 = 1;

        System.out.print(fib_2 + ", ");
        System.out.print(fib_1 + ", ");
        for (int i = 2; i < n; i++) {
            int temp = fib_1;
            fib_1 += fib_2;
            fib_2 = temp;
            System.out.print(fib_1 + (i != n - 1 ? ", " : ""));
        }
    }

    public static void main(String[] args) {
        System.out.println("The 5th Fibonacci number is : " + Fibonacci.fibonacciTailRecursion(5, 0, 1));
        Fibonacci.fibonacciIteration(5);
    }
}
