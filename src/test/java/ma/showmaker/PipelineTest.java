package ma.showmaker;

import ma.showmaker.domain.result.Result;
import ma.showmaker.domain.task.Pipeline;
import ma.showmaker.tasks.DuplicateStringTask;
import ma.showmaker.tasks.LowerCaseTask;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PipelineTest {

    @Test
    void test_pipeline_without_task(){
        Pipeline<String> pipeline = new Pipeline<>();
        Result<String> result = pipeline.run("hello");
        assertEquals("hello", result.value);
    }

    @Test
    void test_pipeline_with_one_task(){
        Pipeline<String> pipeline = new Pipeline<>();
        LowerCaseTask lowerCaseTask = new LowerCaseTask();
        pipeline.addTask(lowerCaseTask);
        Result<String> result = pipeline.run("HELLO");
        assertEquals("hello", result.value);
    }

    @Test
    void test_pipeline_with_many_tasks(){
        Pipeline<String> pipeline = new Pipeline<>();
        DuplicateStringTask duplicateStringTask = new DuplicateStringTask(5);
        LowerCaseTask lowerCaseTask = new LowerCaseTask();
        pipeline.addTask(lowerCaseTask);
        pipeline.addTask(duplicateStringTask);
        Result<String> result = pipeline.run("HELLO");
        assertEquals("hello hello hello hello hello", result.value);
    }

    @Test
    void test_pipeline_with_duplicate_tasks(){
        Pipeline<String> pipeline = new Pipeline<>();
        DuplicateStringTask duplicateStringTask = new DuplicateStringTask(2);
        DuplicateStringTask duplicateStringTask2 = new DuplicateStringTask(2);
        pipeline.addTask(duplicateStringTask);
        pipeline.addTask(duplicateStringTask2);
        Result<String> result = pipeline.run("hello");
        assertEquals("hello hello hello hello", result.value);
    }
    @Test
    void test_pipeline_with_null_input_task(){
        Pipeline<String> pipeline = new Pipeline<>();
        DuplicateStringTask duplicateStringTask = new DuplicateStringTask(2);
        pipeline.addTask(duplicateStringTask);
        assertThrows(RuntimeException.class, () -> pipeline.run(null));
    }
}
