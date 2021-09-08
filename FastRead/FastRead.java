package FastRead;

import java.util.*;
import java.util.function.*;

public class FastRead {
    
    public String fastRead(double maxBuyPrice, double minSellPrice, String marketState) {
    
        boolean buyFound = false;
        String actions = "";
        
        // Current marketState index 
        int c = 0;
        
        int streak = 0;
                                
        // Skip timestamp 
        c += 13;
        
        actions += "S" + 13 + " ";
        
        // Read timestamp value 
        streak = 0;
        
        while (marketState.charAt(c) != ',') {
            streak += 1;
            c += 1;
        }
        
        // Read , character 
        streak += 1;
        c += 1;
        
        actions += "R" + streak + " ";
        
        // Skip book 
        c += 8;
        
        actions += "S" + 8 + " ";
        
        // Read book value 
        streak = 0;
        
        while (!(marketState.charAt(c) == '"')) {
            streak += 1;
            c += 1;
        }
        
        // Read " character 
        streak += 1;
        c += 1;
        
        actions += "R" + streak + " ";
        
        // Skip bids 
        c += 9;
        
        actions += "S" + 9 + " ";
        
        // Read bids value 
        if (!(marketState.charAt(c) == ']')) {
            
            // Bids non empty 
            boolean firstBid = true;
            
            // Read { character 
            c += 1;
            
            actions += "R" + 1 + " ";
            
            // Read bid 
            while (!(marketState.charAt(c) == ']')) {
                
                if (!firstBid) {
                    
                    // Skip { character 
                    c += 1;
                    
                    actions += "S" + 1 + " ";
                }
                
                // Skip price 
                c += 8;
                
                actions += "S" + 8 + " ";
                
                // Read price value 
                streak = 0;
                
                while (!(marketState.charAt(c) == ',')) {
                    streak += 1;
                    c += 1;
                }
                
                String strBidPrice = marketState.substring(c - streak, c);
                int bidPrice = Integer.parseInt(strBidPrice);
                
                // Read , character 
                streak += 1;
                c += 1;
                
                actions += "R" + streak + " ";
                
                // Get if buyFound 
                if (bidPrice >= maxBuyPrice) {
                    return actions;
                }
                
                // Skip volume 
                c += 9;
                
                actions += "S" + 9 + " ";
                
                // Read volume value and } character 
                streak = 0;
                
                while (!(marketState.charAt(c) == ',') 
                        && !(marketState.charAt(c) == ']')) {
                    streak += 1;
                    c += 1;
                }
                
                actions += "R" + streak + " ";
                
                if (marketState.charAt(c) == ',') {
                    
                    // Read , character 
                    c += 1;
                    
                    actions += "R" + 1 + " ";
                }
                
                firstBid = false;
            }
        }
        
        // Read ] character 
        c += 1;
            
        actions += "R" + 1 + " ";
        
        // Skip asks 
        c += 9;
        
        actions += "S" + 9 + " ";
        
        // Read asks value 
        if (!(marketState.charAt(c) == ']')) {
            
            // Asks non empty 
            boolean firstAsk = true;
            
            // Read { character 
            c += 1;
            
            actions += "R" + 1 + " ";
            
            // Read ask 
            while (!(marketState.charAt(c) == ']')) {
                
                if (!firstAsk) {
                    
                    // Skip { character 
                    c += 1;
                    
                    actions += "S" + 1 + " ";
                }
                
                // Skip price 
                c += 8;
                
                actions += "S" + 8 + " ";
                
                // Read price value 
                streak = 0;
                
                while (!(marketState.charAt(c) == ',')) {
                    streak += 1;
                    c += 1;
                }
                
                String strAskPrice = marketState.substring(c - streak, c);
                int askPrice = Integer.parseInt(strAskPrice);
                
                // Read , character 
                streak += 1;
                c += 1;
                
                actions += "R" + streak + " ";
                
                // Get if buyFound 
                if (askPrice <= maxBuyPrice) {
                    return actions;
                }
                
                // Skip volume 
                c += 9;
                
                actions += "S" + 9 + " ";
                
                // Read volume value and } character 
                streak = 0;
                
                while (!(marketState.charAt(c) == ',') 
                        && !(marketState.charAt(c) == ']')) {
                    streak += 1;
                    c += 1;
                }
                
                actions += "R" + streak + " ";
                
                if (marketState.charAt(c) == ',') {
                    
                    // Read , character 
                    c += 1;
                    
                    actions += "R" + 1 + " ";
                }
                
                firstAsk = false;
            }
        }
        
        // Read ] character 
        c += 1;
            
        actions += "R" + 1 + " ";
        
        return actions;
    }
}
