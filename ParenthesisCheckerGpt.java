import java.util.Stack;

public class ParenthesisCheckerGpt {

    // Method to check if parentheses are balanced using a Stack
    public static boolean areParenthesesBalanced(String expression) {
        Stack<Character> stack = new Stack<>(); //lifo mantığıyla çalıştığı için onu seçtik, stack'e son eklenen parantez ilk olarak kapanması lazım

        // Traverse the expression
        for (char ch : expression.toCharArray()) {
            // If the character is an opening parenthesis, push it to the stack
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            // If the character is a closing parenthesis, check for matching
            else if (ch == ')' || ch == '}' || ch == ']') {
                // If the stack is empty or the top of the stack doesn't match, return false
                if (stack.isEmpty() || !isMatchingPair(stack.pop(), ch)) {
                    return false;
                }
            }
        }

        // If the stack is empty, all parentheses were balanced
        return stack.isEmpty();
    }

    // Helper method to check if two characters are matching pairs of parentheses
    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '{' && close == '}') ||
               (open == '[' && close == ']');
    }

    public static void main(String[] args) {
        String expression = "{[(a + b) * (c + d)]}";
        if (areParenthesesBalanced(expression)) {
            System.out.println("Balanced");
        } else {
            System.out.println("Not Balanced");
        }
    }
}
