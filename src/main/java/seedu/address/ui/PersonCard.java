package seedu.address.ui;

import java.util.Comparator;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.model.UserPrefs;
import seedu.address.model.person.Person;

/**
 * An UI component that displays information of a {@code Person}.
 */
public class PersonCard extends UiPart<Region> {

    private static final String FXML = "PersonListCard.fxml";

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The issue on AddressBook level 4</a>
     */

    public final Person person;

    @FXML
    private HBox cardPane;
    @FXML
    private Label name;
    @FXML
    private Label id;
    @FXML
    private Label phone;
    @FXML
    private Label address;
    @FXML
    private Label email;
    @FXML
    private FlowPane tags;

    /**
     * Creates a {@code PersonCode} with the given {@code Person} and index to display.
     */
    public PersonCard(Person person, UserPrefs userPrefs) {
        super(FXML);
        this.person = person;
        if (userPrefs.getShowName()) {
            name.setText(person.getName().fullName);
        } else {
            name.setVisible(false);
        }

        if (userPrefs.getShowPhone()) {
            phone.setText(person.getPhone().value);
        } else {
            phone.setVisible(false);
        }

        if (userPrefs.getShowEmail()) {
            email.setText(person.getEmail().value);
        } else {
            email.setVisible(false);
        }

        if (userPrefs.getShowAddress()) {
            address.setText(person.getAddress().value);
        } else {
            address.setVisible(false);
        }

        if (userPrefs.getShowTags()) {
            tags.getChildren().clear();
            person.getTags().stream()
                    .sorted(Comparator.comparing(tag -> tag.tagName))
                    .forEach(tag -> tags.getChildren().add(new Label(tag.tagName)));
        } else {
            tags.setVisible(false);
        }
    }
}
