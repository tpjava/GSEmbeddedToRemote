package com.perrin.tony.grid;

import com.perrin.tony.model.Quote;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: tonyperrin
 * Date: 24/02/2014
 * Time: 22:07
 * To change this template use File | Settings | File Templates.
 */
public class EmbeddedGridTest {
    private EmbeddedGrid embeddedGrid;
    @Before
    public void setUp() {
        embeddedGrid = EmbeddedGrid.getInstance();
    }

    @Test
    public void testEmbeddedGrid() {
        Assert.assertNotNull(embeddedGrid);
    }

    @Test
    public void testAddQuote() {
        Quote quote = new Quote("BT",123.45);
        embeddedGrid.getSpace().write(quote);
        Assert.assertTrue(embeddedGrid.getSpace().readById(Quote.class, "BT").getPrice() == 123.45);
    }

    @Test
    public void testRemoveQuote() {
        Assert.assertTrue(embeddedGrid.getSpace().readById(Quote.class, "BT").getPrice() == 123.45);
        embeddedGrid.getSpace().takeById(Quote.class, "BT");
        Assert.assertNull(embeddedGrid.getSpace().readById(Quote.class, "BT"));
    }
}
