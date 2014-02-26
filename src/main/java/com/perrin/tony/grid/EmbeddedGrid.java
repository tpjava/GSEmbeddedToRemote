package com.perrin.tony.grid;

import com.j_spaces.core.client.SQLQuery;
import com.perrin.tony.model.Quote;
import org.openspaces.core.GigaSpace;
import org.openspaces.core.GigaSpaceConfigurer;
import org.openspaces.core.space.UrlSpaceConfigurer;

/**
 * Created by IntelliJ IDEA.
 * User: tonyperrin
 * Date: 24/02/2014
 * Time: 22:08
 * To change this template use File | Settings | File Templates.
 */

public class EmbeddedGrid implements EmbeddedGridMBean {
    private static EmbeddedGrid instance;
    private UrlSpaceConfigurer configurer;
    private GigaSpace space;

    private EmbeddedGrid() {
        init();
    }

    private void init() {
        configurer = new UrlSpaceConfigurer("/./embeddedSpace?cluster_schema=sync_replicated&total_members=2&id=1");
        space = new GigaSpaceConfigurer(configurer).create();
    }

    public static EmbeddedGrid getInstance() {
        if(instance == null) {
            synchronized (EmbeddedGrid.class) {
                if(instance == null) {
                    instance = new EmbeddedGrid();
                }
            }
        }
        return instance;
    }

    public GigaSpace getSpace() {
        return space;
    }

    @Override
    public int getQuoteCount() {
        return space.readMultiple(new SQLQuery<Quote>(Quote.class, "price >= 0")).length;
    }
}
