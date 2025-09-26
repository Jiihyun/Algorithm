import java.util.*;

class Solution {
    public String solution(String new_id) {
        // 1단계: 소문자로
        String lower = new_id.toLowerCase();

        // 2단계: 허용된 문자만
        StringBuilder sb = new StringBuilder();
        for (char c : lower.toCharArray()) {
            if (isValidChar(c)) {
                sb.append(c);
            }
        }
        String two = sb.toString();

        // 3단계: .. → .
        sb = new StringBuilder();
        char prev = 0;
        for (char c : two.toCharArray()) {
            if (c == '.' && prev == '.') continue;
            sb.append(c);
            prev = c;
        }
        String three = sb.toString();

        // 4단계: 양 끝 .
        if (!three.isEmpty() && three.charAt(0) == '.') {
            three = three.substring(1);
        }
        if (!three.isEmpty() && three.charAt(three.length() - 1) == '.') {
            three = three.substring(0, three.length() - 1);
        }

        // 5단계: 빈 문자열 → "a"
        if (three.isEmpty()) {
            three = "a";
        }

        // 6단계: 길이 16 이상이면 자르기
        if (three.length() >= 16) {
            three = three.substring(0, 15);
            if (three.charAt(three.length() - 1) == '.') {
                three = three.substring(0, three.length() - 1);
            }
        }

        // 7단계: 길이 2 이하라면 마지막 문자 반복
        while (three.length() < 3) {
            three += three.charAt(three.length() - 1);
        }

        return three;
    }

    private boolean isValidChar(char ch) {
        return ('a' <= ch && ch <= 'z')
            || ('0' <= ch && ch <= '9')
            || (ch == '-' || ch == '_' || ch == '.');
    }
}
