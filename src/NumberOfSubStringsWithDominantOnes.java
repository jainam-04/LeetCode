import java.util.ArrayList;
import java.util.List;

public class NumberOfSubStringsWithDominantOnes {
    public static void main(String[] args) {
        String str = "00011";
        int result = numberOfSubstrings(str);
        System.out.println(result);
    }

    public static int numberOfSubstrings(String s){
        int n = s.length();
        int[] prefix = new int[n + 1];
        for(int i = 0; i < n; i++){
            prefix[i + 1] = prefix[i] + (s.charAt(i) == '1' ? 1 : 0);
        }
        List<Integer> z = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '0'){
                z.add(i);
            }
        }
        int m = z.size();
        long ans = 0;
        int i = 0;
        while(i < n){
            if(s.charAt(i) == '0'){
                i++;
                continue;
            }
            int j = i;
            while(j < n && s.charAt(j) == '1'){
                j++;
            }
            long length = j - i;
            ans += length * (length + 1) / 2;
            i = j;
        }
        int b = (int) Math.sqrt(n) + 2;
        for(int a = 0; a < m; a++){
            int lMin = (a == 0 ? 0 : z.get(a - 1) + 1);
            int lMax = z.get(a);
            if(lMin > lMax){
                continue;
            }
            for(int c = 1; c <= b; c++){
                int d = a + c - 1;
                if(d >= m){
                    break;
                }
                int rMin = z.get(d);
                int rMax = (d + 1 < m ? z.get(d + 1) - 1 : n - 1);
                if(rMin > rMax){
                    continue;
                }
                int need = c * c;
                int r = rMin;
                for(int l = lMin; l <= lMax; l++){
                    if(prefix[rMax + 1] - prefix[l] < need){
                        continue;
                    }
                    while(r <= rMax && prefix[r + 1] - prefix[l] < need){
                        r++;
                    }
                    if(r > rMax){
                        break;
                    }
                    ans += (rMax - r + 1);
                }
            }
        }
        return (int) ans;
    }
}
