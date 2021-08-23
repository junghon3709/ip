package tiger.app;

import tiger.components.TaskList;

/**
 * Represents the current state of the Application.
 */

public class AppState {
    /** Whether the user has exited the program*/
    private boolean userExit;
    /** A {@code TaskList} to store user tasks */
    public TaskList taskList;
    /** String to store the response in */
    private String response;
    /** Flag in case some tasks failed to execute properly, or require subsequent follow ups */
    public String flag;

    // TODO: set priority tasks

    /**
     * Public constructor for the {@code AppState} class.
     *
     * @param userExit whether the user has exited the program.
     * @param taskList a {@code TaskList} to store user tasks.
     */

    public AppState(boolean userExit, TaskList taskList) {
        this.userExit = userExit;
        this.taskList = taskList;
        this.response = "";
    }

    public AppState(boolean userExit, TaskList taskList, String response) throws AssertionError {
        this.userExit = userExit;
        this.taskList = taskList;
        assert (!response.equals(""));
        this.response = response;
    }

    /**
     * Returns the number of tasks in the {@code TaskList}.
     *
     * @return the number of tasks in the {@code TaskList}.
     */

    public int numTasks() {
        return this.taskList.size();
    }

    /**
     * Checks if the user has exited the program.
     *
     * @return a boolean to indicate if the user has exited the program.
     */

    public boolean isExited() {
        return this.userExit;
    }

    public String getResponse() {
        assert (!this.response.equals(""));
        return this.response;
    }

}
