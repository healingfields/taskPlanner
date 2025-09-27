package ma.showmaker.application;

import java.util.List;
import ma.showmaker.domain.monitor.Monitor;
import ma.showmaker.domain.result.Result;
import ma.showmaker.domain.task.Pipeline;
import ma.showmaker.infrastructure.logging.Logger;

public class PipelineExecutor<T> {
    List<Monitor> monitors;
    Logger<String> logger;

    PipelineExecutor(List<Monitor> monitors, Logger<String> logger){
        this.monitors = monitors;
        this.logger = logger;
    }

    Result<T> execute(Pipeline<T> pipeline, T pipeline_input){
        logger.log("started executing the pipeline");
        this.monitors.forEach(Monitor::start);

        Result<T> result = pipeline.run(pipeline_input);

        this.monitors.forEach(Monitor::stop);
        logger.log("pipeline executed");
        this.monitors.forEach(monitor -> result.addMetrics(monitor.getMetrics()));
        return result;
    }


}
