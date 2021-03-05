package l1.s2.ci2;
import java.util.Stack;

public class TD2 {
    public boolean bienParanthesee(String string){
        final Stack<Character> stack = new Stack<>();
        for(int i=0; i<string.length(); i++) {
            char c = string.charAt(i);
            if (c == '(') {
                stack.push(c);
            }
            if (c == ')') {
                if (!stack.empty() && stack.peek() == '(') {
                    stack.pop();
                    continue;
                }
                stack.push(c);
            }
        }
        return stack.empty();
    }


}
