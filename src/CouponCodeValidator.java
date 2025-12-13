import java.util.*;

public class CouponCodeValidator {
    public static void main(String[] args) {
        String[] code = {"SAVE20", "", "PHARMA5", "SAVE@20"};
        String[] businessLine = {"restaurant", "grocery", "pharmacy", "restaurant"};
        boolean[] isActive = {true, true, true, true};
        List<String> list = validateCoupons(code, businessLine, isActive);
        System.out.println(list);
    }

    public static List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive){
        int n = code.length;
        Map<String, Integer> businessLineSortOrder = new HashMap<>();
        businessLineSortOrder.put("electronics", 0);
        businessLineSortOrder.put("grocery", 1);
        businessLineSortOrder.put("pharmacy", 2);
        businessLineSortOrder.put("restaurant", 3);
        List<CouponInfo> sortableCoupons = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(!isActive[i]){
                continue;
            }
            if(!businessLineSortOrder.containsKey(businessLine[i])){
                continue;
            }
            String c = code[i];
            if(c.isEmpty()){
                continue;
            }
            boolean isCodeValid = true;
            for(char ch : c.toCharArray()){
                if(!Character.isLetterOrDigit(ch) && ch != '_'){
                    isCodeValid = false;
                    break;
                }
            }
            if(!isCodeValid){
                continue;
            }
            int sortIndex = businessLineSortOrder.get(businessLine[i]);
            sortableCoupons.add(new CouponInfo(sortIndex, c));
        }
        Collections.sort(sortableCoupons);
        List<String> sortedValidCodes = new ArrayList<>();
        for(CouponInfo coupon : sortableCoupons){
            sortedValidCodes.add(coupon.code);
        }
        return sortedValidCodes;
    }

    static class CouponInfo implements Comparable<CouponInfo>{
        int sortIndex;
        String code;
        CouponInfo(int sortIndex, String code){
            this.sortIndex = sortIndex;
            this.code = code;
        }
        @Override
        public int compareTo(CouponInfo other){
            if(this.sortIndex != other.sortIndex){
                return Integer.compare(this.sortIndex, other.sortIndex);
            }
            return this.code.compareTo(other.code);
        }
    }
}
