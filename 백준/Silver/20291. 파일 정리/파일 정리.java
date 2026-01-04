import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 데이터 양이 많으므로 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // TreeMap은 Key를 기준으로 사전 순 자동 정렬을 지원함
        Map<String, Integer> extensionMap = new TreeMap<>();

        for (int i = 0; i < N; i++) {
            String fileName = br.readLine();
            // '.'의 위치를 찾아 그 다음 글자부터 끝까지 잘라냄
            String ext = fileName.substring(fileName.indexOf('.') + 1);

            // 기존에 있던 확장자면 +1, 처음이면 1을 저장
            extensionMap.put(ext, extensionMap.getOrDefault(ext, 0) + 1);
        }
        StringBuilder sb = new StringBuilder();
        for (String key : extensionMap.keySet()) {
            sb.append(key).append(" ").append(extensionMap.get(key)).append("\n");
        }
        
        System.out.print(sb.toString());
    }
}