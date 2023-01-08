import java.io.*;
import java.util.*;

// 백준 1026 보물 문제
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = sc.nextInt();           // 배열의 수 입력
        int[] A = new int[N];           // 입력 받은 배열 수 만큼 배열 생성
        int[] B = new int[N];
      
        StringTokenizer stA = new StringTokenizer(br.readline());     // A 배열에 들어갈 수 입력받음
        StringTokenizer stB = new StringTokenizer(br.readline());     // B 배열에 들어갈 수 입력받음
      
        
        for(int i=0; i<N; i++) {
            A[i] = Integer.valueOf(stA.nextToken());                  // 각 배열별로 숫자 넣음
        }
        for(int j=0; j<N; j++) {
            B[j] = Integer.valueOf(stB.nextToken());                  // 각 배열 별로 숫자 넣음
        }
        
        Arrays.sort(A);                                               // 배열 오름차순 정렬
        Arrays.sort(B);                                               // 배열 오름차순 정렬
        
        int arrSum = 0;
        
        for(int k=0; k<N; k++) {
            arrSum += A[k] * B[N-k-1];                                // A 배열의 가장 낮은 수 * B 배열의 가장 높은 수로 곱해가면서 더해서 최소값 구하기
        }
        System.out.println(arrSum);                                   // 구한 최소값 출력
    }
}
