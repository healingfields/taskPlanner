package ma.showmaker.tasks;

import ma.showmaker.domain.task.Task;

public class ReplaceSpacesTask implements Task<String, String> {
    @Override
    public String execute(String input) {
        return input.replaceAll("\\s+", "_");
    }
}
