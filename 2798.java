/*
  백준 2798 - 블랙잭 문제 (브루트포스 알고리즘 → 전체탐색 알고리즘)
  
  문제를 풀며 느낀점 : 전체를 탐색하는 알고리즘이다 보니, 불필요한 부분까지 작동하여 메모리와 시간을 많이 잡아먹는 경향이 있는 것 같음.
  조건문을 추가하여 불필요한 부분을 제외하고 실행하면 결과가 더 좋아질 것으로 생각되며, 나중에 다시 구현해 볼 필요가 있을 것 같음.
  
  최초에 searchAnswer 메소드를 구현 할 때, 삼중 for문을 구현하는 과정에서 생각을 잘못하여 꼬인 부분이 있었음 (→ int k=i+2;)

*/


import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());             // 카드의 개수를 입력받음
		int M = Integer.parseInt(st.nextToken());             // 정수 M을 입력받음 (정수 M을 넘지 않으며 M에 최대한 가까운 카드 3장의 수를 구하는 문제)
		
		int[] arr = new int[N];                               // 카드의 숫자를 입력받기 위한 배열 선언
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());          // 배열에 카드의 숫자를 넣음
		}
		
		int result = searchAnswer(arr, N, M);                 // 정수 M을 넘지 않으며 M에 최대한 가까운 카드 3장의 수를 구하기 위해 searchAnswer 메소드를 실행함
		System.out.println(result);                           // 결과값 출력
	}
	
	public static int searchAnswer(int[] arr, int N, int M) {
		int result = 0;
		
		for(int i=0; i<N-2; i++) {                             // 카드 값이 담긴 배열의 1,2,3번째 값으로 우선 비교
			
			for(int j=i+1; j<N-1; j++) {                         // 앞선 for문에서 가져간 값을 제외하고 나머지 값에서 하나 가져 옴
				
				for(int k=j+1; k<N; k++) {                         // 앞선 for문에서 가져간 값을 제외하고 나머지 값에서 하나 가져 옴
					int threeCard = arr[i] + arr[j] + arr[k];        // 3가지의 카드의 숫자를 다 더함 (앞선 for문들에서 뽑은 숫자를 다 더함)
					
					if(M == threeCard) {                             // 앞에서 더한 threeCard값이 입력받은 정수 M과 같다면
						return threeCard;                              // 정답이기 때문에 threeCard 값을 return 
					}
					
					if(threeCard < M && result < threeCard) {        // threeCard로 계산된 값이 입력받은 정수 M보다 작고, result값에 저장된 정수가 threeCard 값보다 작다면
						result = threeCard;                            // result 값을 새로운 threeCard값으로 변경
					}
				}
			}
		}
		return result;                                         // 모든 경우의 수를 탐색했다면 최종적으로 계산된 result 값을 return한다.
	}
}
