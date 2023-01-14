/*
  백준 1100 - 하얀말 문제
  
  체스 판은 8x8로 되어있고, (0.0)은 하얀색 부분이라고 가정, 하얀 부분에 놓인 말의 개수를 구하라
  
  ( 맵에 표현되는 말 = 없으면 '.' (점) / 있으면 'F' )
  
  틀린 이유 : char형 문자를 String형 문자로 비교하는 과정에서 오류 발생 (charAt()을 사용하지 않고 equals를 사용하려 함)
  
*/

import java.util.*;
import java.io.*;
 
public class Main {
 
    public static void main(String[] args) throws IOException {
 
        int answer = 0;
        String[][] chessMap = new String[8][8];           // 체스 맵을 담기위한 배열
 
        Scanner sc = new Scanner(System.in);
 
        for(int i=0; i<8; i++) {
            String[] chess = sc.next().split("");         // 체스 말을 담기 위한 배열
            for(int j=0; j<8; j++) {
                chessMap[i][j] = chess[j];                // 체스 말을 맵에 배치한다.
            }
        }
 
        for(int i=0; i<8; i++) {
            for(int j=0; j<8; j++) {
                if((i + j) % 2 == 0 && chessMap[i][j].equals("F")) {    // x좌표와 y좌표의 합이 2의 배수로 떨어지며, 체스 맵에 F가 존재할 경우 → 하얀 부분에 말이 있다.
                    answer++;
                }
            }
        }
        System.out.println(answer);                   // 하얀 부분에 있는 말 개수 출력
    }
}
