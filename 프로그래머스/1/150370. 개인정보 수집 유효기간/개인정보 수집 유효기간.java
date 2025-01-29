import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        ArrayList<Integer> list = new ArrayList<>();
        int i;
        
        //today : 오늘 날짜
        //terms : 유효기간 : 약관종류(A~Z 중복 없음) 유효기간(1~100 보관할 수 있는 달)
        //privacies : 개인정보 : 날짜 약관종류
            
        //파기해야 할 개인정보의 번호를 오름차순으로 반환
        
        //맵에 terms 정보 저장
        Map <String, Integer> term = new HashMap<>();
        for(i = 0; i < terms.length; i++){
            String [] termString = terms[i].split(" ");
            term.put(termString[0], Integer.parseInt(termString[1]));
        }
        
        //오늘 정보 파싱
        String [] todayPart = today.split("\\.");
        int todayYear = Integer.parseInt(todayPart[0]);
        int todayMonth = Integer.parseInt(todayPart[1]);
        int todayDay = Integer.parseInt(todayPart[2]);
        
        System.out.println("today " + todayYear + " " + todayMonth + " " + todayDay);
        
        //각 개인정보에 대해 연산 수행
        for(i = 0; i < privacies.length; i++){
            String [] parsing = privacies[i].split(" ");
            String [] date = parsing[0].split("\\.");
            int privaciesYear = Integer.parseInt(date[0]);
            int privaciesMonth = Integer.parseInt(date[1]);
            int privaciesDay = Integer.parseInt(date[2]);
        
            System.out.println("privacies " + privaciesYear + " " + privaciesMonth + " " + privaciesDay);
            
            int expireYear = todayYear - privaciesYear;
            int expireMonth = todayMonth - privaciesMonth;
            int expireDay = todayDay - privaciesDay;
            int needExpirationDate = term.get(parsing[1]) * 28;// 만료까지 지나야하는 일수
            int totalDate = expireDay + (expireMonth * 28) + (expireYear * 12 * 28);//개인정보 저장 이후 지난 일수
            
            System.out.println("needExpirationDate : " + needExpirationDate + " / totaldate : " + totalDate);
            if(totalDate >= needExpirationDate){
                list.add(i+1);
            }
        }
        
        answer = new int[list.size()];
        for(i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        Arrays.sort(answer);
        
        return answer;
    }
}