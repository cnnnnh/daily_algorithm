import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> map = new HashMap<>();
        Queue<Integer> answer = new LinkedList<>();
        
        // 장르와 총 재생 횟수
        for(int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        ArrayList<String> genre = new ArrayList<>();
        for(String g : map.keySet()) {
            genre.add(g);
        }
        
        // 최대 횟수 기준으로 정렬
        Collections.sort(genre, (o1, o2) -> map.get(o2) - map.get(o1));
        
        for(int i = 0; i < genre.size(); i++) {
            String g = genre.get(i);
            int max = -1;
            int firstIndex = -1;
            int secondIndex = -1;

            // 해당 장르 중 가장 많이 재생된 곡
            for(int j = 0; j < genres.length; j++) {
                if(genres[j].equals(g) && max < plays[j]) {
                    max = plays[j];
                    firstIndex = j;
                }
            }
            
            // 최댓값 초기화 후, 두번째로 많이 재생된 곡 탐색
            max = -1;
            for(int j = 0; j < genres.length; j++) {
                if(j != firstIndex && genres[j].equals(g) && max < plays[j]) {
                    max = plays[j];
                    secondIndex = j;
                }
            }
            
            answer.offer(firstIndex);
            // 두번째 곡이 없을 때
            if(secondIndex > -1) answer.offer(secondIndex);
        }
        
        int index = 0;
        int[] result = new int[answer.size()];
        while(!answer.isEmpty()) {
            result[index++] = answer.poll();
        }
        
        return result;
    }
    
}