package ma.showmaker.domain.task;

public interface Task <T, R>{
    R execute(T input);
}
