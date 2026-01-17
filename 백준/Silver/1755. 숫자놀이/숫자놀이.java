import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    // 숫자에 대응하는 영단어 배열
    static String[] words = {
        "zero", "one", "two", "three", "four", 
        "five", "six", "seven", "eight", "nine"
    };

    public static void main(String[] args) throws Exception {
        // BufferedReader를 이용한 빠른 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        List<NumberInfo> list = new ArrayList<>();

        for (int i = M; i <= N; i++) {
            list.add(new NumberInfo(i, convertToWord(i)));
        }

        // 사전순 정렬
        Collections.sort(list);

        // StringBuilder를 이용한 효율적인 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i).num).append(" ");
            
            // 10개 출력할 때마다 줄바꿈
            if ((i + 1) % 10 == 0) {
                sb.append("\n");
            }
        }
        
        System.out.print(sb.toString().trim());
    }

    static String convertToWord(int n) {
        if (n >= 10) {
            return words[n / 10] + " " + words[n % 10];
        }
        return words[n];
    }

    static class NumberInfo implements Comparable<NumberInfo> {
        int num;
        String word;

        NumberInfo(int num, String word) {
            this.num = num;
            this.word = word;
        }

        @Override
        public int compareTo(NumberInfo o) {
            return this.word.compareTo(o.word);
        }
    }
}