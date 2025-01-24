class Solution {
    public String solution(String new_id) {
        String answer = "";
        
        new_id = step1(new_id);
        System.out.println(new_id);
        new_id = step2(new_id);
        System.out.println(new_id);
        new_id = step3(new_id);
        System.out.println(new_id);
        new_id = step4(new_id);
        System.out.println(new_id);
        new_id = step5(new_id);
        System.out.println(new_id);
        new_id = step6(new_id);
        System.out.println(new_id);
        new_id = step7(new_id);
        System.out.println(new_id);
        answer = new_id;
        
        return answer;
    }
    
    public String step1(String id){
        // 대문자를 소문자로 치환
        return id.toLowerCase();
    }
    
    public String step2(String id){
        // 소문자, 숫자, 빼기, 밑줄, 마침표를 제외한 모든 문자 제거
        StringBuilder edit = new StringBuilder();
        for (int i = 0; i < id.length(); i++) {
            char current = id.charAt(i);
            if (Character.isLetterOrDigit(current) || current == '-' || current == '_' || current == '.') {
                edit.append(current);
            }
        }
        return edit.toString();
    }
    
    public String step3(String id){
        // 마침표가 2번 이상 연속된 부분을 하나의 마침표로 치환
        StringBuilder edit = new StringBuilder();
        for (int i = 0; i < id.length(); i++) {
            if (edit.length() == 0 || id.charAt(i) != '.') {
                edit.append(id.charAt(i));
            } else if (edit.charAt(edit.length() - 1) != '.') {
                edit.append(id.charAt(i));
            }
        }
        return edit.toString();
    }
    
    public String step4(String id) {
        // 빈 문자열일 경우 처리
        if (id.isEmpty()) {
            return "";
        }

        // 마침표가 처음이나 끝에 위치하면 제거
        if (id.charAt(0) == '.') {
            id = id.substring(1);
        }
        if (id.length() > 0 && id.charAt(id.length() - 1) == '.') {
            id = id.substring(0, id.length() - 1);
        }
    
        return id;
    }

    
    public String step5(String id){
        // 빈 문자열이면 "a"를 추가
        return id.isEmpty() ? "a" : id;
    }
    
    public String step6(String id){
        // 길이가 16자면 첫 15개 문자까지만 반환, 마침표가 있으면 마지막에 제거
        if (id.length() > 15) {
            id = id.substring(0, 15);
            if (id.charAt(14) == '.') {
                id = id.substring(0, 14);
            }
        }
        return id;
    }
    
    public String step7(String id){
        // 길이가 2자 이하면 마지막 문자를 길이가 3이 될때까지 반복
        StringBuilder sb = new StringBuilder(id);
        char last = sb.charAt(sb.length() - 1);
        while (sb.length() < 3) {
            sb.append(last);
        }
        return sb.toString();
    }
}
