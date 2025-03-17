package seedu.address.model;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import static java.util.Objects.requireNonNull;

import seedu.address.commons.core.GuiSettings;

/**
 * Represents User's preferences.
 */
public class UserPrefs implements ReadOnlyUserPrefs {

    private GuiSettings guiSettings = new GuiSettings();
    private Path addressBookFilePath = Paths.get("data" , "addressbook.json");

    private boolean showName = true;
    private boolean showPhone = true;
    private boolean showEmail = true;
    private boolean showAddress = true;
    private boolean showTags = true;

    /**
     * Creates a {@code UserPrefs} with default values.
     */
    public UserPrefs() {}

    /**
     * Creates a {@code UserPrefs} with the prefs in {@code userPrefs}.
     */
    public UserPrefs(ReadOnlyUserPrefs userPrefs) {
        this();
        resetData(userPrefs);
    }

    /**
     * Resets the existing data of this {@code UserPrefs} with {@code newUserPrefs}.
     */
    public void resetData(ReadOnlyUserPrefs newUserPrefs) {
        requireNonNull(newUserPrefs);
        setGuiSettings(newUserPrefs.getGuiSettings());
        setAddressBookFilePath(newUserPrefs.getAddressBookFilePath());
        setShowName(newUserPrefs.getShowName());
        setShowPhone(newUserPrefs.getShowPhone());
        setShowEmail(newUserPrefs.getShowEmail());
        setShowAddress(newUserPrefs.getShowAddress());
        setShowTags(newUserPrefs.getShowTags());
    }

    public GuiSettings getGuiSettings() {
        return guiSettings;
    }

    public void setGuiSettings(GuiSettings guiSettings) {
        requireNonNull(guiSettings);
        this.guiSettings = guiSettings;
    }

    public Path getAddressBookFilePath() {
        return addressBookFilePath;
    }

    public void setAddressBookFilePath(Path addressBookFilePath) {
        requireNonNull(addressBookFilePath);
        this.addressBookFilePath = addressBookFilePath;
    }

    // New methods to configure the display of the different fields
    public boolean getShowName() {
        return showName;
    }
    public void setShowName(boolean showName) {
        this.showName = showName;
    }
    public boolean getShowPhone() {
        return showPhone;
    }
    public void setShowPhone(boolean showPhone) {
        this.showPhone = showPhone;
    }
    public boolean getShowEmail() {
        return showEmail;
    }
    public void setShowEmail(boolean showEmail) {
        this.showEmail = showEmail;
    }
    public boolean getShowAddress() {
        return showAddress;
    }
    public void setShowAddress(boolean showAddress) {
        this.showAddress = showAddress;
    }
    public boolean getShowTags() {
        return showTags;
    }
    public void setShowTags(boolean showTags) {
        this.showTags = showTags;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof UserPrefs)) {
            return false;
        }

        UserPrefs otherUserPrefs = (UserPrefs) other;
        return guiSettings.equals(otherUserPrefs.guiSettings)
                && addressBookFilePath.equals(otherUserPrefs.addressBookFilePath)
                && showName == otherUserPrefs.showName
                && showPhone == otherUserPrefs.showPhone
                && showEmail == otherUserPrefs.showEmail
                && showAddress == otherUserPrefs.showAddress
                && showTags == otherUserPrefs.showTags;
    }

    @Override
    public int hashCode() {
        return Objects.hash(guiSettings, addressBookFilePath);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Gui Settings : " + guiSettings);
        sb.append("\nLocal data file location : " + addressBookFilePath);
        sb.append("\nShow Name : " + showName);
        sb.append("\nShow Phone : " + showPhone);
        sb.append("\nShow Email : " + showEmail);
        sb.append("\nShow Address : " + showAddress);
        sb.append("\nShow Tags : " + showTags);
        return sb.toString();
    }

}
