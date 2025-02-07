import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        Set<String> usedWords = new HashSet<>();
        int wordLength = words.length;

        // 첫 단어를 초기화
        usedWords.add(words[0]);

        for (int i = 1; i < wordLength; i++) {
            String current = words[i]; 
            String previous = words[i - 1]; 
            System.out.print(previous + " -> " + current);
            
            // 이미 사용된 단어인지 확인
            if (usedWords.contains(current)) {
                System.out.print(" 이미 사용된 단어!");
                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1;
                break;
            }

            // 이전 단어의 마지막 글자와 현재 단어의 첫 글자 비교
            if (previous.charAt(previous.length() - 1) != current.charAt(0)) {
                System.out.print(" 끝말잇기 실패!");
                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1; 
                break;
            }
            System.out.println();

            usedWords.add(current);
        }

        return answer; 
    }
}