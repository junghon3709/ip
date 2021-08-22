package tiger.parser;

public class ByeParser extends Parser {

    /**
     * Practically, {@ByeParser} does nothing as there is nothing to parse
     * for the {@Bye} command. This is a filler class in case some additional
     * arguments is added to the {@Bye} command in the future.
     *
     * @param input String to be parsed.
     */

    public ByeParser(String input) {
        // does nothing, nothing to parse
        super(input);
    }
}
