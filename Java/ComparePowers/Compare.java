import java.math.BigInteger;
public class Compare {
    public static void main(String[] args) {
        int res = comparePowers(new int[]{1668000, 5750487}, new int[]{7600018,5110029}); // Insane test case from kata (Do not use to test before new solution)
        System.out.println(res);
    }

    public static int comparePowers(int[] number1, int[] number2) {
        BigInteger num1 = BigInteger.valueOf(number1[0]); //Convert base to bigint
        BigInteger num2 = BigInteger.valueOf(number2[0]); //Convert base to bigint
        BigInteger pow1 = num1.pow(number1[1]); //Use bigint power function on base + exp
        BigInteger pow2 = num2.pow(number2[1]); //Use bigint power function on base + exp

        int res = pow1.compareTo(pow2); //Returns 1 if pow1 is bigger. -1 if pow2 is bigger or 0 if equal.
        if(res == 1) {
            return -1;
        } else if(res == -1) {
            return 1;
        }
        return 0;
    }
}


/*This was a solution I came up with, which completed alot of test cases such as num1{15991, 714883}, num2{960290, 502358}
 * aswell as a lot more. It did however not have the speed to handle even larger tester cases such as:
 * num1{1668000, 5750487}, num2{7600018,5110029}.
 * This also gives some insanely large numbers. I have yet to come with a solution that can solve this efficiently.
 * I will however keep thinking about how to make this more efficient, and update with newer solutions as they come.
 * Running the aforementioned test case on my own PC took a fair amount of time (4 minutes or so, didn't time it).
*/
