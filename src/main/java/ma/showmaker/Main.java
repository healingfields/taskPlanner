package ma.showmaker;

import ma.showmaker.application.PipelineExecutor;
import ma.showmaker.domain.result.Result;
import ma.showmaker.domain.task.Pipeline;
import ma.showmaker.infrastructure.logging.ConsoleLogger;
import ma.showmaker.infrastructure.monitoring.ExecutionTimeMonitor;
import ma.showmaker.infrastructure.monitoring.MemoryMonitor;
import ma.showmaker.tasks.DuplicateStringTask;
import ma.showmaker.tasks.ReplaceSpacesTask;
import ma.showmaker.tasks.UpperCaseTask;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Pipeline<String> pipeline = new Pipeline<>();
        pipeline.addTask(new DuplicateStringTask(10));
        pipeline.addTask(new ReplaceSpacesTask());
        pipeline.addTask(new UpperCaseTask());

        ExecutionTimeMonitor executionTimeMonitor = new ExecutionTimeMonitor();
        MemoryMonitor memoryMonitor = new MemoryMonitor();
        ConsoleLogger consoleLogger = new ConsoleLogger();
        PipelineExecutor<String> pipelineExecutor = new PipelineExecutor<String>(List.of(memoryMonitor, executionTimeMonitor), consoleLogger);

        Result<String> result = pipelineExecutor.execute(pipeline, "lorem ipsum");

        consoleLogger.log("result : " + result.value);
        consoleLogger.log("metrics : " + result.metrics);
    }
}