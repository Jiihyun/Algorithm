import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        File[] fs = new File[files.length];
        
        for (int i = 0; i < files.length; i++) {
            String head = "";
            String number = "";
            int j = 0;
            while (j < files[i].length() && !Character.isDigit(files[i].charAt(j))) { 
                head += files[i].charAt(j);
                j++;
            }
            
            while (j < files[i].length() && Character.isDigit(files[i].charAt(j)) && number.length() < 5) {
               number +=  files[i].charAt(j);
                j++;
            }
            fs[i] = new File(files[i], head, Integer.parseInt(number));
        }
        
        Arrays.sort(fs, (o1, o2) -> {
            int headCompare = o1.head.compareToIgnoreCase(o2.head);
            
            if (headCompare != 0) {
                return headCompare;
            }
            return Integer.compare(o1.number, o2.number);
        });
        
        String[] answer = new String[files.length];

        for (int i = 0; i < fs.length; i++) {
            answer[i] = fs[i].originalName;
        }
                       
        return answer;
    }
    
    private static class File {
        String originalName;
        String head;
        int number;

        public File(String originalName, String head, int number) {
            this.originalName = originalName;
            this.head = head;
            this.number = number;
        }
    }
}

// 파일명에 포함된 숫자를 반영한 정렬 기능
// HEAD 부분을 기준으로 사전 순으로 정렬 & 대소문자 구분x
// HEAD 부분과, NUMBER의 숫자도 같을 경우, 원래 입력에 주어진 순서를 유지