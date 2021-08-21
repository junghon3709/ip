package tiger.components;

import tiger.exceptions.TigerEmptyStringException;
import tiger.exceptions.TigerStorageLoadException;

import java.util.HashMap;
import java.util.Map;

public class ToDo extends Task{

    private ToDo(String taskDescription, boolean done) {
        super(taskDescription, done);
    }

    public static ToDo of(String taskDescription, boolean done) throws TigerEmptyStringException {
        return new ToDo(taskDescription, done);
    }

    @Override
    public ToDo markDone() {
        return new ToDo(taskDescription, true);
    }

    @Override
    public String toString() {
        if (this.done) {
            return String.format("[T] [X] %s", this.taskDescription);
        } else {
            return String.format("[T] [ ] %s", this.taskDescription);
        }
    }

    protected String getStorageRepresentation() {
        return String.format("T;%s;%s", this.done, this.taskDescription);
    }

    protected static ToDo getTaskFromStringRepresentation(String s) throws TigerStorageLoadException {
        /* s should be of the form T|true/false|taskDescription| */
        String[] stringArray = s.split(";");
        int length = stringArray.length;
        try {
            assert (length == 3);
            // check if task is indeed a ToDo task
            assert (stringArray[0].equals("T"));
            // check task done value is either true or false
            assert (stringArray[1].equals("true") || stringArray[1].equals("false"));
            // check that task description is non-empty
            assert (!stringArray[2].equals(""));
            if (stringArray[1].equals("true")) {
                return new ToDo(stringArray[2], true); // task description, done
            } else {
                return new ToDo(stringArray[2], false); // task description, done
            }
        } catch (AssertionError e) {
            throw new TigerStorageLoadException(e.toString());
        }
    }
}
