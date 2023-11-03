package practice;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class ValidParentheses {
    //["{","(",")","}"]
    //"{()}"
    public static void main(String[] args) {
        System.out.println(isValid("{()"));
    }

    static boolean isValid(String seq){
        var dict = Map.of("(",")", "{", "}", "[", "]");
        var charSeq = seq.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < seq.length(); i++){
            if (dict.containsKey(charSeq[i])){
                if (!stack.isEmpty()){
                    var poppedEl = stack.pop();
                    if (!poppedEl.equals(dict.get(charSeq[i]))){
                        return false;
                    }
                } else {
                    stack.push(charSeq[i]);
                }
            }
        }
        return stack.isEmpty();
    }

}
