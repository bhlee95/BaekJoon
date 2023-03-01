
/*

백준 1181 - 단어 정렬 문제

알파벳 소문자로 이루어진 N개의 단어가 들어오면 아래와 같은 조건에 따라 정렬하는 프로그램을 작성하시오.

  1. 길이가 짧은 것부터
  2. 길이가 같으면 사전 순으로
  
단, 중복된 단어는 하나만 남기고 제거해야 한다.


접근 방식

1) 단어를 넣을 배열을 선언 후, 배열에 단어들을 넣음

2) 단어 2개의 길이를 비교하면서 길이가 같은 경우에는 사전 순으로 정렬하고, 그 외의 경우는 단어 길이순으로 정렬함

*/


import java.util.*;

public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        String[] words = new String[N];
        
        sc.nextLine();		// scanner를 쓸 때, nextInt로 입력 받은 후, nextLine을 사용하면 두 메소드의 작동 매커니즘이 달라 에러가 발생할 수 있음. (nextLine을 입력받게되면 개행이 입력받아짐)
        
        for(int i=0; i<N; i++) {
            words[i] = sc.nextLine();     // 단어를 넣음
        }
        
        Arrays.sort(words, new Comparator<String>(){
           @Override
           public int compare(String w1, String w2) {
               if(w1.length() == w2.length()) {       // 단어 길이가 같은 경우
                   return w1.compareTo(w2);           // 사전 순으로 정렬하게 compareTo 메소드 사용
               } else {
                   return w1.length() - w2.length();  // 이외의 경우 단어 길이순으로 정렬한다.
               }
           }
        });

        System.out.println(words[0]);
        
        for(int i=1; i<N; i++) {
            if(!words[i].equals(words[i-1])) {
                System.out.println(words[i]);
            }
        }
    }
}
