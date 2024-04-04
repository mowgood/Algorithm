class Solution {
    public int solution(String[] spell, String[] dic) {
        for (String words : dic) {
            boolean isWords = true;
            for (String s : spell) {
                if (!words.contains(s)) {
                    isWords = false;
                    break;
                }
            }
            if (isWords) return 1;
        }
        return 2;
    }
}
