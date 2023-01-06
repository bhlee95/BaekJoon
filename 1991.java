import java.util.*;
import java.io.*;

public class treeN1991 {
    // 노드 개수를 입력 받기 위한 변수 선언
    private static int K;
    // Main문
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());    // 노드 개수를 입력받음
        
        // Node 변수 값 초기화
        Node[] treeArr = new Node[K];
        char alPhabet = 'A';
        for(int i=0;i<n;i++) {
            treeArr[i] = new Node(alPhabet++);
        } 
        // Node에 값 Input 진행 
        for(int i=0;i<n;i++){
            char[] rl = br.readLine().toCharArray();
            treeArr[rl[0]-65].left = rl[2]=='.'? null : treeArr[rl[2]-65];
            treeArr[rl[0]-65].right = rl[4]=='.'? null : treeArr[rl[4]-65];
        }
        
        // preorder 메소드 값 출력
        System.out.println(first(treeArr[0]));
        // inorder 메소드 값 출력
        System.out.println(second(treeArr[0]));
        // postorder 메소드 값 출력
        System.out.println(third(treeArr[0]));
        
    }
    // 가운데 - 좌측 - 우측 순으로 트리를 순행하는 메소드
    private static String first(Node node){
        String val = "";
        val += node.self;                                   // 본인(가운데) 트리의 값을 담음
        if(node.left != null) val += first(node.left);      // 좌측 트리의 값을 담음
        if(node.right != null) val += first(node.right);    // 우측 트리의 값을 담음
        return val;
    }
    // 좌측 - 가운데 - 우측 순으로 트리를 순행하는 메소드
    private static String second(Node node){
        String val = "";
        if(node.left != null) val += second(node.left);     // 좌측 트리의 값을 담음
        val += node.self;                                   // 본인(가운데) 트리의 값을 담음
        if(node.right != null) val += second(node.right);   // 우측 트리의 값을 담음
        return val;    
    }
    // 좌측 - 우측 - 가운데 순으로 트리를 순행하는 메소드
    private static String third(Node node){
        String val = "";
        if(node.left != null) val += third(node.left);      // 좌측 트리의 값을 담음
        if(node.right != null) val += third(node.right);    // 우측 트리의 값을 담음
        val += node.self;                                   // 본인(가운데) 트리의 값을 담음
        return val;    
    }
    // 본인(가운데) 값, 좌측 값, 우측 값을 저장하고자 만든 클래스
    private static class Node{
        char self;
        Node left, right;
        public Node(char self){
            this.self = self;
        }
        public String toString(){
            return self+"";
        }
    }
}
