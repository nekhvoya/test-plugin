# Test Plugin

This is a plugin implementing test actions for IntelliJ IDEA. 

## How to run
To verify the plugin run the following Gradle command `gradle runIde`.
An IntelliJ IDEA instance will be started with the installed Test Plugin. 
Create a sample Gradle project using the project creation wizard.
The actions implemented by the plugin can be found in the Tools menu.

## Check list 
Below is a short check list that can be used to verify the plugin features:

**TestAction1 (displays the Kotlin plugin version in a message dialog)**
1. Select Tools > 'Test Action 1' : A message dialog is opened, the UI elements look correctly, the dialog can be closed by clicking the Close/OK button
2. Verify the Kotlin version in the message dialog : The version is displayed and corresponds to the installed Kotlin plugin version
3. Disable the Kotlin plugin, open Test Action 1 : The dialog is opened with correct title and action buttons, a message saying that the Kotlin plugins wasn't found is displayed
4. Enable the Kotlin plugin, open Test Action 1 : The dialog is opened displaying the correct version

**TestAction2 (displays the Gutter icons of an opened file)**
1. Select Tools > 'Test Action 2' : An icons dialog is opened, the UI elements look correctly, the dialog can be closed by clicking the Close/OK button
2. Open files with a various numbers of gutter icons (e.g., 1, 15, 30, 31, 50-100) and open the dialog : The gutter icons are displayed in the dialog in rows, a scroll bar appears when needed
3. Open a file with no gutter icons and open the dialog : The dialog is opened, a message saying that the file has no gutter icons available is displayed
4. Open a few files with gutter icons in tabs and split view and open the dialog : The dialog is opened, the icons of the active file only are displayed
5. Open various types of files (java, kotlin, files from external libraries) and open the dialog : The dialog is opened, the icons of the opened file are displayed
6. Close all opened files and open the dialog : A message dialog is opened saying that there is no file opened

**TestAction3 (displays the currently selected component)**
1. Select Tools > 'Test Action 3' : A message dialog is opened, the UI elements look correctly, the dialog can be closed by clicking the Close/OK button
2. Verify the selected component info in the message dialog : The info about the selected component is displayed 
3. Select various components (Editor/Terminal/Project View/Services/External Project Tree/Nav Bar, etc.) and open the dialog for each of them: The info about the selected component is displayed and corresponds to the selected component
4. Close(Minimize) all the panels and open the dialog: The info about the selected IDE root pane is displayed

**Common**
1. Verify plugin info in the Settings : The name, description, company and version are correct
2. Disable the Test Plugin > The test actions aren't available in the Tools menu
3. Uninstall the Test Plugin > The test actions aren't available in the Tools menu
4. Check the logs : There are no errors in the logs related to the plugin features