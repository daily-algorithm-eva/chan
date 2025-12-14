import java.io.*;
import java.util.*;

class Main {
    static int n,c,m;
    static class Node{
        int start;
        int w;
        public Node(int start, int w) {
            this.start = start;
            this.w = w;
        }
    }
    static List<Node>[] nodes;
    static int[] remainingBoxes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(br.readLine());
        nodes = new List[n+1];
        remainingBoxes = new int[n+1];
        for(int i =0;i<=n;i++) {
            nodes[i] = new ArrayList<>();
        }
        
        for(int i =0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            nodes[end].add(new Node(start, w));
        }
        
        int res = 0;
        Arrays.fill(remainingBoxes, c);

        /*
        도착시간이 가까운 순서대로 배송할 수 있는 최대 박스 개수 카운팅
        */
        for(int i =2;i<=n;i++) {
            for(Node node : nodes[i]) {
                int start = node.start;
                int end = i;
                int w = node.w;
                int max = w;
                for(int j = start;j<end;j++) {
                    if(max > remainingBoxes[j]){
                        max = remainingBoxes[j];
                    }
                }
                for(int j = start;j<end;j++) {
                    remainingBoxes[j] -= max;
                }
                res += max;
            }
        }
        System.out.println(res);
    }
}