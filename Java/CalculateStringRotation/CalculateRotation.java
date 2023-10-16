public class CalculateRotation {
    public static void main(String[] args) {
        int res = shiftedDiff("coffee", "eecoff"); //An example from testcases;
        System.out.println(res);
    }

    static int shiftedDiff(String first, String second) {
        if(first.equals(second)) {return 0;}
        if(first.length() != second.length()) {
            return -1;
        }
        int res = 0;
        StringBuilder str = new StringBuilder(first);
    
        for(int i = 0; i <= str.length()-1; i++) {
            str.insert(0, str.charAt(str.length()-1)); //Sets the last element to the first thus shifting the order
            str.deleteCharAt(str.length()-1); //Removes the last index, since it has been moved to the first
            res++;
            System.out.println(str);
            if(str.toString().equals(second)) {
                return res;
            }
        }
        return -1;
    }
}

/* This is a crude usage of StringBuilder, but it works.
 * Another way to solve this could be using streams, or just using a list with the package collections rotate function, which rotates the elements in a list by a specified distance.
 * In my case, I wanted to be 'special' and do it the non-obvious way.
 * This code has the runtime of O(N^2). The reason for this is that it (potentially) goes through N elements in the stringbuffer, and for each element it shifts all the indexes (Because of insert).
 * Therefore it needs to go through all the elements again, once insert it called, to shift indexes. 
 * This would however also be the case for collections.rotate.
 * 
 * Another way to solve it would be: (second + second).indexOf(first);
 */