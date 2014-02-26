package com.perrin.tony.model;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: tonyperrin
 * Date: 25/02/2014
 * Time: 23:32
 * To change this template use File | Settings | File Templates.
 */
public class QuoteTest {
    @Test
    public void testQuote() {
        Quote quote = new Quote("BT", 123.45);
        Assert.assertNotNull(quote);
        Assert.assertEquals(quote.getSymbol(), "BT");
        Assert.assertEquals(quote.getPrice(), 123.45);
    }
}
