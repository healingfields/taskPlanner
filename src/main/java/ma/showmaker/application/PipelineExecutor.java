package ma.showmaker.application;

import java.util.List;
import ma.showmaker.domain.monitor.Monitor;
import ma.showmaker.domain.result.Result;
import ma.showmaker.domain.task.Pipeline;

public abstract class PipelineExecutor {
    List<Monitor> monitors;

    abstract Result execute(Pipeline pipeline);


}
