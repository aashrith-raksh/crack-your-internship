package strings;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {

        String ans = "", s = strs[0];
        if (strs.length == 1)
            return strs[0];
        char ch;
        int i;

        for (int k = 0; k < s.length(); k++) {
            ch = s.charAt(k);

            for (i = 1; i <= strs.length - 1; i++) {

                if (k == strs[i].length())
                    return ans;
                if (strs[i].charAt(k) != ch) {
                    return ans;
                }
            }
            ans += ch;

        }

        return ans;
    }
}
