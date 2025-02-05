import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = {};
        int id_listLen = id_list.length, reportLen = report.length;
        int i, j;
        boolean [][] reportGraph = new boolean [id_listLen][id_listLen];
        int reportGraphLen = reportGraph.length;
        ArrayList<String> stoppedName = new ArrayList<>();
        answer = new int[id_listLen];
        
        //reportData라는 맵에 이름과 번호를 매핑
        Map <String, Integer> reportData = new HashMap<>();
        for(i = 0; i < id_listLen; i++){
            reportData.put(id_list[i], i);
        }
        
        //신고 주고 받은 내역을 그래프로 변환
        for(i = 0; i < reportLen; i++){
            String[] names = report[i].split(" ");
            //names[0];//신고한 사람
            //names[1];//신고 받은 사람
            reportGraph[reportData.get(names[0])][reportData.get(names[1])] = true;
        }
        
        //변환 결과 출력
        // System.out.println("변환 결과");
        // for(i = 0; i < reportGraphLen; i++){
        //     for(j = 0; j < reportGraphLen; j++){
        //         System.out.print(reportGraph[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        
        //정지된 사람 확인
        for(i = 0; i < reportGraphLen; i++){
            int sum = 0;
            for(j = 0; j < reportGraphLen; j++){
                if(reportGraph[j][i]){
                    sum++;
                }
            }
            
            //이 닉네임이 정지됐으면, 해당 닉네임을 신고한 사람들은 메일을 받음
            if(sum >= k){
                for(j = 0; j < reportGraphLen; j++){
                    if(reportGraph[j][i]){
                        answer[j]++;
                    }
                }
            }
        } 
        
        return answer;
    }
}