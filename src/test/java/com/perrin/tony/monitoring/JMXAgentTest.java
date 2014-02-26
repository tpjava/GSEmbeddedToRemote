package com.perrin.tony.monitoring;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: tonyperrin
 * Date: 25/02/2014
 * Time: 22:45
 * To change this template use File | Settings | File Templates.
 */
public class JMXAgentTest {
    @Test
    public void testJMXAgent() {
        JMXAgent jmxAgent = JMXAgent.getInstance();
        Assert.assertNotNull(jmxAgent);
    }
}
