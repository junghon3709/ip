package tiger.components;

public class DeadLine extends Task {

    private String deadLine;

    private DeadLine(String taskDescription, boolean done, String deadLine) {
        super(taskDescription, done);
        this.deadLine = deadLine;
    }

    public static DeadLine of(String taskDescription, boolean done, String deadLine) {
        return new DeadLine(taskDescription, done, deadLine);
    }

    @Override
    public DeadLine markDone() {
        return new DeadLine(this.taskDescription, true, this.deadLine);
    }

    @Override
    public String toString() {
        if (this.done) {
            return String.format("[D] [X] %s (by %s)", this.taskDescription, this.deadLine);
        } else {
            return String.format("[D] [ ] %s (by %s)", this.taskDescription, this.deadLine);
        }
    }

    protected String getStorageRepresentation() {
        return String.format("D|%s|%s|%s", this.done, this.taskDescription, this.deadLine);
    }
}
