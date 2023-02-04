/*

백준 2908 - 상수

상수는 수를 다른 사람과 다르게 거꾸로 읽는다. 
예를 들어, 734와 893을 칠판에 적었다면, 상수는 이 수를 437과 398로 읽는다. 
따라서, 상수는 두 수중 큰 수인 437을 큰 수라고 말할 것이다.

두 수가 주어졌을 때, 상수의 대답을 출력하는 프로그램을 작성하시오.

문제 접근 방식

1) 두 수를 입력 받음 (3자리 수 (100 ~ 999))

2) 입력받은 3자리 수를 분할하여 배열에 담고, 자리를 바꾸는걸 돕는 배열을 하나 선언 후 반복문으로 1번째 자리와 3번째 자리 수를 바꿈

3) 입력받은 2가지 수를 모두 똑같이 반복하여 비교하면 된다.

*/


import java.util.*;

public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String n1 = sc.next();                    // 숫자를 입력받음
        String n2 = sc.next();
        
        String[] temp = new String[1];            // 숫자 자리바꾸는걸 도와줄 배열 선언
        String[] nArr1 = n1.split("");            // 입력받은 수를 split하여 배열에 담음
        String[] nArr2 = n2.split("");
        
        for(int i=0; i<3; i++) {
            temp[0] = nArr1[0];                   // 입력받은 숫자의 첫번째 자리와 세번째 자리를 바꾼다. (ex : 321 → 123)
            nArr1[0] = nArr1[2];
            nArr1[2] = temp[0];
        }
        
        n1 = "";
        for(int j=0; j<3; j++) {
            n1 += nArr1[j];                       // 자리가 바뀐 수를 다시 입력받음
        }
        
        for(int i=0; i<3; i++) {                  // 두번째 입력받은 숫자도 위와 똑같은 로직을 진행한다.
            temp[0] = nArr2[0];
            nArr2[0] = nArr2[2];
            nArr2[2] = temp[0];
        }
        
        n2="";
        for(int j=0; j<3; j++) {
            n2 += nArr2[j];
        }
        
        if(Integer.parseInt(n1) > Integer.parseInt(n2)) {       // 자리가 바뀐 수를 비교하여 더 큰 수를 출력해주면 된다.
            System.out.println(Integer.parseInt(n1));
        } else {
            System.out.println(Integer.parseInt(n2));
        }
        
    }
}
