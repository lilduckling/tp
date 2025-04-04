---
layout: page
title: User Guide
---

conTAct **is a desktop app designed to help Teaching Assistants efficiently manage student lists and information.** It’s optimized for fast use via the **Command Line Interface (CLI)**, while still offering the ease of a Graphical User Interface (GUI). If you're comfortable typing commands, conTAct makes tracking students, managing tutorials, and updating records quicker than traditional GUI-based apps.

* Table of Contents
{:toc}

--------------------------------------------------------------------------------------------------------------------

## Quick start

1. Ensure you have Java `17` or above installed in your Computer. You are advised to run the app using Java `17`.<br>
   *Refer to
   [this](https://se-education.org/guides/tutorials/javaInstallation.html) Java installation guide for more help on installing
   and switching between Java versions.*<br>
   **Mac users:** Ensure you have the precise JDK version prescribed [here](https://se-education.org/guides/tutorials/javaInstallationMac.html).

2. Visit conTAct's Github Releases [here](https://github.com/AY2425S2-CS2103T-F14-1/tp/releases).

3. Find the latest releases. Under "Assets", find the `.jar` file (e.g addressbookv1.4.jar). Click the `.jar` file to download it.

4. Choose or create a folder where you want to store and run conTAct. Copy the `.jar` file to this folder.

5. Open a command terminal. <br>
   **Windows Users:** Press `Windows + R`, type `cmd`, and hit Enter.<br>
   **Mac Users:** Open *Terminal* from the Launchpad or Spotlight (`Cmd + Space, then type "Terminal").<br>
   **Linux Users:** Open your Terminal from the Applications menu.

6. Type `java -jar <name_of_file>.jar` in the terminal, and then Enter to run the application.<br>
   A GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>
   ![Ui](images/Ui.png)

7. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:

   * `list` : Lists all contacts.

   * `add n/John Doe p/98765432 e/johnd@example.com a/John street, block 123, #01-01` : Adds a contact named `John Doe` to conTActs.

   * `delete n/John Doe` : Deletes John Doe from the conTAct list.

   * `clear` : Deletes all contacts.

   * `exit` : Exits the app.

1. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## Features

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `add n/NAME`, `NAME` is a parameter which can be used as `add n/John Doe`.

* Items in square brackets are optional.<br>
  e.g `n/NAME [t/TAG]` can be used as `n/John Doe t/friend` or as `n/John Doe`.

* Items with `…`​ after them can be used multiple times including zero times.<br>
  e.g. `[t/TAG]…​` can be used as ` ` (i.e. 0 times), `t/friend`, `t/friend t/family` etc.

* Parameters can be in any order.<br>
  e.g. if the command specifies `n/NAME p/PHONE_NUMBER`, `p/PHONE_NUMBER n/NAME` is also acceptable.

* Extraneous parameters for commands that do not take in parameters (such as `help`, `exit` and `clear`) will be ignored.<br>
  e.g. if the command specifies `help 123`, it will be interpreted as `help`.

* If you are using a PDF version of this document, be careful when copying and pasting commands that span multiple lines as space characters surrounding line-breaks may be omitted when copied over to the application.
</div>

### Viewing help : `help`

Shows a message explaning how to access the help page.

![help message](images/helpMessage.png)

Format: `help`


### Adding a person: `add`

Adds a person to the address book.

Format: `add n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS [t/TAG]…​`

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
A person can have any number of tags (including 0)
</div>

Examples:
* `add n/John Doe p/98765432 e/johnd@example.com a/John street, block 123, #01-01`
* `add n/Betsy Crowe t/friend e/betsycrowe@example.com a/Newgate Prison p/1234567 t/criminal`

### Listing all persons : `list`

Shows a list of all persons in the address book. You can customize the fields displayed in the person cards using prefixes.

Format: `list [PREFIX]...`

* If no prefixes are provided, all fields will be displayed by default.
* Supported prefixes:
  * `n/` - Show name
  * `p/` - Show phone number
  * `e/` - Show email
  * `a/` - Show address
  * `s/` - Show student ID
  * `t/` - Show tags
  * `tut/` - Show tutorials
* You can combine multiple prefixes to display specific fields.

Examples:
* `list` - Displays all persons with all fields.
* `list n/ p/` - Displays all persons with only their name and phone number.
* `list n/ e/ t/` - Displays all persons with their name, email, and tags.

![Sample output for 'list n/ e/ t/'](images/listnet.png)

### Editing a person : `edit`

Edits an existing person in the address book.

Format: `edit INDEX [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [t/TAG]…​`

* Edits the person at the specified `INDEX`. The index refers to the index number shown in the displayed person list. The index **must be a positive integer** 1, 2, 3, …​
* At least one of the optional fields must be provided.
* Existing values will be updated to the input values.
* When editing tags, the existing tags of the person will be removed i.e adding of tags is not cumulative.
* You can remove all the person’s tags by typing `t/` without
    specifying any tags after it.

Examples:
*  `edit 1 p/91234567 e/johndoe@example.com` Edits the phone number and email address of the 1st person to be `91234567` and `johndoe@example.com` respectively.
*  `edit 2 n/Betsy Crower t/` Edits the name of the 2nd person to be `Betsy Crower` and clears all existing tags.

### Locating persons by attributes: `find`

Finds persons whose attributes match any of the given keywords.

Format: `find PREFIX KEYWORD [MORE_KEYWORDS]`

* The search is case-insensitive. e.g., `hans` will match `Hans`.
* The order of the keywords does not matter. e.g., `Hans Bo` will match `Bo Hans`.
* Only full words will be matched. e.g., `Han` will not match `Hans`.
* Persons matching at least one keyword will be returned (i.e., `OR` search).
* Supported prefixes:
  * `n/` - Search by name
  * `p/` - Search by phone number
  * `e/` - Search by email
  * `a/` - Search by address
  * `t/` - Search by tags
  * `s/` - Search by student ID
  * `tut/` - Search by tutorials

Examples:
* `find n/John` returns `John Doe` and `Johnny Bravo`.
* `find n/alex david` returns `Alex Yeoh` and `David Li`.
* `find t/friend` returns all persons tagged as `friend`.
* `find tut/CS2103T` returns all persons with tutorial `CS2103T`.

![Sample output for 'find tut/CS2103T'](images\FindTut2103T.png)

### Deleting a person/ a group of people : `delete`

Deletes students from the address book based on the specified field and value.

Format: `delete PREFIX KEYWORD`

* Deletes all students whose specified field matches the given keyword.
* Supported prefixes:
  * `n/` - Delete by name
  * `p/` - Delete by phone number
  * `e/` - Delete by email
  * `a/` - Delete by address
  * `t/` - Delete by tags
  * `s/` - Delete by student ID
  * `tut/` - Delete by tutorials
* The search is case-insensitive. e.g., `alice` will match `Alice`.
* Only full words will be matched. e.g., `Ali` will not match `Alice`.

Examples:
* `delete n/John` - Deletes all students with the name `John`.
* `delete t/friends` - Deletes all students tagged as `friends`.
* `delete s/A1234567X` - Deletes the student with the student ID `A1234567X`.
* `delete tut/CS2103T` - Deletes all students in the tutorial `CS2103T`.

### Clearing all entries : `clear`

Clears all entries from the address book.

Format: `clear`

### Exiting the program : `exit`

Exits the program.

Format: `exit`

### Saving the data

AddressBook data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

### Editing the data file

AddressBook data are saved automatically as a JSON file `[JAR file location]/data/addressbook.json`. Advanced users are welcome to update data directly by editing that data file.

<div markdown="span" class="alert alert-warning">:exclamation: **Caution:**
If your changes to the data file makes its format invalid, AddressBook will discard all data and start with an empty data file at the next run. Hence, it is recommended to take a backup of the file before editing it.<br>
Furthermore, certain edits can cause the AddressBook to behave in unexpected ways (e.g., if a value entered is outside of the acceptable range). Therefore, edit the data file only if you are confident that you can update it correctly.
</div>

### Archiving data files `[coming in v2.0]`

_Details coming soon ..._

--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous AddressBook home folder.

Alternatively, save a copy of your data as a `.json` file using the `save <file_name>` command. Then, send the `.json` file directly to the other Computer and load it in the 
conTAct app using the `load <file_name>` command.

--------------------------------------------------------------------------------------------------------------------

## Known issues

1. **When using multiple screens**, if you move the application to a secondary screen, and later switch to using only the primary screen, the GUI will open off-screen. The remedy is to delete the `preferences.json` file created by the application before running the application again.
2. **If you minimize the Help Window** and then run the `help` command (or use the `Help` menu, or the keyboard shortcut `F1`) again, the original Help Window will remain minimized, and no new Help Window will appear. The remedy is to manually restore the minimized Help Window.

--------------------------------------------------------------------------------------------------------------------

## Command summary

Action | Format, Examples
--------|------------------
**Add** | `add n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS [t/TAG]…​` <br> e.g., `add n/James Ho p/22224444 e/jamesho@example.com a/123, Clementi Rd, 1234665 t/friend t/colleague`
**Clear** | `clear`
**Delete** | `delete PREFIX KEYWORD`<br> e.g., `delete n/John`, `delete t/friends`, `delete s/A1234567X`
**Edit** | `edit INDEX [n/NAME] [p/PHONE_NUMBER] [e/EMAIL] [a/ADDRESS] [t/TAG]…​`<br> e.g.,`edit 2 n/James Lee e/jameslee@example.com`
**Find** | `find PREFIX KEYWORD [MORE_KEYWORDS]`<br> e.g., `find n/John`, `find t/friend`, `find tut/CS2103T`
**List** | `list [PREFIX]...`<br> e.g., `list`, `list n/ p/`, `list n/ e/ t/`
**Help** | `help`
