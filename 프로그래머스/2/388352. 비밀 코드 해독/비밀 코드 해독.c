#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

bool check(int temp[], int **q, size_t q_rows, size_t q_cols, int ans[], size_t ans_len){
    int i, j, k, l, count;
    
    //ans_len == q_rows;
    for(i = 0; i < q_rows; i++){
        count = 0;
        for(j = 0; j < q_cols; j++){
            for(k = 0; k < q_cols; k++){
                if(temp[k] == q[i][j]){
                    count++;
                    break;
                }
            }
        }
        
        if(count != ans[i]){
            return false;
        }
    }
        
    return true;
}

// q_rows는 2차원 배열 q의 행 길이, q_cols는 2차원 배열 q의 열 길이입니다.
// ans_len은 배열 ans의 길이입니다.
int solution(int n, int** q, size_t q_rows, size_t q_cols, int ans[], size_t ans_len) {
    int answer = 0;
    int i, j ,k;
    
    /*
    printf("n : %d\n", n);
    printf("q : \n");
    for(i = 0; i < q_rows; i++){
        for(j = 0; j < q_cols; j++){
            printf("%d ", q[i][j]);
        }
        printf("\n");
    }
    printf("ans : ");
    for(i = 0; i < ans_len; i++){
        printf("%d ", ans[i]);
    }
    printf("\n");
    */

    //숫자 야구 게임과 유사?
    //중복되지 않는 정수 5개의 조합 구하기...
    
    // 5중 for문을 사용하여 중복 없는 5개의 조합 생성 <- 미친짓 같은데
    int temp[5];
    for (int a = 1; a <= n - 4; a++) {
        for (int b = a + 1; b <= n - 3; b++) {
            for (int c = b + 1; c <= n - 2; c++) {
                for (int d = c + 1; d <= n - 1; d++) {
                    for (int e = d + 1; e <= n; e++) {
                        //printf("%d %d %d %d %d\n", a, b, c, d, e);
                        
                        // 구한 a, b, c, d, e가 ans와 부합하는지?
                        temp[0] = a;
                        temp[1] = b;
                        temp[2] = c;
                        temp[3] = d;
                        temp[4] = e;
                        if(check(temp, q, q_rows, q_cols, ans, ans_len)){//부합하면?
                            //printf("%d %d %d %d %d\n", a, b, c, d, e);
                            answer++;
                        }
                    }
                }
            }
        }
    }
    
    return answer;
}