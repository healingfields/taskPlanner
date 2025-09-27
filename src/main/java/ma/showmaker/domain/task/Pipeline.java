package ma.showmaker.domain.task;

import java.util.List;

public abstract class Pipeline <T, R>{
    private List<Task> tasks;

    void addTask(Task task){
        this.tasks.add(task);
    }

    abstract R run(T task);

}
