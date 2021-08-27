package tiger.app;

import tiger.actions.Action;
import tiger.actions.StorageSaveAction;
import tiger.command.Command;
import tiger.exceptions.actions.TigerActionExecutionException;
import tiger.exceptions.inputs.TigerInvalidInputException;
import tiger.exceptions.storage.TigerStorageSaveException;

/**
 * This class handles one iteration of the user input.
 */

public class Pipeline {

    private String input;
    private AppState applicationState;

    public Pipeline(String input, AppState applicationState) {
        this.input = input;
        this.applicationState = applicationState;
    }

    public AppState run() {
        /* First, we try to parse the input */
        Action action;
        AppState newApplicationState;
        try {
            action = Command.getActionFromCommand(this.input, this.applicationState);
        } catch (TigerInvalidInputException e) {
            // if the input is not correct, we return a response that contains the error message
            return new AppState(false, this.applicationState.taskList, e.toString());
        }
        /* Next, we run the action. The only way this to fail is in the done and delete commands, where index might
        be out of bounds. */
        try {
            newApplicationState = action.run();
        } catch (TigerActionExecutionException e) {
            return new AppState(false, this.applicationState.taskList, e.toString());
        }
        /* Lastly, we save the new TaskList. This may incur a TigerStorageSaveException, but most of the time, it
        should be fine. */
        try {
            newApplicationState = new StorageSaveAction(newApplicationState).run();
        } catch (TigerStorageSaveException e) {
            return new AppState(false, this.applicationState.taskList, e.toString());
        }
        /* If everything goes well, we return the new AppState */
        return newApplicationState;
    }


}
