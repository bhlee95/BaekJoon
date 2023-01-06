import java.io.*;
import java.util.*;

public class Tree {   // 백준 Tree 알고리즘 14725 - 개미굴 문제

    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   // buffer 읽어들임

        T = Integer.parseInt(br.readLine());                                        // 개미굴의 구조를 알아내기 위해 Line 수를 알아냄
        
        Node nd = new Node();       // Tree 구조로 탐색하기 위해 Node 생성

        StringTokenizer lineSt;         

        for(int i=0; i < T; i++){
            lineSt = new StringTokenizer(br.readLine());
            int tkSize = Integer.parseInt(st.nextToken());
            Node curNode = nd;                              // 현 위치 Node

            for(int j=0; j<tkSize; j++){
                String s = lineSt.nextToken();

                if(!curNode.childNode.containsKey(s)){         // 현 위치 노드의 하위가 읽어들인 값을 포함하고 있지 않다면
                    curNode.childNode.put(s, new Node());      // 값을 노드에 저장
                }
                curNode = curNode.childNode.get(s);            // 하위 값을 얻어 node에 저장
            }
        }
        nodePrint(nd, "");                                  // node의 값을 정렬하여 출력하기 위한 메소드
    }

    public static void nodePrint(Node nd, String floor){
        Object[] food = nd.childNode.keySet().toArray();        // key값을 얻어 배열에 저장
        Arrays.sort(food);                                   // 배열 정렬
  
        for (Object s : food){
            System.out.println(floor+s);                      // 층을 -- 로 표현, 각 층에 어떤 먹이가 있는지 출력한다.
            print(nd.childNode.get(s),floor+"--");
        }
    }

}

class childNode{
    HashMap<String, Node> childNode = new HashMap<>();
}
