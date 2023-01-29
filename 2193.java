/*

  백준 2193 - 이친수 문제 (이천수 아님 ㅋㅋ) - 2022.01.19 ~ 01.20
  
  0과 1로만 이루어진 수를 이진수라 함. 이러한 수 중 특별한 성질을 갖는 것이 이친수 (pinary number)
  
  1) 이친수는 0으로 시작하지 않음
  2) 이친수는 1이 두 번 연속으로 나타나지 않음 (11을 부분 문자열로 갖을 수 없음)
  
  1, 10, 100, 101, 1000, 1001 ... 등이 이친수에 해당
  
  N(1 <= N <= 90)이 주어졌을 때, N자리 이친수 갯수를 구하삼
  
  틀렸던 이유 : 마지막 n번째 자리에 0과 1이 올 수 있고, n-1번째 자리에 1이 왔을때는 0밖에 올 수 없음을 파악함.
  하지만, n-1번째에 1이 온다는 것을 간과하고 문제를 풀어 틀렸음.

*/

import java.util.*;

public class Main{
  
public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
  
        long [] dp = new long[91];      // N의 정수 최대 개수만큼 배열을 선언
        
        dp[0] = 0;                      // N=1일때, 0으로 끝나는 수는 0개, 1로 끝나는 수는 1개
        dp[1] = 1;
 
        for(int i=2; i<=n; i++) {
          dp[i] = dp[i-1]+dp[i-2];      // n번째 자리에 0이 올때 → n-1이 0 또는 1이 와도 상관이 없어서 dp[n-1]을 더함
        }                               // n번째 자리에 1이 올 때 n-1이 무조건 0이어야 되기 때문에 dp[n-2]를 더함

        System.out.println(dp[n]);
    }
}