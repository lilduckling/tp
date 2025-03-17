package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.model.Model;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_PERSONS;
import seedu.address.model.UserPrefs;

/**
 * Lists all persons in the address book to the user.
 */
public class ListCommand extends Command {

    public static final String COMMAND_WORD = "list";

    public static final String MESSAGE_SUCCESS = "Listed all persons";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Lists all persons in the address book as a list with "
            + "index numbers.\n"
            + "Parameters: "
            + "[-n] "
            + "[-p] "
            + "[-e] "
            + "[-a] "
            + "[-t]\n"
            + "Example: " + COMMAND_WORD + " -n -p -e -a -t";

    private final boolean showName;
    private final boolean showPhone;
    private final boolean showEmail;
    private final boolean showAddress;
    private final boolean showTags;

    public ListCommand(boolean showName, boolean showPhone, boolean showEmail, boolean showAddress, boolean showTags) {
        this.showName = showName;
        this.showPhone = showPhone;
        this.showEmail = showEmail;
        this.showAddress = showAddress;
        this.showTags = showTags;
    }


    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        UserPrefs userPrefs = model.getUserPrefs();
        userPrefs.setShowName(showName);
        userPrefs.setShowPhone(showPhone);
        userPrefs.setShowEmail(showEmail);
        userPrefs.setShowAddress(showAddress);
        userPrefs.setShowTags(showTags);
        model.updateFilteredPersonList(PREDICATE_SHOW_ALL_PERSONS);
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
