import tiger.app.Ui;


public class Tiger {

    public String getResponse(String input) {
        return "fish";
    }
    /**
     * Main entry point into the app.
     *
     * @param args Standard java main argument.
     */

    public static void main(String[] args) {

//         TODO: implement flags for delete done combination, invalid todo combination
//
//         features: fallthrough commands
//         priority
//         delete done, invalid todo combination

        Ui ui = new Ui();
        ui.start();
        ui.runUntilStopped();
        ui.exit();
    }

}
