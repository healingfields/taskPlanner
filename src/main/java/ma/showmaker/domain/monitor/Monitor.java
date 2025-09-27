package ma.showmaker.domain.monitor;

import java.util.Map;

public interface Monitor<R, T> {

    void start();
    void stop();
    Map<R, T> getMetrics();
}
