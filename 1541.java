/*

백준 1541 - 잃어버린 괄호 문제

세준이는 양수와 +, -, 그리고 괄호를 가지고 식을 만들었다. 그리고 나서 세준이는 괄호를 모두 지웠다.

그리고 나서 세준이는 괄호를 적절히 쳐서 이 식의 값을 최소로 만들려고 한다.

괄호를 적절히 쳐서 이 식의 값을 최소로 만드는 프로그램을 작성하시오.


문제 접근방식 → 덧셈을 먼저 하고 전부 마이너스를 하면 최소값을 출력할 수 있지 않을까?

1. 식을 읽어와서 "-"(마이너스)로 우선 split 하여 저장함.

2. 이후 덧셈이 포함된 내용을 split하여 덧셈을 먼저 처리함

3. 모든 덧셈이 끝나면 뺄셈만 남기 때문에 남은 값을 다 저장하여 뺄셈으로 진행

4. 들고 있는 정수가 가장 첫번째 정수라면 그 값이 최소값이고, 아니라면 뺄셈을 진행해준다.

*/



import java.util.*;
 
public class Main {
 
	public static void main(String[] args) {
        
    int minSum = 0;	
		Scanner sc = new Scanner(System.in);
 
		String[] minNums = sc.nextLine().split("-");        // "-" 기준으로 우선 나눔
		
 
		for(int i = 0; i < minNums.length; i++) {
			int temp = 0;
 
			String[] addNums = minNums[i].split("\\+");       // "+"가 포함된 내용을 나눈다.
			
			for(int j = 0; j < addNums.length; j++) {
				temp += Integer.parseInt(addNums[j]);           // "+"가 포함된 내용을 다 더함
			}
			
			if (i == 0) {                                     // 첫 번째 정수라면?
				minSum = minSum + temp;                         // 그 값이 최소값
			} else {
				minSum -= temp;                                 // 아니면 뺄셈 진행
			}
		}
		System.out.println(minSum);                         // 최종적으로 
	}
 
}
