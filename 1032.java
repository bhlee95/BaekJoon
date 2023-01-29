/*

백준 1032 - 명렁 프롬프트 문제

시작 -> 실행 -> cmd를 쳐보자. 검정 화면이 눈에 보인다. 여기서 dir이라고 치면 그 디렉토리에 있는 서브디렉토리와 파일이 모두 나온다. 
이때 원하는 파일을 찾으려면 다음과 같이 하면 된다.

dir *.exe라고 치면 확장자가 exe인 파일이 다 나온다. "dir 패턴"과 같이 치면 그 패턴에 맞는 파일만 검색 결과로 나온다. 
예를 들어, dir a?b.exe라고 검색하면 파일명의 첫 번째 글자가 a이고, 세 번째 글자가 b이고, 확장자가 exe인 것이 모두 나온다. 
이때 두 번째 문자는 아무거나 나와도 된다. 예를 들어, acb.exe, aab.exe, apb.exe가 나온다.

이 문제는 검색 결과가 먼저 주어졌을 때, 패턴으로 뭘 쳐야 그 결과가 나오는지를 출력하는 문제이다. 패턴에는 알파벳과 "." 그리고 "?"만 넣을 수 있다. 
가능하면 ?을 적게 써야 한다. 그 디렉토리에는 검색 결과에 나온 파일만 있다고 가정하고, 파일 이름의 길이는 모두 같다.


문제 접근방식

1. 파일 이름 개수 N 불러옴

2. 파일 명을 불러와 String 배열에 저장

3. String 배열에 저장된 값을 불러와 char 형으로 변환하여 가장 첫 배열에 담긴 글자들과 이후 배열의 글자들을 한글자씩 비교함

4. 같은 글자라면 그대로 저장, 다른 글자라면 "?"를 저장

5. 이후 answer를 출력한다.

*/


import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String answer = "";
        
        int N = sc.nextInt();                       // 파일 이름 개수
        String[] fileName = new String[N];          // 파일명을 저장하기 위한 String 배열 선언
        
        for(int i=0; i<N; i++) {
            fileName[i] = sc.next();                // 파일명을 String 배열에 담는다.
        }
        
        for(int i=0; i<fileName[0].length(); i++) {
            boolean sameWord = true;                // 글자가 같은지 여부
            char word = fileName[0].charAt(i);      // 한 글자씩 비교하기 위함
            
            for(int j=0; j<N; j++) {
                if(word != fileName[j].charAt(i)) { // word에 담긴 글자가 다음 배열의 글자와 같지 않으면 break
                    sameWord = false;
                    break;
                }
            }
                
            if(sameWord == true) {                  
                answer += Character.toString(word); // 글자가 같다면 answer에 string 형으로 저장
            } else {
                answer += "?";                      // 글자가 틀리면 "?"를 저장
            }
        }
        
        System.out.println(answer);                 // 모든 반복문이 끝나면 
    }
}
