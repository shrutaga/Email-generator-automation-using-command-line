package command;

/**
 * Letter Arguments class has all the constants that the letter command accepts
 *
 */
public class LetterArgumentConstants {

    /**
     * Letter Arguments class has the constants that the letter command accepts
     * Constants defined:
     * LETTER_TEMPLATE_SHORT- short name of the option
     */
    public static final String LETTER_TEMPLATE_SHORT = "lettertemplate";
    /**
     * LETTER_TEMPLATE_LONG- long name of the option
     */
    public static final String LETTER_TEMPLATE_LONG = "letter-template";
    /**
     * DESCRIPTION- description of the command details- like what the action the command performs
     */
    public static final String DESCRIPTION = "Command to generate the letter content from the letter template and the customer's CSV file.";
    /**
     * HELP- the help text to be displayed on the screen for user's guidance
     */
    public static final String HELP = "Usage:\n\t--letter  only generate letter messages\n\t" +
            "--letter-template <file> accept a filename that holds the letter template.\n\t" +
            "\t\t\t\t\t\t Required if --letter is used\n\t" +
            "--output-dir <path>      accept the name of a folder, all output is placed in this folder\n\t" +
            "--csv-file <path>        accept the name of the csv file to process \n";
}
