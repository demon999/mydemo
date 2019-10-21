package com.xxx.es;

import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
// import org.elasticsearch.common.settings.ImmutableSettings;
// import org.elasticsearch.common.settings.Settings;
// import org.elasticsearch.common.transport.InetSocketTransportAddress;
// import org.elasticsearch.node.Node;
// import org.elasticsearch.node.NodeBuilder;

/**
 * @author Richard Xue
 * @version 1.0
 * @date 05/29/2015
 * @description
 */
public class Sample {
    public static void main(String[] args) {
        Sample sample = new Sample();
        // sample.test();
    }

    /*
    public void test() {
        Node node = NodeBuilder.nodeBuilder().node();
        Client client = node.client();

        GetResponse getResponse = client.prepareGet("twitter", "tweet", "1").execute().actionGet();

        System.out.println(getResponse.getIndex());

        DeleteResponse deleteResponse = client.prepareDelete("twitter", "tweet", "1").execute().actionGet();

        client.close();
        node.close();
    }

    public void test2() {
        Node node = NodeBuilder.nodeBuilder().clusterName("yourclustername").node();
        Client client = node.client();
    }

    public void test3() {
        Node node = NodeBuilder.nodeBuilder().client(true).node();
        Client client = node.client();
        client.close();
        node.close();
    }

    public void test4() {
        Node node = NodeBuilder.nodeBuilder().local(true).node();
        Client client = node.client();
        client.close();
        node.close();
    }

    public void test5() {
        Client client = new TransportClient()
                .addTransportAddress(new InetSocketTransportAddress("host1", 9300))
                .addTransportAddress(new InetSocketTransportAddress("host2", 9300));
        // on shutdown
        client.close();
    }

    public void test6() {
        Settings settings = ImmutableSettings.settingsBuilder().put("cluster.name", "myClusterName").build();
        Client client =    new TransportClient(settings);

//        Settings settings = ImmutableSettings.settingsBuilder().put("client.transport.sniff", true).build();
//        TransportClient client = new TransportClient(settings);
    }
    */
}
