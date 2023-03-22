package command;

import exception.InvalidParameterException;
import fileReader.CsvFileReader;
import fileReader.IFileReader;
import org.apache.commons.cli.*;
import template.EmailTemplate;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static command.EmailArgumentConstants.*;

/**
 * Email Command class has the following functionality:
 * 1.adds email options
 * 2.gets the csv data and pass it to template to generate the files
 *
 */
public class EmailCommand extends Command {
    //TODO: It should have three arguments

    private CommandLine commandLine;
    /**
     *  static field Command_name for the email command
     */
    public static final String COMMAND_NAME = "email";

    /**
     *
     * @param args arguments passed by the main method that is entered by user
     * @throws InvalidParameterException indicates that some parameters entered are not correct
     */
    public EmailCommand(String[] args) throws InvalidParameterException {

        Options options = addEmailOptions();
        try {
            CommandLineParser parser = new GnuParser();
            commandLine = parser.parse(options, args);
        } catch (UnrecognizedOptionException ex) {
            String errorMessage = "Error: --email provided but not all parameters was given. "
                    + ex.getMessage() + "\n" +
                    this.getHelp();
            throw new InvalidParameterException(errorMessage);

        } catch (MissingOptionException ex) {
            String errorMessage = "Error: --email provided but other required parameters are missing. "
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
     * @return emailOptions - email command with all the required options
     */
    private Options addEmailOptions() {
        Options emailOptions = new Options();
        emailOptions.addOption(COMMAND_NAME, false, getDescription());
        emailOptions.addRequiredOption(EMAIL_TEMPLATE_SHORT, EMAIL_TEMPLATE_LONG,true, getDescription());
        emailOptions.addRequiredOption(OUTPUT_DIRECTORY_SHORT, OUTPUT_DIRECTORY_LONG,true,getDescription());
        emailOptions.addRequiredOption(CSV_FILE_SHORT, CSV_FILE_LONG,true,getDescription());
        return emailOptions;
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
        String emailTemplate = commandLine.getOptionValue(EMAIL_TEMPLATE_LONG);
        String csvFile = commandLine.getOptionValue(CSV_FILE_LONG);

        // Get records from csv
        IFileReader csvFileReader = new CsvFileReader(csvFile);
        List<Map<String, String>> records = csvFileReader.readFile();
        EmailTemplate template = new EmailTemplate(emailTemplate);
        int fileCounter = 0;
        for(Map<String, String> record : records) {
            String fileName = COMMAND_NAME + "-" + ++fileCounter + ".txt";
            // Validate the output directory
            File directory = new File(outputDirectory);
            if(!directory.isDirectory()) {
                throw new InvalidParameterException("output-dir parameter is not a directory");
            }
            File emailFileName = new File(outputDirectory + File.separator + fileName);

            template.generateFile(record, emailFileName);
        }
    }

    @Override
    public String toString() {
        return "EmailCommand{" +
                "commandLine=" + commandLine +
                '}';
    }

}
