class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        int open = 0;

        
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                open++;
                sb.append(ch);
            } 
            else if (ch == ')') {
                if (open > 0) {
                    open--;
                    sb.append(ch);
                }
            } 
            else {
                sb.append(ch);
            }
        }

        
        StringBuilder result = new StringBuilder();
        
        for (int i = sb.length() - 1; i >= 0; i--) {
            char ch = sb.charAt(i);

            if (ch == '(' && open > 0) {
                open--;
            } else {
                result.append(ch);
            }
        }

        return result.reverse().toString();
    }
}
