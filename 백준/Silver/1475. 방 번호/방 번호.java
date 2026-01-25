import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        
        // 0부터 9까지 숫자의 빈도를 저장할 배열
        int[] count = new int[10];
        
        for (int i = 0; i < N.length(); i++) {
            int num = N.charAt(i) - '0';
            count[num]++;
        }
        
        // 6과 9를 합쳐서 처리 (서로 뒤집어서 사용 가능하므로)
        int sixNine = count[6] + count[9];
        // 두 개를 합쳐서 2로 나누고 올림 처리
        int neededForSixNine = (sixNine + 1) / 2;
        
        int maxSets = 0;
        
        for (int i = 0; i < 10; i++) {
            if (i == 6 || i == 9) {
                maxSets = Math.max(maxSets, neededForSixNine);
            } else {
                maxSets = Math.max(maxSets, count[i]);
            }
        }
        
        System.out.println(maxSets);
    }
}