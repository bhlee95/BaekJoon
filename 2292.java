/*

백준 2292 - 벌집

육각형으로 이루어진 벌집이 있다. 그림에서 보는 바와 같이 중앙의 방 1부터 시작해서 이웃하는 방에 돌아가면서 1씩 증가하는 번호를 주소로 매길 수 있다. 
숫자 N이 주어졌을 때, 벌집의 중앙 1에서 N번 방까지 최소 개수의 방을 지나서 갈 때 몇 개의 방을 지나가는지(시작과 끝을 포함하여)를 계산하는 프로그램을 작성하시오. 

(예를 들면, 13까지는 3개, 58까지는 5개를 지난다.)

문제 접근 방식

1) N이 1이라면 답은 무조건 1

2) 1번째 방을 기준으로 육각형의 모양으로 주위를 둘러싸면서 이동 → 6의 배수만큼 방이 커짐 (6, 12, 18 ...)

3) 6의 배수만큼 커진다는 것을 이용하여 숫자 N이 주어졌을 때, 몇번째인지 계산할 수 있게 된다.

*/



import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int beeHouse = sc.nextInt();          // 몇번째 벌집 방인지 입력받음
        
        int num = 2;                          // 방의 범위
        int count = 1;                        // 몇개의 방을 지나는지 count
        
        if(beeHouse == 1) {                   // 첫번째 벌집 방이면
            System.out.println(beeHouse);     // 답은 무조건 1 (방 1개이므로)
        } else {
            while(num <= beeHouse) {          // 주어진 방의 숫자가 1보다 큰 수라면
                num = num + (6 * count);      // 6의 배수만큼 계속 커지게 됨
                count++;                      // 지나는 방의 갯수 count
            }
            
            System.out.println(count);        // 범위가 최종적으로 입력받은 벌집 방(숫자)보다 커지게 되면 count 출력
        }
    }
}
