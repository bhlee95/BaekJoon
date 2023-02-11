/*

백준 11047 - 동전 0 문제 (그리디 알고리즘)

동전 총 N종류

가치의 합을 K로 만들려고 한다.

N종류로 가치 합 K를 만들기 위한 동전 개수의 최솟값은?

- 문제 접근 방식

1) 현재 가지고 있는 동전의 가치가 총 가치 K보다 작거나 같아야 충족된다.

2) 가지고 있는 동전 중 가치가 가장 큰 동전부터 사용하여 계산하는 방식으로 하면 되지 않을까? 라는 생각으로 접근

*/

import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();               // 총 동전의 개수 N
        int K = sc.nextInt();               // 동전의 총 가치 K
        
        int[] coin = new int[N];            // 동전의 개수 만큼 배열 선언
        
        for(int i=0; i<N; i++) {
            coin[i] = sc.nextInt();         // 가지고 있는 동전을 넣는다.
        }
        
        int cnt = 0;
        
        for(int i=N-1; i>=0; i--) {         
            while(K - coin[i] >= 0) {       // 총 가치에서 가지고 있는 동전을 뺐을 때, 0이 될때까지 계속 반복
                K -= coin[i];               // 총 가치에서 가지고 있는 동전의 값 만큼을 뺀다
                cnt++;                      // 최소값 count 더하기
                }
            }
        
        System.out.print(cnt);              // 최종적으로 계산된 동전 개수의 
    }
}
