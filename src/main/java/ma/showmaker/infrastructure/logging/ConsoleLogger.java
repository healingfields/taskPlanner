package ma.showmaker.infrastructure.logging;

public class ConsoleLogger implements Logger<String>{

    @Override
    public void log(String message) {
        System.out.println("log : " + message);
    }

    @Override
    public void warn(String message) {
        System.out.println("warn : " + message);
    }
}
