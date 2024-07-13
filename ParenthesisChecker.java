import java.util.Stack;

public class ParenthesisChecker {
    public static boolean isBalanced(String text) {
        Stack<Character> stack = new Stack<>(); //lifo mantığıyla çalıştığı için stack seçtik, stack'e son eklenen parantez ilk olarak kapanması lazım, onu pop metoduyla kontrol edeceğiz

        for (int i = 0; i < text.length(); i++) {
            char current = text.charAt(i);
            if (current == '(' || current == '{' || current == '[') {
                stack.push(current);
            } else if (current == ')' || current == '}' || current == ']') {
                //stack boşsa yani eşleştirecek bir parantez kalmamışsa, ya da isMatching metoduyla kapanış parantezi eşleşmiyorsa false döndür
                if (stack.isEmpty() || !isMatching(stack.pop(), current)) { //isMatching(char open, char close)
                    return false;
                }
            }
        }

        // pop ede ede stack'i boşalttık, eğer boşsa yani tüm parantezler eşleşmişse, yukarıdaki isMatching metoduyla, isEmpty metodu true dönerek dengeli olduğunu bildirecek
        return stack.isEmpty();
    }


    private static boolean isMatching(char open, char close) {
        if ((open == '(' && close == ')') || (open == '{' && close == '}') || (open == '[' && close == ']')) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String[] inputText = {"()", "(]", "({[]})", "({[)]}", "((()))", "(()"};

        // her ifadeyi test edip ve sonucu döndürüyorum
        for (int i = 0; i < inputText.length; i++) {
            if (isBalanced(inputText[i])) {
                System.out.println("İfade: " + inputText[i] + ", dengeli");
            } else {
                System.out.println("İfade: " + inputText[i] + ", dengesiz");
            }
        }
    }
}