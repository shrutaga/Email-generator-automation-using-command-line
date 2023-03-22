
import command.EmailArgumentConstants;
import command.EmailCommand;
import command.ICommand;
import command.LetterArgumentConstants;
import command.LetterCommand;
import exception.InvalidParameterException;
import org.apache.commons.cli.*;
import java.io.IOException;
import java.util.Arrays;

/**
 * Command line interface tester class with the main method
 */
public class CliTester {
    /**
     * This is the class with main method
     * @param args arguments passed from the command line
     * @throws IOException indicates the input/output exception that occurred
     */
    public static void main(String[] args) throws IOException {
        ICommand command;

        try {
            if (isCommand(args, "--email")) {
                command = new EmailCommand(args);
                command.run();
            } else if (isCommand(args, "--letter")) {
                command = new LetterCommand(args);
                command.run();
            } else {
                String errorMsg = "Invalid command provided.\nValid commands are --email and --letter \n"
                        + EmailArgumentConstants.HELP
                        + LetterArgumentConstants.HELP;
                throw new InvalidParameterException(errorMsg);
            }
        } catch (InvalidParameterException exception) {
            System.out.println(exception.getMessage());
            System.exit(0);
        }
    }

    /**
     *
     * @param args arguments passed from the command line
     * @param commandName command name as --email or --letter
     * @return boolean value by checking the command name
     */
    public static boolean isCommand(String[] args, String commandName) {
        return Arrays.stream(args).filter(s -> s.equals(commandName)).count() == 1;
    }


}
