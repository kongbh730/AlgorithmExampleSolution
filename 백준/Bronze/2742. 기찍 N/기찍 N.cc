#include <stdio.h>
#pragma warning(disable:4996)

int main(void){
    int i, N;
    
    scanf("%d", &N);
    for(i = N; i >= 1; i--){
        printf("%d\n", i);
    }
    
    return 0;
}