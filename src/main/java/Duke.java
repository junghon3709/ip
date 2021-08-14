import actions.*;
import commands.CommandParser;
import commands.DoneCommand;
import commands.ToDoCommand;
import components.TaskList;

import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String greetingMessage = "Hello! I'm Tiger :)\nWhat can I do for you?";
        TaskList taskList = new TaskList();
        System.out.println(greetingMessage);

        AppState applicationState = new AppState(false, taskList);
        while (!applicationState.isExited()) {
            String userInput = scanner.nextLine();
            CommandParser command = new CommandParser(userInput);
            switch (command.getCommand()) {
                case "bye":
                    ByeAction byeAction = new ByeAction(applicationState);
                    applicationState = byeAction.run();
                    break;
                case "list":
                    ListAction listAction = new ListAction(applicationState);
                    applicationState = listAction.run();
                    break;
                case "done":
                    DoneCommand doneCommand = new DoneCommand(userInput);
                    MarkDoneAction markDoneAction = new MarkDoneAction(applicationState, doneCommand.index - 1);
                    applicationState = markDoneAction.run();
                    break;
                case "todo":
                    ToDoCommand toDoCommand = new ToDoCommand(userInput);
                    ToDoAction toDoAction = new ToDoAction(applicationState, toDoCommand.todo);
                    applicationState = toDoAction.run();
                    break;
                default:
                    InvalidAction invalidAction = new InvalidAction(applicationState);
                    applicationState = invalidAction.run();
            }
        }
        if (applicationState.isExited()) {
            String goodbyeMessage = "Bye. Hope to see you again soon!";
            System.out.println(goodbyeMessage);
        }
    }
}
