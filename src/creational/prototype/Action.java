package creational.prototype;

public abstract class Action implements Cloneable{
    protected String state;
    Action(){
        initialize();
    }
    @Override
    public Action clone() throws  CloneNotSupportedException{
        //reset to initialState
        initialize();
        //This reset is for subclasses to support there variables reset
        reset();
        Action clone = (Action) super.clone();
        return clone;

    }

    private void initialize() {
        state = "Started";
    }

    public void changeState(){
        state = "Changed";
    }

    public abstract void reset();
}
