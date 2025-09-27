package ma.showmaker.infrastructure.monitoring;

import ma.showmaker.domain.monitor.Monitor;

import java.util.Map;

public class MemoryMonitor implements Monitor<String, String> {
    long used_memory_before;
    long used_memory_after;
    @Override
    public void start() {
        this.used_memory_before = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    }

    @Override
    public void stop() {
        this.used_memory_after = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    }

    @Override
    public Map<String, String> getMetrics() {
        return Map.of("used memory to execute the task (Bytes)", String.valueOf(used_memory_after - used_memory_before));
    }
}
