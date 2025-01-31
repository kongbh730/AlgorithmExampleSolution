class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        int i, j, width = park[0].length(), height = park.length;
        int startX = 0, startY = 0, distance, nextX, nextY;
        char direction;
        boolean found = false, inRange, obstacle;
        //1. 주어진 방향으로 이동할 때 공원을 벗어나는지?
        //2. 주어진 방향으로 이동 중 장애물을 만나는지?
        //해당되면 해당 명령 무시하고 다음 명령 수행
        
        //시작위치 찾기
        for (i = 0; i < park.length; i++) {
            j = park[i].indexOf('S');//못찾으면 -1 반환
            if (j != -1) {
                startX = j;
                startY = i;
                found = true;
            }
            if(found){
                break;
            }
        }
        System.out.println("시작위치 : " + startX + " " + startY);
        
        for(i = 0; i < routes.length; i++){
            obstacle = false;
            inRange = false;
            String [] order = routes[i].split(" ");
            
            direction = order[0].charAt(0);
            distance = Integer.parseInt(order[1]);
            System.out.println(direction + "방향으로 " + distance + "만큼 이동");
            
            //다음 좌표 지정
            if(direction == 'E'){
                nextX = startX + distance;
                nextY = startY;
                
                //범위를 초과하지 않는지?
                if((nextX >= 0 && nextX < width) && (nextY >= 0 && nextY < height)){
                    inRange = true;
                    
                    //경로상에 장애물이 있는지?
                    for(j = startX; j <= nextX; j++){
                        if(park[nextY].charAt(j) == 'X'){
                            obstacle = true;
                            break;
                        }
                    }            
                }
            }
            else if(direction == 'W'){
                nextX = startX - distance;
                nextY = startY;
                
                //범위를 초과하지 않는지?
                if((nextX >= 0 && nextX < width) && (nextY >= 0 && nextY < height)){
                    inRange = true;
                    
                    //경로상에 장애물이 있는지?
                    for(j = startX; j >= nextX; j--){
                        if(park[nextY].charAt(j) == 'X'){
                            obstacle = true;
                            break;
                        }
                    }            
                }
            }
            else if(direction == 'S'){
                nextX = startX;
                nextY = startY + distance;
                
                //범위를 초과하지 않는지?
                if((nextX >= 0 && nextX < width) && (nextY >= 0 && nextY < height)){
                    inRange = true;
                    
                    //경로상에 장애물이 있는지?
                    for(j = startY; j <= nextY; j++){
                        if(park[j].charAt(nextX) == 'X'){
                            obstacle = true;
                            break;
                        }
                    }            
                }
            }
            else{//dirction == 'N'
                nextX = startX;
                nextY = startY - distance;
                
                //범위를 초과하지 않는지?
                if((nextX >= 0 && nextX < width) && (nextY >= 0 && nextY < height)){
                    inRange = true;
                    
                    //경로상에 장애물이 있는지?
                    for(j = startY; j >= nextY; j--){
                        if(park[j].charAt(nextX) == 'X'){
                            obstacle = true;
                            break;
                        }
                    }            
                }
            }
            
            //조건을 모두 만족하면 갱신
            if(inRange && !obstacle){
                startX = nextX;
                startY = nextY;
                System.out.println("조건 만족 : " + startX + " " + startY);
            }
            else{//inRange == false || obstacle == true 
                continue;
            }
        }
        answer[0] = startY;
        answer[1] = startX;
        
        return answer;
    }
}