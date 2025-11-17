// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {

    public static void main(String args[]) {
        // Tests some of the operations
        // System.out.println(plus(2, 3));   // 2 + 3
        // System.out.println(minus(7, 2));  // 7 - 2
        // System.out.println(minus(2, 7));  // 2 - 7
        // System.out.println(times(3, 4));  // 3 * 4
        // System.out.println(plus(2, times(4, 2)));  // 2 + 4 * 2
        // System.out.println(pow(5, 3));      // 5^3
        // System.out.println(pow(3, 5));      // 3^5
        // System.out.println(div(12, 3));   // 12 / 3    
        // System.out.println(div(5, 5));    // 5 / 5  
        // System.out.println(div(25, 7));   // 25 / 7
        // System.out.println(mod(25, 7));   // 25 % 7
        // System.out.println(mod(120, 6));  // 120 % 6    
        System.out.println(sqrt(36));
        System.out.println(sqrt(263169));
        System.out.println(sqrt(76123));
    }

    // Returns x1 + x2
    public static int plus(int x1, int x2) {
        int finalplus = 0;
        for (int i = 0; i < x1; i++) {
            finalplus++;
        }
        for (int j = 0; j < x2; j++) {
            finalplus++;
        }
        return finalplus;
    }

    // Returns x1 - x2
    public static int minus(int x1, int x2) {
        int finalminus;
        if (x1 > x2) {
            finalminus = x1;
            for (int i = 0; i < x2; i++) {
                finalminus = finalminus - 1;
            }
            return finalminus;
        } else {
            finalminus = x1;
            for (int i = 0; i < x2; i++) {
                finalminus = finalminus - 1;
            }
        }
        return finalminus;
    }

    // Returns x1 * x2
    public static int times(int x1, int x2) {
        int finaltimes = 0;
        for (int i = 0; i < x2; i++) {
            finaltimes = plus(finaltimes, x1);
        }
        return finaltimes;
    }

    // Returns x^n (for n >= 0)
    public static int pow(int x, int n) {
        int finalpow;
        if (x < n) {
            finalpow = 1;
            for (int i = 0; i < x; i++) {
                finalpow = times(finalpow, n);
            }
        } else {
            finalpow = 1;
            for (int i = 0; i < n; i++) {
                finalpow = times(finalpow, x);
            }
        }
        return finalpow;
    }

    // Returns the integer part of x1 / x2 
    public static int div(int x1, int x2) {
        int sum = 0;
        int count = 0;
        while (sum + x2 <= x1) {
            sum = plus(sum, x2);
            count = plus(count, 1);
        }
        return count;
    }

    // Returns x1 % x2 
    public static int mod(int x1, int x2) {
        int sum = 0;
        while (sum + x2 <= x1) {
            sum = plus(sum, x2);
        }
        return minus(x1, sum);
    }

    // Returns the integer part of sqrt(x) 
    public static int sqrt(int x) {
        int i = 0;
        while (times(i, i) <= x) {
            i = plus(i, 1);
        }
        return minus(i, 1);
    }
}
