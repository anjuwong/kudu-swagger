package io.swagger.api;

import org.apache.kudu.client.AsyncKuduClient;

public class KuduContext {
    private static KuduContext INSTANCE;
    private final AsyncKuduClient kuduClient_;

    public static String master_addr_;
    public AsyncKuduClient getClient() {
        return kuduClient_;
    }

    public synchronized static void resetInstance() {
        AsyncKuduClient client = new AsyncKuduClient.AsyncKuduClientBuilder(
            KuduContext.master_addr_).build();
        INSTANCE = new KuduContext(client);
    }

    public synchronized static KuduContext getInstance(AsyncKuduClient client) {
        if (INSTANCE == null) {
            INSTANCE = new KuduContext(client);
        }
        return INSTANCE;
    }

    public synchronized static KuduContext getInstance() {
        assert(INSTANCE != null);
        return INSTANCE;
    }

    KuduContext(final AsyncKuduClient client) {
        this.kuduClient_ = client;
    }

}