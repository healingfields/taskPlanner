package ma.showmaker.infrastructure.monitoring;

import ma.showmaker.domain.monitor.Monitor;

import java.util.Map;

public class MemoryMonitor implements Monitor {
    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    @Override
    public Map<String, String> getMetrics() {
        return Map.of();
    }
}
