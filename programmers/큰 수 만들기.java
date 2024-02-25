class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        
        // 풀이 1
        String[] numArr = number.split("");
        
        int start = 0;
        for (int i = 0; i < numArr.length-k; i++) {
            int max = -1;
            for (int j = start; j <= i+k; j++) {
                if (max < Integer.parseInt(numArr[j])) {
                    max = Integer.parseInt(numArr[j]);
                    start = j+1;
                }
            }
            sb.append(max);
        }
        return sb.toString();
        
        
        // 풀이 2
        /*
        int start = 0;
        for (int i = 0; i < number.length()-k; i++) {
            char max = 0;
            for (int j = start; j <= i+k; j++) {
                if(max < number.charAt(j)) {
                    max = number.charAt(j);
                    start = j+1;
                }
            }
            sb.append(max);
        }
        return sb.toString();
        */
    }
}
