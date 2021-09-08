package FastRead;

import java.io.BufferedReader;
import java.io.FileReader;

public class Main {

    public static void main(String[] args) {

        FastRead fastRead1 = new FastRead();

        // BufferedReader br1 = new BufferedReader(new FileReader("marketState.txt"));

        String marketState = "{\"timestamp\":0,\"book\":\"AAPL\",\"bids\":[],\"asks\":[{\"price\":600,\"volume\":10}]}";
 
        String actions = fastRead1.fastRead(700, 900, marketState);

        System.out.println(actions);
    }
    
}
