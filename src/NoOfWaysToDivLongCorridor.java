import java.util.ArrayList;

public class NoOfWaysToDivLongCorridor {
    public static void main(String[] args) {
        String corridor = "SSPPSPS";
        int result = numberOfWays(corridor);
        System.out.println(result);
    }

    public static int numberOfWays(String corridor){
        int mod = 1000000007;
        ArrayList<Integer> position = new ArrayList<>();
        for(int i = 0; i < corridor.length(); i++){
            if(corridor.charAt(i) == 'S'){
                position.add(i);
            }
        }
        if(position.size() % 2 == 1 || position.isEmpty()){
            return 0;
        }
        long result = 1;
        for(int i = 2; i < position.size(); i += 2){
            int lengthOfGap = position.get(i) - position.get(i - 1);
            result = (result * lengthOfGap) % mod;
        }
        return (int) result;
    }
}
