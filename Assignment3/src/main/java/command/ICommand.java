package command;

import exception.InvalidParameterException;

import java.io.IOException;

/**
 * Contract for Command interface
 */
public interface ICommand {

    /**
     *
     * @return the command name
     */
    String getCommandName();

    /**
     *
     * @return the help text to be displayed on the screen for user's guidance
     */
    String getHelp();

    /**
     *
     * @return description of the command details- like what the action the command performs
     */
    String getDescription();

    /**
     * @throws IOException indicates the input/output exception that occurred
     * @throws InvalidParameterException indicates that some parameters entered are not correct
     */
    void run() throws IOException, InvalidParameterException;
}
