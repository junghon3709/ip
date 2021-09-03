import tiger.app.Ui;


public class Tiger {

    // TODO: implement flags for delete done combination, invalid todo combination
    // features: fallthrough commands
    // priority

    private Ui ui;

    public Tiger() {
        this.ui = new Ui();
    }

    public String start() {
        ui.start();
        return ui.getResponse();
    }

    public String getResponse(String input) {
        System.out.println(input);
        ui.iterateOnce(input);
        return ui.getResponse();
    }

    public boolean isExited() {
        return ui.isExited();
    }

}
