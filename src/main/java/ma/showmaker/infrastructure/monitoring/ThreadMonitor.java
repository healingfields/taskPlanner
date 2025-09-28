package ma.showmaker.infrastructure.monitoring;

import ma.showmaker.domain.monitor.Monitor;

import java.util.Map;

public class ThreadMonitor implements Monitor<String, String> {

    private int thread_count;

    @Override
    public void start() {

    }

    @Override
    public void stop() {
        this.thread_count = Thread.activeCount();
    }

    @Override
    public Map<String, String> getMetrics() {
        return Map.of("Active Threads: ", String.valueOf(this.thread_count));
    }
}
