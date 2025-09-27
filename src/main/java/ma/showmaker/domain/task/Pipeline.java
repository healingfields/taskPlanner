package ma.showmaker.domain.task;

import ma.showmaker.domain.result.Result;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Pipeline <T>{
    private final List<Task<T, T>> tasks;

    public Pipeline(){
        this.tasks = new ArrayList<>();
    }
    public Pipeline(List<Task<T, T>> tasks){
        this.tasks = tasks;
    }
    public void addTask(Task<T, T> task){
        this.tasks.add(task);
    }

     public Result<T> run(T first_task_input) throws RuntimeException {
        if(Objects.isNull(first_task_input)){
            throw new RuntimeException("input is null");
        }
        T result = first_task_input;
        for(Task<T, T> task: tasks){
            result = task.execute(result);
        }
        return new Result(result);
     };

}
