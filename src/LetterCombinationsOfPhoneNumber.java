import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfPhoneNumber {
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

    public static List<String> letterCombinations(String digits){
        List<String> res = new ArrayList<>();
        if(digits == null || digits.length() == 0){
            return res;
        }
        Map<Character, String> digitsToLetters = new HashMap<>();
        digitsToLetters.put('2', "abc");
        digitsToLetters.put('3', "def");
        digitsToLetters.put('4', "ghi");
        digitsToLetters.put('5', "jkl");
        digitsToLetters.put('6', "mno");
        digitsToLetters.put('7', "pqrs");
        digitsToLetters.put('8', "tuv");
        digitsToLetters.put('9', "wxyz");
        backtrack(digits, 0, new StringBuilder(), res, digitsToLetters);
        return res;
    }

    public static void backtrack(String digits, int index, StringBuilder combinations, List<String> res, Map<Character, String> digitsToLetters){
        if(index == digits.length()){
            res.add(combinations.toString());
            return;
        }
        String letters = digitsToLetters.get(digits.charAt(index));
        for(char letter : letters.toCharArray()){
            combinations.append(letter);
            backtrack(digits, index + 1, combinations, res, digitsToLetters);
            combinations.deleteCharAt(combinations.length() - 1);
        }
    }
}
