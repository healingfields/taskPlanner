package ma.showmaker.domain.task;

import ma.showmaker.domain.result.Result;

import java.util.ArrayList;
import java.util.List;

public class Pipeline <T>{
    private final List<Task<T, T>> tasks;

    Pipeline(){
        this.tasks = new ArrayList<>();
    }
    Pipeline(List<Task<T, T>> tasks){
        this.tasks = tasks;
    }
    void addTask(Task<T, T> task){
        this.tasks.add(task);
    }

     public Result<T> run(T first_task_input){
        T result = first_task_input;
        for(Task<T, T> task: tasks){
            result = task.execute(result);
        }
        return new Result(result);
     };

}
