package tiger.parser;

import tiger.exceptions.inputs.TigerEmptyStringException;
import tiger.exceptions.inputs.TigerInvalidArgumentException;
import tiger.exceptions.inputs.TigerInvalidInputException;
import tiger.exceptions.inputs.TigerTooManyInputsException;
import tiger.utils.RemoveSpaces;

public class MarkDoneParser extends Parser {

    public int index;

    /**
     * The {@code MarkDoneParser} parser class takes in an input String and
     * parses it, so that the {@code MarkDoneAction} class can access the
     * class fields and understand user input.
     *
     * @param  input String to be parsed.
     * @throws TigerInvalidInputException If input is invalid.
     */

    public MarkDoneParser(String input) throws TigerInvalidInputException {
        super(input);
        RemoveSpaces removeSpaces = new RemoveSpaces();
        String[] array = removeSpaces.removeBackAndFrontSpaces(input).split(
                " ");
        try {
            this.index = Integer.valueOf(array[1].replaceAll(" ", ""));
            assert (this.index > 0);
            if (array.length > 2) {
                throw new TigerTooManyInputsException("");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new TigerEmptyStringException("Done index");
        } catch (NumberFormatException e) {
            throw new TigerInvalidArgumentException(array[1], "Done");
        } catch (AssertionError e) {
            throw new TigerInvalidArgumentException(array[1], "Done");
        }
    }
}