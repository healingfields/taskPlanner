package ma.showmaker.tasks;

import ma.showmaker.domain.task.Task;

public class DuplicateStringTask implements Task<String, String> {
    int number_of_times;
    public DuplicateStringTask(int number_of_times){
        this.number_of_times  = number_of_times;
    }
    @Override
    public String execute(String input) {
        if(this.number_of_times == 0) return input;
        StringBuilder string_builder = new StringBuilder();
        for(int i = 0; i < this.number_of_times;i++){
            string_builder.append(" ");
            string_builder.append(input);
        }
        return string_builder.toString();
    }
}
