package io.swagger.api;

import org.apache.kudu.client.AsyncKuduClient;

public class KuduContext {
    private static KuduContext INSTANCE;
    private final AsyncKuduClient kuduClient_;

    public AsyncKuduClient getClient() {
        return kuduClient_;
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