package creational.prototype;

public class Moving extends Action{

    String currentState;

    void move() {
        currentState = "Moving";
    }

    @Override
    public Action clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public void reset() {
        currentState = "Halted";
    }

    @Override
    public String toString() {
        return "Moving{" +
                "currentState='" + currentState + '\'' +
                ", initialState='" + state + '\'' +
                '}';
    }
}
