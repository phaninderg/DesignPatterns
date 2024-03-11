package creational.prototype;

public class Running extends Action{

    String currentState;

    void run() {
        currentState = "Running";
    }

    @Override
    public Action clone() {
        try {
            throw new CloneNotSupportedException();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void reset() {
        throw new UnsupportedOperationException("This will not be called");
    }

    @Override
    public String toString() {
        return "Running{" +
                "currentState='" + currentState + '\'' +
                ", initialState='" + state + '\'' +
                '}';
    }
}
