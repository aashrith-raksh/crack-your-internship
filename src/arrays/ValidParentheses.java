package arrays;

public ValidParentheses{
   public boolean isValid(String s) {
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('|| s.charAt(i)=='{'|| s.charAt(i)=='['){
                st.push(s.charAt(i));
            }
            else if(s.charAt(i)==')'){
                if(st.isEmpty() || st.pop()!='('){
                    return false;
                }
            }
            else if(s.charAt(i)=='}'){
                if(st.isEmpty() || st.pop()!='{'){
                    return false;
                }
            }
            else if(s.charAt(i)==']'){
                if(st.isEmpty() || st.pop()!='['){
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
}
