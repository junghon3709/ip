package tiger.actions;

import tiger.components.TaskList;
import tiger.components.DeadLine;
import tiger.utils.CustomDate;

public class DeadLineAction extends Action {
    AppState applicationState;
    String todo;
    String dateLine;

    public DeadLineAction(AppState applicationState, String todo, String dateLine) {
        this.applicationState = applicationState;
        this.todo = todo;
        this.dateLine = dateLine;
    }

    public AppState run() {
        TaskList taskList = this.applicationState.taskList;
        TaskList newTaskList = taskList.addTask(DeadLine.of(this.todo, false, this.dateLine));
        System.out.println(String.format("Excellent! I've added this deadline:\n%s",
                taskList.showTask(taskList.size() - 1)));
        return new AppState(applicationState.userExit, newTaskList);
    }
}
