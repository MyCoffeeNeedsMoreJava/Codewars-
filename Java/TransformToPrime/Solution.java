public class Solution {
    public static void main(String[] args) {
        int res = minimumNumber(new int[]{3,1,2});
        System.out.println(res);
    }

    public static int minimumNumber(int[] numbers) {
        int sum = 0;
        for(int i = 0; i <= numbers.length-1; i++) { //Simple sum for loop
            sum += numbers[i];
        }
        int prime = sum;
        while(!isPrime(prime)) { // Will check every number above the sum to find the closest prime. The loop ends once a number is found, and said number will be saved as the prime variable
            prime++;
        }

        return prime-sum;
    }

    public static boolean isPrime(int n) {
        if(n <= 1) { //If below 1, the number can't be a prime
            return false;
        }
        for(int i = 2; i <= Math.sqrt(n); i++) { //For a number to be prime n can't be divisible by a number between 1 and n. Thus we check if it is divisible by any of the numbers between
            if(n % i == 0) { //Simple check to see if divisible
                return false;
            }
        }
        return true;
    }
}

/*
 * The sum for loop could be replaced by a stream by using the stream java API, utilizing the simple .sum function of streams.
 * In general this method of solving for a prime isn't that efficient, since we have to loop through numbers, run a while loop, and check every number between 1 and prime variable.
 */