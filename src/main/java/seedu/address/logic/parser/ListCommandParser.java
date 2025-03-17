package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import seedu.address.logic.commands.ListCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new ListCommand object
 */
public class ListCommandParser implements Parser<ListCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the ListCommand
     * and returns a ListCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public ListCommand parse(String args) throws ParseException {
        String trimmedArgs = args.trim();

        // If no specific fields are mentioned, show everything
        boolean showName = true;
        boolean showPhone = true;
        boolean showEmail = true;
        boolean showAddress = true;
        boolean showTags = true;

        if (!trimmedArgs.isEmpty()) {
            showName = trimmedArgs.contains("-n");
            showPhone = trimmedArgs.contains("-p");
            showEmail = trimmedArgs.contains("-e");
            showAddress = trimmedArgs.contains("-a");
            showTags = trimmedArgs.contains("-t");

            // If none of the specific fields are mentioned, throw an error
            if (!showName && !showPhone && !showEmail && !showAddress && !showTags) {
                throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, ListCommand.MESSAGE_USAGE));
            }
        }

        return new ListCommand(showName, showPhone, showEmail, showAddress, showTags);
    }
}