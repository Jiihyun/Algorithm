import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {        
        Map<String, Integer> playTimes = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            playTimes.put(genres[i], playTimes.getOrDefault(genres[i], 0) + plays[i]);
        }
        List<String> keySet = new ArrayList<>(playTimes.keySet());
        keySet.sort((o1, o2) -> playTimes.get(o2).compareTo(playTimes.get(o1)));
        
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < keySet.size(); i++) {
            String gen = keySet.get(i);
            
            List<Integer> index = new ArrayList<>();
            for (int j = 0; j < genres.length; j++) {
                if (gen.equals(genres[j])) {
                    index.add(j);
                }
            }
            index.sort((o1, o2) -> {
                if (plays[o1] != plays[o2]) {
                    return Integer.compare(plays[o2], plays[o1]);
                }
                return Integer.compare(o1, o2);
            });
               if (index.size() >= 2) {
                    ans.add(index.get(0));
                    ans.add(index.get(1));
                } else {
                    ans.add(index.get(0));
                } 
        }
        return ans.stream()
        .mapToInt(Integer::intValue)
        .toArray();
        }
}
// 장르 별로 가장 많이 재생된 노래를 두 개씩, 장르에 속한 곡이 하나라면, 하나의 곡만 선택

// 1. 속한 노래가 많이 재생된 장르 먼저 수록합니다.
// 2. 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
// 3. 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래 먼저 수록
