import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        // 1. 요청의 개수 M 입력
        int M = Integer.parseInt(br.readLine());
        
        // 2. 무게(w)를 Key로, 사물함 번호(x)를 Value로 저장하는 HashMap 생성
        Map<Integer, Integer> storage = new HashMap<>();
        
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            
            if (type == 1) {
                // 1 x w: x번 사물함에 w 무게 볼링공 추가
                int x = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                storage.put(w, x);
            } else {
                // 2 w: w 무게를 가진 사물함 번호 찾기
                int w = Integer.parseInt(st.nextToken());
                sb.append(storage.get(w)).append("\n");
            }
        }
        
        // 3. 한 번에 결과 출력
        System.out.print(sb.toString());
    }
}