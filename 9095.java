/*
  백준 9095 - 1,2,3 더하기 (DP 알고리즘 문제)
  
  정수 4를 1,2,3의 합으로 나타내는 방법은 총 7가지가 있음. 합을 나타낼 때는 수를 1개 이상 사용해야 함
  
  1) 1+1+1+1
  2) 1+1+2
  3) 1+2+1
  4) 2+1+1
  5) 2+2
  6) 1+3
  7) 3+1
  
  정수 n이 입력으로 들어왔을 때, n을 1,2,3의 합으로 나타내는 방법의 수를 구하는 프로그램 만들기
  (n은 양수이며, 11보다 적은 수)
*/

import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int num = sc.nextInt();
        
        int[] numArr = new int[11]; // 입력받은 num이 11보다 작은 수이기 때문에 11개의 배열을 선언
        
        numArr[0] = 0;              // 0일때 = 경우의수 0
        numArr[1] = 1;              // 1일때 = 경우의수 1 (숫자가 1밖에 없으므로)
        numArr[2] = 2;              // 2일때 = 경우의수 2 (1+1 / 2)
        numArr[3] = 4;              // 3일때 = 경우의수 4 (1+1+1 / 1+2 / 2+1 / 3)
        numArr[4] = 7;              // 4일때 = 경우의수 7 (1+1+1+1 / 1+2+1 / 1+1+2 / 2+1+1 / 1+3 / 3+1 / 4) ...
      
        // 위의 경우로 비추어 봤을 때, numArr[4] = numArr[3] + numArr[2] + numArr[1]로 볼 수 있음
        // 따라서 numArr[n] = numArr[n-1] + numArr[n-2] + numArr[n-3]
        
        int testCase = 0;           // 테스트로 입력 받을 정수 n
        
        for(int i=0; i<num; i++) {
            testCase = sc.nextInt();
            for(int j=5; j<=testCase; j++) {
                numArr[j] = numArr[j-1] + numArr[j-2] + numArr[j-3];
            }
            System.out.println(numArr[testCase]);
        }
        
    }
}
