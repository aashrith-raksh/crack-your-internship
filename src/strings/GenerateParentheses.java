package strings;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    List<String> ans = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        if (n == 1) {
            ans.add("()");
            return ans;
        }
        StringBuilder s = new StringBuilder();
        s.append("(");

        helper(s, n - 1, n);

        return ans;
    }

    void helper(StringBuilder s, int left, int right) {
        // System.out.println("---------------------------");
        // System.out.println("--> s: " + s.toString());
        // System.out.println("--> left: " + left);
        // System.out.println("--> right: " + right);
        if (left == 0 && right == 0) {
            // System.out.println(" RETURNING " + s.toString());

            ans.add(s.toString());
            return;
        }

        // PROCESSING

        if (left > 0) {

            s.append("(");
            helper(s, left - 1, right);
            // System.out.println("\n\t--> calling helper(\"" + s.toString() + "\", " +
            // (left-1) + ", " + right + ")");

            s.deleteCharAt(s.length() - 1);
        }

        if (right > 0 && right > left) {

            s.append(")");
            // System.out.println("\n\t--> calling helper(\"" + s.toString() + "\", " + left
            // + ", " + (right-1) + ")");

            helper(s, left, right - 1);
            s.deleteCharAt(s.length() - 1);

        }

        return;

    }
}
