public class ParenthesisChecker2 {
   public static boolean isBalanced(String expression) {
   	int parenthesis = 0;
      int curlyBrace = 0;
      int bracket = 0;
        
        for (int i = 0; i < expression.length(); i++) {
            char x = expression.charAt(i);
            
            if(x == '(') {
                parenthesis++;
            } else if (x == '[') {
                bracket++;
            } else if (x == '{') {
                curlyBrace++;
            } else if (x == ')') {
                parenthesis--;
            } else if (x == ']') {
                bracket--;
            } else if (x == '}') {
                curlyBrace--;
            }
            
        }
        
        if(parenthesis == 0 && curlyBrace == 0 && bracket == 0) {
            return true;
        } else {
            return false;
        }
   }
   
   public static void main (String[] args) {
       String expression = "(a + (b * c) - (d / e))";
       System.out.println(isBalanced(expression));
   }
}
