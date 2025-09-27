package ma.showmaker.infrastructure.monitoring;

import ma.showmaker.domain.monitor.Monitor;

import java.util.Map;

public class ExecutionTimeMonitor implements Monitor<String, Long> {
    private long start_time;
    private long end_time;
    @Override
    public void start() {
        this.start_time = System.nanoTime();
    }

    @Override
    public void stop() {
        this.end_time= System.nanoTime();
    }

    @Override
    public Map<String, Long> getMetrics() {
        return Map.of("time of execution", (end_time- start_time) / 1_000_000);
    }
}
