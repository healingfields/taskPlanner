package ma.showmaker.infrastructure.monitoring;

import ma.showmaker.domain.monitor.Monitor;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.List;
import java.util.Map;

public class GCMonitor implements Monitor<String, String> {
    private long GC_count;
    @Override
    public void start() {

    }

    @Override
    public void stop() {
        List<GarbageCollectorMXBean> garbage_Collector_MXBeans = ManagementFactory.getGarbageCollectorMXBeans();
        this.GC_count = garbage_Collector_MXBeans.stream().mapToLong(GarbageCollectorMXBean::getCollectionCount).sum();
    }

    @Override
    public Map<String, String> getMetrics() {
        return Map.of("number of GC during execution", String.valueOf(this.GC_count));
    }
}
