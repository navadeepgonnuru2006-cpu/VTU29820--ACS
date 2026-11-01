import java.util.*;

class Solution {
    public String longestNiceSubstring(String s) {

        String result = "";

        for (int i = 0; i < s.length(); i++) {

            for (int j = i + 1; j <= s.length(); j++) {

                String sub = s.substring(i, j);

                if (isNice(sub) && sub.length() > result.length()) {
                    result = sub;
                }
            }
        }

        return result;
    }

    public boolean isNice(String s) {

        HashSet<Character> set = new HashSet<>();

        for (char ch : s.toCharArray()) {
            set.add(ch);
        }

        for (char ch : set) {

            if (Character.isLowerCase(ch)) {
                if (!set.contains(Character.toUpperCase(ch))) {
                    return false;
                }
            }

            if (Character.isUpperCase(ch)) {
                if (!set.contains(Character.toLowerCase(ch))) {
                    return false;
                }
            }
        }

        return true;
    }
}
