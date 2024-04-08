class Solution {
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < my_string.length(); i++) {
            if (my_string.charAt(i) <= 90) {
                sb.append(Character.toLowerCase(my_string.charAt(i)));
            }
            else {
                sb.append(Character.toUpperCase(my_string.charAt(i)));
            }
        }
        return sb.toString();
    }
}
