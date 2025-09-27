package ma.showmaker.domain.result;

import java.util.List;
import java.util.Map;

public class Result<R>{
    public R value;
    public List<Map<String, String>> metrics;

    public Result(R value){
        this.value = value;
    }

    public void addMetrics(Map<String, String> metrics){
        this.metrics.add(metrics);
    }
}
