package command;

/**
 * Email Arguments class has the constants that the email command accepts
 * Constants defined:
 *
 */
public class EmailArgumentConstants {

    /**
     * EMAIL_TEMPLATE_SHORT- short name of the option
     */
    public static final String EMAIL_TEMPLATE_SHORT = "emailtemplate";
    /**
     * EMAIL_TEMPLATE_LONG- long name of the option
     */
    public static final String EMAIL_TEMPLATE_LONG = "email-template";
    /**
     * DESCRIPTION- description of the command details- like what the action the command performs
     */
    public static final String DESCRIPTION = "Command to generate the email content from the email template and the customer's CSV file.";
    /**
     *  HELP- the help text to be displayed on the screen for user's guidance
     */
    public static final String HELP = "Usage:\n\t--email  only generate email messages\n\t" +
            "--email-template <file>  accept a filename that holds the email template.\n\t" +
                                      "\t\t\t\t\t\t Required if --email is used\n\t" +
            "--output-dir <path>      accept the name of a folder, all output is placed in this folder\n\t" +
            "--csv-file <path>        accept the name of the csv file to process \n";
}
