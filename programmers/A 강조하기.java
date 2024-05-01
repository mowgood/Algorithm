import java.util.stream.Collectors;

class Solution {
    public String solution(String myString) {   
        // return myString.toLowerCase().replaceAll("a", "A");
        
        return myString.toLowerCase().chars()
            .mapToObj(ch -> ch == 'a' ? Character.toUpperCase((char) ch) : (char) ch)
            .map(Object::toString)
            .collect(Collectors.joining());
    }
}
