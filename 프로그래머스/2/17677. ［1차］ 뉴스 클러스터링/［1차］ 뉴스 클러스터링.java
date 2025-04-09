import java.util.*;

class Solution {
    public boolean isAlphabet(String temp) {
        int i;    
        
        for (i = 0; i < temp.length(); i++) {
            if (!Character.isLetter(temp.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    
    public double J(ArrayList<String> list1, ArrayList<String> list2) {
        if (list1.size() == 0 && list2.size() == 0) {
            return 1.0;
        }

        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        for (String s : list1) {
            map1.put(s, map1.getOrDefault(s, 0) + 1);
        }

        for (String s : list2) {
            map2.put(s, map2.getOrDefault(s, 0) + 1);
        }

        int intersection = 0;
        int union = 0;

        // 교집합
        for (String key : map1.keySet()) {
            if (map2.containsKey(key)) {
                intersection += Math.min(map1.get(key), map2.get(key));
            }
        }

        // 합집합
        Set<String> allKeys = new HashSet<>();
        allKeys.addAll(map1.keySet());
        allKeys.addAll(map2.keySet());

        for (String key : allKeys) {
            int count1 = map1.getOrDefault(key, 0);
            int count2 = map2.getOrDefault(key, 0);
            union += Math.max(count1, count2);
        }

        return (double) intersection / union;
    }

    
    public int solution(String str1, String str2) {
        int answer = 0;
        int i;
        String temp;
        ArrayList<String> arrayListStr1 = new ArrayList<>();
        ArrayList<String> arrayListStr2 = new ArrayList<>();
        
        //str1을 다중집합으로 변환
        str1 = str1.toLowerCase(); // 전부 소문자로 변환
        for(i = 0; i < str1.length() - 1; i++){ // 다중 집합으로 변환하기
            temp = str1.substring(i, i + 2); // 두 글자씩 분리
            
            if(isAlphabet(temp)){// 알파벳으로만 이루어져 있는지?
                arrayListStr1.add(temp);// 삽입
            }
        }
        // 변환 결과 출력
        // for(String str : arrayListStr1){
        //     System.out.print(str + " ");
        // }
        // System.out.println();
        
        //str2을 다중집합으로 변환
        str2 = str2.toLowerCase(); // 전부 소문자로 변환
        for(i = 0; i < str2.length() - 1; i++){ // 다중 집합으로 변환하기
            temp = str2.substring(i, i + 2); // 두 글자씩 분리
            
            if(isAlphabet(temp)){// 알파벳으로만 이루어져 있는지?
                arrayListStr2.add(temp);// 삽입
            }
        }
        // 변환 결과 출력
        // for(String str : arrayListStr2){
        //     System.out.print(str + " ");
        // }
        // System.out.println();
        
        answer = (int)(J(arrayListStr1, arrayListStr2) * 65536);
        
        return answer;
    }
}