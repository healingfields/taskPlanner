package ma.showmaker.domain.result;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Result<R>{
    public R value;
    public List<Map<R, R>> metrics = new ArrayList<>();

    public Result(R value){
        this.value = value;
    }

    public void addMetrics(Map<R, R> metrics){
        this.metrics.add(metrics);
    }
}
