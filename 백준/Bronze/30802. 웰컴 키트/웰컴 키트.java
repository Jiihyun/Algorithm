import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int ppl = Integer.parseInt(br.readLine());
        int[] sizes = new int[6];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < sizes.length; i++) {
            sizes[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int tShirt = Integer.parseInt(st.nextToken());
        int pen = Integer.parseInt(st.nextToken());

        int shirtCount = 0;
        for (int i = 0; i < sizes.length; i++) {
            shirtCount += sizes[i] / tShirt;
            if (sizes[i] % tShirt != 0) {
                shirtCount++;
            }
        }
        System.out.println(shirtCount);
        System.out.print((ppl / pen) + " " + (ppl % pen));
    }
}
