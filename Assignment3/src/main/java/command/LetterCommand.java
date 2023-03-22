package command;

import exception.InvalidParameterException;
import fileReader.CsvFileReader;
import fileReader.IFileReader;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.MissingOptionException;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.UnrecognizedOptionException;
import template.LetterTemplate;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import static command.LetterArgumentConstants.*;

/**
 * Letter Command class has the following functionality:
 *  * 1.adds email options
 *  * 2.gets the csv data and pass it to template to generate the files
 */
public class LetterCommand extends Command {
    private CommandLine commandLine;
    /**
     * COMMAND_NAME- command name for --letter
     */
    public static final String COMMAND_NAME = "letter";

    /**
     *
     * @param args arguments passed by the main method that is entered by user
     * @throws InvalidParameterException indicates that some parameters entered are not correct
     */
    public LetterCommand(String[] args) throws InvalidParameterException {

        Options options = addLetterOptions();
        try {
            CommandLineParser parser = new GnuParser();
            commandLine = parser.parse(options, args);
        } catch (UnrecognizedOptionException ex) {
            String errorMessage = "Error: --letter provided but not all parameters was given. "
                    + ex.getMessage() + "\n" +
                    this.getHelp();
            throw new InvalidParameterException(errorMessage);
        } catch (MissingOptionException ex) {
            String errorMessage = "Error: --letter provided but other required parameters are missing. "
                    + ex.getMessage() + "\n" +
                    this.getHelp();
            throw new InvalidParameterException(errorMessage);

        } catch (ParseException e) {
            String errorMessage = "Exception occurred during parsing the command line parameters.\n"
                    + this.getHelp();
            throw new InvalidParameterException(errorMessage);
        }
    }

    /**
     *
     * @return options- letter command with all the required options
     */
    private Options addLetterOptions() {
        Options options = new Options();
        options.addOption(COMMAND_NAME, false, getDescription());
        options.addRequiredOption(LETTER_TEMPLATE_SHORT, LETTER_TEMPLATE_LONG,true, getDescription());
        options.addRequiredOption(OUTPUT_DIRECTORY_SHORT, OUTPUT_DIRECTORY_LONG,true,getDescription());
        options.addRequiredOption(CSV_FILE_SHORT, CSV_FILE_LONG,true,getDescription());

        return options;
    }

    /**
     *
     * @return the command name
     */
    @Override
    public String getCommandName() {
        return COMMAND_NAME;
    }

    /**
     *
     * @return the help text to be displayed on the screen for user's guidance
     */
    @Override
    public String getHelp() {
        return HELP;
    }

    /**
     *
     * @return description of the command details- like what the command is doing
     */
    @Override
    public String getDescription() {
        return DESCRIPTION;
    }

    /**
     *
     * @throws IOException indicates the input/output exception that occurred
     * @throws InvalidParameterException indicates that some parameters entered are not correct
     */
    @Override
    public void run() throws IOException, InvalidParameterException {
        String outputDirectory = commandLine.getOptionValue(OUTPUT_DIRECTORY_LONG);
        String letterTemplate = commandLine.getOptionValue(LETTER_TEMPLATE_LONG);
        String csvFile = commandLine.getOptionValue(CSV_FILE_LONG);

        // Get records from csv
        IFileReader csvFileReader = new CsvFileReader(csvFile);
        List<Map<String, String>> records = csvFileReader.readFile();
        LetterTemplate template = new LetterTemplate(letterTemplate);
        int fileCounter = 0;
        for(Map<String, String> record : records) {
            String fileName = "letter-" + ++fileCounter + ".txt";
            // Validate the output directory
            File directory = new File(outputDirectory);
            if(!directory.isDirectory()) {
                throw new InvalidParameterException("output-dir parameter is not a directory");
            }
            File letterFileName = new File(outputDirectory + File.separator + fileName);

            template.generateFile(record, letterFileName);
        }
    }

    @Override
    public String toString() {
        return "LetterCommand{" +
                "commandLine=" + commandLine +
                '}';
    }

}
