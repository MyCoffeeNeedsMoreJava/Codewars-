import java.util.*;
public class Runes {
    /*
    * The expressions to be evaluated is of the form: (Expression)(Op)(Expression)(Eq)(Result)
    */
public static int solveExpression( final String expression ) {
    int missingDigit = -1; //Return this if there is no answer
    if(expression == "") { 
      return missingDigit;
    }

    String op = getOperator(expression); //Find the operator in the expression
    StringBuilder sb = new StringBuilder();
    ArrayList<String> arr = new ArrayList<>();
    for(int i = 0; i <= expression.length()-1; i++) {
        if(expression.charAt(i) == '-') {
          if(i == 0) {
            sb.append(expression.charAt(0));
            continue;
          }
          if(!Character.isDigit(expression.charAt(i-1)) && expression.charAt(i-1) != '?') {
            //This check is to make sure that the "-" is a negation of an expression and not the operator.
            sb.append(expression.charAt(i));
            continue;
          }
        }
        if(expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*' || expression.charAt(i) == '=') {
          //Skip adding the operators, instead we add the expression to the array, and reset the StringBuilder.
          //Doing this we have a list with indexed expressions
          arr.add(sb.toString());
          sb.setLength(0);
          continue;
        }
        sb.append(expression.charAt(i));
        if(i == expression.length()-1) { //Append the last index to the stringbuilder
          arr.add(sb.toString());
        } 
    }
    String sexp1 = arr.get(0).toString(); //First expression
    String sexp2 = arr.get(1).toString(); //Second expression
    String sres1 = arr.get(2).toString(); //Result
    for(int i = 0; i <= 9; i++) {
      if(i == 0) {
        if(sexp1.matches("\\-?\\?.+") || sexp2.matches("\\-?\\?.+") || sres1.matches("\\-?\\?.+")) {
          /*
          * The kata rules stated that an expression must not start with 0, if said start is a questionmark (Aside from negation).
          * Therefore we use regexp to test that if a questionmark is the beginning at index 0, we skip said index
          */
          continue;
        } 
      }
      if(sexp1.contains(Integer.toString(i)) || sexp2.contains(Integer.toString(i)) || sres1.contains(Integer.toString(i))) {
        /*
        * The kata also stated that the 'rune' must not be a known number, therefore we check if the index is already shown in the exp.
        * If so, skip it.
        */ 
        continue;
      }
      int exp1 = Integer.parseInt(sexp1.replaceAll("\\?", Integer.toString(i)));
      int exp2 = Integer.parseInt(sexp2.replaceAll("\\?", Integer.toString(i)));
      int res1 = Integer.parseInt(sres1.replaceAll("\\?", Integer.toString(i)));
      switch(op) {
          case "+":
            if(exp1 + exp2 == res1) {
              return i;
            }
            break;
          case "-":
            if(exp1 - exp2 == res1) {
              return i;
            }
            break;
          case "*":
            if(exp1 * exp2 == res1) {
              return i;
            }
      }
    }
    
		return missingDigit;
	}
  

  //Method to find the operator in the expression.
  //Since we can encounter negative numbers, testing for subtract operator can be annoying.
  //Therefore we use regex to look for plus or mult operators instead.
  //If none of those is encountered, the operator must be '-'. 
  //We can always assume that there is an operator, given the description of the expression:
  //(Exp)(op)(Exp)
  public static String getOperator(String exp) {
    if(exp.matches(".*\\+.*")) {return "+";}
    if(exp.matches(".*\\*.*")) {return "*";}
    else {return "-";}
  }

}
