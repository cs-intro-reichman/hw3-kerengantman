// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {

    public static void main(String args[]) {
        // Tests some of the operations
        System.out.println(plus(2, 3));   // 2 + 3
        System.out.println(minus(7, 2));  // 7 - 2
        System.out.println(minus(2, 7));  // 2 - 7
        System.out.println(times(3, 4));  // 3 * 4
        System.out.println(plus(2, times(4, 2)));  // 2 + 4 * 2
        System.out.println(pow(5, 3));      // 5^3
        System.out.println(pow(3, 5));      // 3^5
        System.out.println(div(12, 3));   // 12 / 3    
        System.out.println(div(5, 5));    // 5 / 5  
        System.out.println(div(25, 7));   // 25 / 7
        System.out.println(mod(25, 7));   // 25 % 7
        System.out.println(mod(120, 6));  // 120 % 6    
        System.out.println(sqrt(36));
        System.out.println(sqrt(263169));
        System.out.println(sqrt(76123));
    }

    // Returns x1 + x2
    public static int plus(int x1, int x2) {
        int result = 0;
        if (x1 >= 0) {
            for (int i = 0; i < x1; i++) {
                result++;
            }
        } else {
            for (int i = 0; i < -x1; i++) {
                result--;
            }
        }
        if (x2 >= 0) {
            for (int j = 0; j < x2; j++) {
                result++;
            }
        } else {
            for (int j = 0; j < -x2; j++) {
                result--;
            }
        }
        return result;
    }

    // Returns x1 - x2
    public static int minus(int x1, int x2) {
        if (x2 == 0) {
            return x1;
        }
        int result = x1;
        if (x2 > 0) {
            for (int i = 0; i < x2; i++) {
                result--;
            }
        } else {
            for (int i = 0; i < -x2; i++) {
                result++;
            }
        }
        return result;
    }

    // Returns x1 * x2
    public static int times(int x1, int x2) {
        if (x2 == 0 || x1 == 0) {
            return 0;
        }
        int result = 0;
        int absX2;
        if (x2 >= 0) {
            absX2 = x2;
        } else {
            absX2 = minus(0, x2);
        }
        for (int i = 0; i < absX2; i++) {
            result = plus(result, x1);
        }
        if (x2 < 0) {
            result = minus(0, result);
        }
        return result;
    }

    // Returns x^n (for n >= 0)
    public static int pow(int x, int n) {
        if (n == 0) {
            return 1;
        }
        if (x == 0) {
            return 0;
        }
        int result = 1;
        for (int i = 0; i < n; i++) {
            result = times(result, x);
        }
        return result;
    }

    // Returns the integer part of x1 / x2 
    public static int div(int x1, int x2) {
        int x1Sign;
        if (x1 < 0) {
            x1Sign = -1;
        } else {
            x1Sign = 1;
        }

        int x2Sign;
        if (x2 < 0) {
            x2Sign = -1;
        } else {
            x2Sign = 1;
        }
        int resultSign = times(x1Sign, x2Sign);

        int absX1;
        if (x1 < 0) {
            absX1 = minus(0, x1);
        } else {
            absX1 = x1;
        }

        int absX2;
        if (x2 < 0) {
            absX2 = minus(0, x2);
        } else {
            absX2 = x2;
        }

        int count = 0;
        int sum = 0;
        while (plus(sum, absX2) <= absX1) {
            sum = plus(sum, absX2);
            count = plus(count, 1);
        }
        return times(resultSign, count);
    }

    // Returns x1 % x2 
    public static int mod(int x1, int x2) {
        int absX1;
        if (x1 < 0) {
            absX1 = minus(0, x1);
        } else {
            absX1 = x1;
        }

        int absX2;
        if (x2 < 0) {
            absX2 = minus(0, x2);
        } else {
            absX2 = x2;
        }

        int sum = 0;
        while (plus(sum, absX2) <= absX1) {
            sum = plus(sum, absX2);
        }
        return minus(absX1, sum);
    }

    // Returns the integer part of sqrt(x) 
    public static int sqrt(int x) {
        if (x < 0) {
            return -1;
        }
        int i = 0;
        while (times(i, i) <= x) {
            i = plus(i, 1);
        }
        return minus(i, 1);
    }
}
