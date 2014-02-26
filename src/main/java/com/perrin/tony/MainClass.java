package com.perrin.tony;

import com.j_spaces.core.client.SQLQuery;
import com.perrin.tony.grid.EmbeddedGrid;
import com.perrin.tony.model.Quote;
import com.perrin.tony.monitoring.JMXAgent;

import java.util.Random;

/**
 * Hello world!
 *
 */
public class MainClass {
    private static Random random = new Random();
    private static String[] letters = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};

    public static void main( String[] args ) {
        EmbeddedGrid embeddedGrid = EmbeddedGrid.getInstance();

        JMXAgent.getInstance();

        Quote[] quotes = new Quote[10000];

        for(int i = 0 ; i  < 10000 ; i++) {
            Quote quote = new Quote(getSymbol() + i, 123.45 + getUpDownTick());
            quotes[i] = quote;
        }

        embeddedGrid.getSpace().writeMultiple(quotes);

        while(true) {
            try {
                Thread.sleep(5000);
                Quote quote = new Quote(getSymbol(), 123.45 + getUpDownTick());
                embeddedGrid.getSpace().write(quote);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static double getUpDownTick() {
        return random.nextInt(2) == 0 ? 0.1 : -0.1;
    }

    private static String getSymbol() {
        return letters[random.nextInt(26)] + letters[random.nextInt(26)] + letters[random.nextInt(26)];
    }
}
