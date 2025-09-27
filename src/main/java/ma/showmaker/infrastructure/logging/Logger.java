package ma.showmaker.infrastructure.logging;

public interface Logger<T> {
    void log(T message);
    void warn(T message);
}
