import java.util.*;

public class FindAllPeopleWithSecret {
    public static void main(String[] args) {
        int n = 6;
        int[][] meetings = {
                {1, 2, 5},
                {2, 3, 8},
                {1, 5, 10}
        };
        int firstPerson = 1;
        List<Integer> result = findAllPeople(n, meetings, firstPerson);
        System.out.println(result);
    }

    public static List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson){
        Map<Integer, List<int[]>> timeMeetings = new TreeMap<>();
        for(int[] meeting : meetings){
            int x = meeting[0];
            int y = meeting[1];
            int t = meeting[2];
            timeMeetings.computeIfAbsent(t, k -> new ArrayList<>()).add(new int[]{x, y});
        }
        boolean[] ks = new boolean[n];
        ks[0] = true;
        ks[firstPerson] = true;
        for(int t : timeMeetings.keySet()){
            Map<Integer, List<Integer>> meetList = new HashMap<>();
            for(int[] meeting : timeMeetings.get(t)){
                int x = meeting[0];
                int y = meeting[1];
                meetList.computeIfAbsent(x, k -> new ArrayList<>()).add(y);
                meetList.computeIfAbsent(y, k -> new ArrayList<>()).add(x);
            }
            Set<Integer> start = new HashSet<>();
            for(int[] meeting : timeMeetings.get(t)){
                int x = meeting[0];
                int y = meeting[1];
                if(ks[x]){
                    start.add(x);
                }
                if(ks[y]){
                    start.add(y);
                }
            }
            Queue<Integer> q = new LinkedList<>(start);
            while(!q.isEmpty()){
                int person = q.poll();
                for(int nextPerson : meetList.getOrDefault(person, new ArrayList<>())){
                    if(!ks[nextPerson]){
                        ks[nextPerson] = true;
                        q.offer(nextPerson);
                    }
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(ks[i]){
                result.add(i);
            }
        }
        return result;
    }
}
