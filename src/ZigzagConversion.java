import java.util.ArrayList;
import java.util.List;

public class ZigzagConversion {
    public static void main(String[] args) {
        String str = "PAYPALISHIRING";
        int numOfRows = 3;
        System.out.println(convert(str, numOfRows));
    }

    public static String convert(String str, int numOfRows){
        if(numOfRows == 1 || numOfRows >= str.length()){
            return str;
        }
        int down = 1;
        int index = 0;
        List<Character>[] rows = new ArrayList[numOfRows];
        for(int i = 0; i < numOfRows; i++){
            rows[i] = new ArrayList<>();
        }
        for(char c : str.toCharArray()){
            rows[index].add(c);
            if(index == 0){
                down = 1;
            }
            else if(index == numOfRows - 1){
                down = -1;
            }
            index += down;
        }
        StringBuilder sb = new StringBuilder();
        for(List<Character> row : rows){
            for(char c : row){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
