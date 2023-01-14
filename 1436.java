/*
  백준 1436 - 영화감독 숌
  
  백준 1436 최초 틀린 이유
  영화는 1편부터 진행 → N편을 제작한다고 했을 때, 처음 선언한 영화 편 수가 N으로 count될 때 까지 666(startNum)을 + 했어야 했는데, while이 아닌 if문을 사용하는 실수를하여 반복하지 않고 바로 끝내버림

  if문을 while문으로 수정하여 해결
  
*/


import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());        // 제작할 영화의 편 수를 입력받음
        
        int startNum = 666;                             // 숌의 첫 시작 영화 제목은 666부터 시작.... (1편 666 / 2편 1666 / 3편 2666 ... 순으로 진행)
        int movieCount = 1;                             // 영화는 1편부터 만들어진다
        
        while(movieCount != N) {                        // 영화 편 수의 count가 제작할 영화의 편수와 같지 않으면
            startNum++;                                 // 영화 제목에 들어갈 숫자 ++
            
            if(String.valueOf(startNum).contains("666")) {    // 영화 제목에 쓸 숫자를 더하다가 666이 포함되어 있다면
                movieCount++;                                 // 영화 편 수 count ++
            }
        } 
        System.out.println(startNum);                         // 최종적으로 movieCount == N이 된다면 영화 제목에 들어갈 수 출력
    }
}
