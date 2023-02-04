package stk_que;

import java.util.Stack;
import java.util.StringTokenizer;

public class PrefixEvaluater {
    public static boolean isOperator(String s) {
        return (s.equals("+") || s.equals("-") ||
                s.equals("*") || s.equals("/"));
    }

    public static double evaluate(String op, double n1, double n2) {
        if (op.equals("+")) return n1 + n2;
        if (op.equals("-")) return n1 - n2;
        if (op.equals("*")) return n1 * n2;
        if (op.equals("/")) {
            if (n2 == 0) throw new RuntimeException("Divided by 0.");
            return n1 / n2;
        }
        throw new RuntimeException("Operator is not supported.");
    }

    public static double evaluate(String exp) {
        //Reverse string
        String reverse = "";
        for (int i = exp.length() - 1; i >= 0; i--) reverse += exp.charAt(i);

        double result = 0;

        //Split expression to sub-strings
        StringTokenizer token = new StringTokenizer(reverse, "() ");
        Stack<Double> stk = new Stack<>();
        double n1, n2;
        while (token.hasMoreElements()) {
            String part = token.nextToken();
            if (!isOperator(part)) stk.push(Double.parseDouble(part));
            else {
                n1 = stk.pop();
                n2 = stk.pop();
                result = evaluate(part, n1, n2);
                stk.push(result);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String exp = "* + * (3) (4) * (5) (6) (3)";
        System.out.println(evaluate(exp));
    }
}
