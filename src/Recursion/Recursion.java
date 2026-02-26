public class Recursion {
  public static void main(String[] args) {
    System.out.println("2 ^ 10 = " + exponential(2, 10));
    print(10);
    System.out.println();
    printBackward(10);
    System.out.println();
    printOddAscending(10);
    System.out.println("\nFactorial: " + factorial(10));
    System.out.println(fib(10));
    System.out.println("no recur: " + fib_loop(10));
    System.out.println("multiply: " + multiply(3, 6));
    System.out.println("divide: 10 / 2: " + divide(10, 2));
    System.out.println("average of 1 to 7: "+ average(7));
    System.out.println("dogotogod is "+ palindrome("dogotogod") + " for palindrome.");
    System.out.println("porcupipipine is changed to " + piReplace("porcupipipine"));
  }

//  porcupine => porcu3.14ne
  // porcupipipine =>
  public static String piReplace(String str) {
    if (str.length() <= 1) return str;
    if (str.startsWith("pi")) return "3.14"+piReplace(str.substring(2));
    else return str.charAt(0) + piReplace(str.substring(1));
  }

  public static boolean palindrome(String str) {
    if (str.isEmpty() || str.length() == 1) return true;
    return (str.charAt(0) == str.charAt(str.length() - 1) && palindrome(str.substring(1, str.length() - 1)));
  }

  public static double average(int n) {
    if (n == 1) return 1;
    return (n + average(n - 1) * (n - 1)) / n;
  }

  public static int divide(int dividend, int divisor) {
    if (dividend < divisor) return 0;
    return divide(dividend - divisor, divisor) + 1;
  }

  public static int multiply(int a, int b) {
    if (b == 0) return 0;
    return multiply(a, b - 1) + a;
  }

  public static int fib(int n) {
    if (n == 0 || n == 1) {
      return n;
    }
    return fib(n - 1) + fib(n - 2);
  }

  public static int fib_loop(int n) {
    int left = 0, right = 1;
    for (int i = 2; i <= n; i++) {
      int sum = left + right;
      left = right;
      right = sum;
    }
    return right;
  }

  public static void printOddAscending(int n) {
    if (n <= 0) return;
    if (n % 2 == 0) {
      printOddAscending(n - 1);
    }
    else {
      printOddAscending(n - 2);
      System.out.print(n + " ");
    }
  }

  public static void printBackward(int n) {
    if (n == 0) return;
    System.out.print(n + " ");
    printBackward(n - 1);
  }

  public static long factorial(int n) {
    if (n == 0) return 1;
    return n * factorial(n - 1);
  }

  public static void print(int n) {
    if (n == 0) return;
    print(n - 1);
    System.out.print(n + " ");
  }

  public static int exponential(int a, int b) {
      // find exponential using recursion
      if (b == 0) return 1;
      return a * exponential(a, b - 1);
  }

}
