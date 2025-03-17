package seedu.address.model;

import java.nio.file.Path;

import seedu.address.commons.core.GuiSettings;

/**
 * Unmodifiable view of user prefs.
 */
public interface ReadOnlyUserPrefs {

    GuiSettings getGuiSettings();

    Path getAddressBookFilePath();

    // New method to configure the display of the different fields
    boolean getShowName();
    boolean getShowPhone();
    boolean getShowEmail();
    boolean getShowAddress();
    boolean getShowTags(); 

}
