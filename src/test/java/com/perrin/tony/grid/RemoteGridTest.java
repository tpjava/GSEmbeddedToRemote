package com.perrin.tony.grid;

import com.perrin.tony.model.Quote;
import junit.framework.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: tonyperrin
 * Date: 21/02/2014
 * Time: 20:33
 * To change this template use File | Settings | File Templates.
 */

/**
 * NOTE:
 * These tests rely on a GS agent running on a separate process.
 * Once Gigaspaces is installed you can start the agent using:
 * NIC_ADDR=127.0.0.1 gs-agent.sh gsa.global.lus 0 gsa.lus 1
 */

public class RemoteGridTest {
    @Test
    @Ignore
    public void testGrid() {
        GSRemoteGrid gsgrid = GSRemoteGrid.getInstance();
        Assert.assertNotNull(gsgrid);
    }

    @Test
    @Ignore
    public void testAddQuote() {
        GSRemoteGrid gsgrid = GSRemoteGrid.getInstance();
        Quote quote = new Quote();
        quote.setSymbol("BT");
        quote.setPrice(123.45);
        gsgrid.addQuote(quote);
        Assert.assertTrue(gsgrid.getQuote("BT").getPrice() == 123.45);
    }
}
