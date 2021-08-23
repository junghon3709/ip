package tiger.parser;

import tiger.exceptions.inputs.TigerEmptyStringException;
import tiger.exceptions.inputs.TigerInvalidInputException;
import tiger.utils.CustomDate;
import tiger.utils.DateStringConverter;
import tiger.utils.RemoveSpaces;

import java.util.Arrays;
import java.util.List;

public class DeadLineParser extends Parser {

    private String todo = "";
    private CustomDate date;
    private String dateString = "";

    public DeadLineParser(String input) {
        super(input);
    }

    public void parse() throws TigerInvalidInputException {
        RemoveSpaces removeSpaces = new RemoveSpaces();
        List<String> array =
                Arrays.asList(removeSpaces.removeBackAndFrontSpaces(this.input).split(" "));
        boolean byFound = false;
        for (int i = 1; i < array.size(); i++) {
            if (array.get(i).equals("/by")) {
                byFound = true;
                continue;
            }
            if (!byFound) {
                this.todo += (array.get(i) + " ");
            } else {
                this.dateString += (array.get(i) + " ");
            }
        }
        try {
            this.todo = removeSpaces.removeBackAndFrontSpaces(this.todo);
        } catch (StringIndexOutOfBoundsException e) {
            throw new TigerEmptyStringException("Deadline description");
        }
        try {
            this.dateString = removeSpaces.removeBackAndFrontSpaces(this.dateString);
        } catch (StringIndexOutOfBoundsException e) {
            throw new TigerEmptyStringException("Deadline date");
        }
        this.date = new DateStringConverter().getDateFromString(this.dateString);
    }

    public String getTodo() {
        return this.todo;
    }

    public CustomDate getDate() {
        return this.date;
    }
}
