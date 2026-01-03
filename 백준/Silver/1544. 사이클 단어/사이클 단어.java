import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        ArrayList<String> distinctWords = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            String currentWord = br.readLine();
            boolean isSame = false;
            
            for (String baseWord : distinctWords) {
                if (currentWord.length() != baseWord.length()) continue;
                
                String doubleBase = baseWord + baseWord;
                if (doubleBase.contains(currentWord)) {
                    isSame = true;
                    break;
                }
            }
            
            if (!isSame) {
                distinctWords.add(currentWord);
            }
        }

        System.out.println(distinctWords.size());
    }
}