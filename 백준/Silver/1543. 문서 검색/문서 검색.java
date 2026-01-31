import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 문서와 찾을 단어 입력 받기
        String document = br.readLine();
        String target = br.readLine();
        
        int count = 0;
        int startIndex = 0;
        int targetLength = target.length();
        
        // startIndex부터 문서를 탐색하며 target이 존재하는지 확인
        while (true) {
            // indexOf는 찾으려는 문자열이 없으면 -1을 반환함
            int foundIndex = document.indexOf(target, startIndex);
            
            if (foundIndex != -1) {
                // 단어를 찾은 경우
                count++;
                // 중복을 피하기 위해 찾은 단어의 끝부분 다음 인덱스로 이동
                startIndex = foundIndex + targetLength;
            } else {
                // 더 이상 찾을 수 없는 경우 반복 종료
                break;
            }
        }
        
        System.out.println(count);
    }
}