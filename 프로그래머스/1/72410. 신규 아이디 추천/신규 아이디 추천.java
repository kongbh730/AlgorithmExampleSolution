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
        //대문자를 소문자로 치환
        id = id.toLowerCase();
        
        return id;
    }
    
    public String step2(String id){
        //소문자, 숫자, 빼기, 밑줄, 마침표를 제외한 모든 문자 제거
        int i;
        String edit = "";
        char current;
        
        for(i = 0; i < id.length(); i++){
            current = id.charAt(i);
            if(Character.isLetter(current))
            {
                edit += current;
            }
            else if(Character.isDigit(current)){
                edit += current;
            }
            else if(current == '-' || current == '_' || current == '.'){
                edit += current;
            }
        }
        
        return edit;
    }
    
    public String step3(String id){
        //마침표가 2번 이상 연속된 부분을 하나의 마침표로 치환
        String edit = "";
        int i;
        
        for(i = 0; i < id.length(); i++){
            if(edit.length() == 0){
                edit += id.charAt(i);
            }
            else if(id.charAt(i) == '.' && edit.charAt(edit.length() - 1) == '.'){
                continue;
            }
            else{
                edit += id.charAt(i);
            }
        }
        
        return edit;
    }
    
    public String step4(String id){
        //마침표가 처음이나 끝에 위치하면 제거
        if (id == null || id.length() == 0 || id.equals(".")) {
            return "";
        }

        // 마침표가 처음이나 끝에 위치하면 제거
        if(id.charAt(0) == '.') {
            id = id.substring(1); // 첫 번째 문자가 마침표일 경우 제거
        }
        if(id.charAt(id.length() - 1) == '.') {
            id = id.substring(0, id.length() - 1); // 마지막 문자가 마침표일 경우 제거
        }
        
        return id;        
    }
    
    public String step5(String id){
        if(id.length() == 0){
            id = "a";
        }
        
        return id;
    }
    
    public String step6(String id){
        //길이가 16자면 첫 15개 문자까지만 반환
        //만약 제거 후 마침표가 위치하면 마침표 제거
        if(id.length() >= 16){
            id = id.substring(0, 15);//index 0~14까지 15개//15는 포함 안됨
            if(id.charAt(14) == '.'){//마지막 문자가 .이라면
                id = id.substring(0, 14);//0부터 13까지 14개 //13은 포함 안됨
            }
        }
        
        return id;
    }
    
    public String step7(String id){
        //길이가 2자 이하면 마지막 문자를 길이가 3이 될때까지 반복
        char last;
        
        if(id.length() <= 2){
            last = id.charAt(id.length() - 1);
            while(id.length() < 3){
                id += last;
            }
        }
        
        return id;
    }
}