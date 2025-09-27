package ma.showmaker.domain.monitor;

import java.util.Map;

public interface Monitor {

    void start();
    void stop();
    Map<String, String> getMetrics();
}
