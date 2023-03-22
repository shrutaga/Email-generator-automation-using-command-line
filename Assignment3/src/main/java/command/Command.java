package command;

/**
 * Command class implements interface ICommand
 * This class has the parameters for the commands as static String
 */
public abstract class Command implements ICommand{

    /**
     * Constants defined:
     */
    /**
     * CSV_FILE_SHORT- short name of the option
     */
    public static final String CSV_FILE_SHORT = "csvfile";
    /**
     * CSV_FILE_LONG- long name of the option
     */
    public static final String CSV_FILE_LONG = "csv-file";
    /**
     * OUTPUT_DIRECTORY_SHORT - short name of the option
     */
    public static final String OUTPUT_DIRECTORY_SHORT = "outputdir";
    /**
     * OUTPUT_DIRECTORY_LONG- long name of the option
     */
    public static final String OUTPUT_DIRECTORY_LONG = "output-dir";

}
