package command;

import exception.InvalidParameterException;
import java.io.IOException;
import org.apache.commons.cli.MissingArgumentException;
import org.apache.commons.cli.MissingOptionException;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.UnrecognizedOptionException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LetterCommandTest {
    private LetterCommand testCommand1;
    private String help;
    private String description;
    private String[] command = {"--letter", "--letter-template", "letter-template.txt",
            "--output-dir", "outputDir", "--csv-file", "test.csv"};
    private String[] commandIncorrect = {"--letter", "--email-template", "letter-template.txt",
            "--output-dir", "outputDir", "--csv-file", "test.csv"};
    private String[] commandIncorrect2 = {"--letter"};
    private String[] commandIncorrect3 = {"--test"};

    @BeforeEach
    void setup() throws InvalidParameterException {
        this.testCommand1 = new LetterCommand(command);
        help = LetterArgumentConstants.HELP;
        description = LetterArgumentConstants.DESCRIPTION;
    }

    @Test
    void getCommandNameTest() {
        Assertions.assertEquals(this.testCommand1.getCommandName(), "letter");
    }

    @Test
    void getHelpTest() {
        Assertions.assertEquals(this.testCommand1.getHelp(),this.help);
    }

    @Test
    void getDescriptionTest() {
        Assertions.assertEquals(this.testCommand1.getDescription(),this.description);
    }

    @Test
    void runTest() throws InvalidParameterException, IOException {
         this.testCommand1.run();
    }

    @Test
    void InvalidParameterExceptionTest() {
        Assertions.assertThrows(InvalidParameterException.class,
                ()-> new LetterCommand(commandIncorrect));
    }

    @Test
    void ExceptionTest() {
        Assertions.assertThrows(InvalidParameterException.class,
            ()-> new EmailCommand(commandIncorrect2));
        Assertions.assertThrows(InvalidParameterException.class,
            ()-> new EmailCommand(commandIncorrect3));
    }

  /*  @Test
    void equalsAndHashcodeTest() {
        Assertions.assertEquals(this.testCommand1,testCommand1);
        Assertions.assertFalse(this.testCommand1!= testCommand1);
        Assertions.assertNotNull(this.testCommand1);
        Assertions.assertEquals(this.testCommand1.hashCode(),testCommand1.hashCode());
        Assertions.assertTrue(this.testCommand1.equals(testCommand1));
    }*/

    @Test
    void toStringTest() {
        Assertions.assertTrue(this.testCommand1.toString().contains("LetterCommand{"));
    }
}