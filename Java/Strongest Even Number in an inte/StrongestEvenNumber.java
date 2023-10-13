public class StrongestEvenNumber{

    public static int strongestEven(int n, int m) {
        int big_strong = 0;
        int res = 0;
        if(n % 2 != 0) {
        n = n+1;
        }
        for(int i = n; i <= m; i += 2) { //Only iterate through even numbers
            int str = 0;
            int j = i;
        while(j % 2 == 0) { //Loop while number is even
            j = j/2;
            str++;
        }
        if(str > big_strong) { //Test for strongest number
        big_strong = str;
        res = i;
      }
    }
    return res;
    }
}

/* The Above solution was too slow to achieve the desired runtime, 
 * thus a new solution needs to be created. Runtime is something along the lines of 
 * O(n * N) where n is for the for loop. This is plainly n, since big O notation doesn't care about constants. This would in theory only go through half the iterations since only even numbers are considered.
 * N is for the while loop. It is uncertain how many iterations the while loops runs for since it differs from case to case.
 */
