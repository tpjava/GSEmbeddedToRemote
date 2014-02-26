package com.perrin.tony.grid;

import com.perrin.tony.model.Quote;
import org.openspaces.core.GigaSpace;
import org.openspaces.core.GigaSpaceConfigurer;
import org.openspaces.core.space.UrlSpaceConfigurer;

/**
 * Created by IntelliJ IDEA.
 * User: tonyperrin
 * Date: 21/02/2014
 * Time: 20:34
 * To change this template use File | Settings | File Templates.
 */

/**
 * NOTE:
 * This class relies on a GS agent running on a separate process.
 * Once Gigaspaces is installed you can start the agent using:
 * NIC_ADDR=127.0.0.1 gs-agent.sh gsa.global.lus 0 gsa.lus 1
 */

public class GSRemoteGrid {
    private static GSRemoteGrid instance;
    private UrlSpaceConfigurer configurer;
    private GigaSpace space;

    private GSRemoteGrid() {
        init();
    }

    private void init() {
        configurer = new UrlSpaceConfigurer("jini://*/*/embeddedSpace?cluster_schema=sync_replicated&total_members=2&id=2");
        space = new GigaSpaceConfigurer(configurer).create();
    }

    public static GSRemoteGrid getInstance() {
        if(instance == null) {
            synchronized (GSRemoteGrid.class) {
                if(instance == null) {
                    instance = new GSRemoteGrid();
                }
            }
        }
        return instance;
    }

    public void addQuote(Quote quote) {
        space.write(quote);
    }

    public Quote getQuote(String symbol) {
        return null;
    }
}
