import java.util.*;

public class CountMentionsPerUser {
    public static void main(String[] args) {
        int numberOfUsers = 2;
        List<List<String>> events = List.of(
                List.of("MESSAGE", "10", "id0 id1"),
                List.of("OFFLINE", "11", "0"),
                List.of("MESSAGE", "71", "HERE")
        );
        int[] mentions = countMentions(numberOfUsers, events);
        for(int num : mentions){
            System.out.print(num + " ");
        }
    }

    public static int[] countMentions(int numberOfUsers, List<List<String>> events){
        TreeMap<Integer, List<List<String>>> byTime = new TreeMap<>();
        for(List<String> event : events){
            int t = Integer.parseInt(event.get(1));
            byTime.computeIfAbsent(t, k -> new ArrayList<>()).add(event);
        }
        int[] mentions = new int[numberOfUsers];
        boolean[] isOnline = new boolean[numberOfUsers];
        int[] offlineUntil = new int[numberOfUsers];
        Arrays.fill(isOnline, true);
        for(Map.Entry<Integer, List<List<String>>> entry : byTime.entrySet()){
            int t = entry.getKey();
            List<List<String>> evs = entry.getValue();
            for(int i = 0; i < numberOfUsers; ++i){
                if(!isOnline[i] && offlineUntil[i] <= t){
                    isOnline[i] = true;
                    offlineUntil[i] = 0;
                }
            }
            for(List<String> ev : evs){
                if(ev.get(0).equals("OFFLINE")){
                    int id = Integer.parseInt(ev.get(2));
                    isOnline[id] = false;
                    offlineUntil[id] = t + 60;
                }
            }
            for(List<String> ev : evs){
                if(!ev.get(0).equals("MESSAGE")){
                    continue;
                }
                String mentionsStr = ev.get(2);
                String[] tokens = mentionsStr.split("\\s+");
                for(String token : tokens){
                    if(token.equals("ALL")){
                        for(int i = 0; i < numberOfUsers; ++i){
                            mentions[i]++;
                        }
                    }
                    else if(token.equals("HERE")){
                        for(int i = 0; i < numberOfUsers; ++i){
                            if(isOnline[i]){
                                mentions[i]++;
                            }
                        }
                    }
                    else if(token.startsWith("id")){
                        int id = Integer.parseInt(token.substring(2));
                        if(id >= 0 && id < numberOfUsers){
                            mentions[id]++;
                        }
                    }
                }
            }
        }
        return mentions;
    }
}
