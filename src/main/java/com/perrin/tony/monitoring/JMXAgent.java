package com.perrin.tony.monitoring;

import com.perrin.tony.grid.EmbeddedGrid;
import com.sun.jdmk.comm.HtmlAdaptorServer;

import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.ObjectName;

/**
 * Created by IntelliJ IDEA.
 * User: tonyperrin
 * Date: 25/02/2014
 * Time: 22:38
 * To change this template use File | Settings | File Templates.
 */
public class JMXAgent {
    private MBeanServer mBeanServer;
    private ObjectName jmxAgent;
    private ObjectName adaptorName;
    private HtmlAdaptorServer adaptor;
    private static JMXAgent instance;


    private JMXAgent() {
        init();
    }

    public static JMXAgent getInstance() {
        if(instance == null) {
            synchronized (JMXAgent.class) {
                if(instance == null) {
                    instance = new JMXAgent();
                }
            }
        }
        return instance;
    }

    public void init() {
        System.out.println("Starting JMX agent...");
        mBeanServer = MBeanServerFactory.createMBeanServer("JMXAgent");
        adaptor = new HtmlAdaptorServer();

        try {
            jmxAgent = new ObjectName("JMXAgent:name=JMXAgent");
            mBeanServer.registerMBean(EmbeddedGrid.getInstance(), jmxAgent);
            adaptorName = new ObjectName("JMXAgent:name=htmladaptor, port=9092");
            adaptor.setPort(9092);
            mBeanServer.registerMBean(adaptor, adaptorName);
            adaptor.start();
        }  catch (Exception e) {
            e.printStackTrace();
        }
    }
}
