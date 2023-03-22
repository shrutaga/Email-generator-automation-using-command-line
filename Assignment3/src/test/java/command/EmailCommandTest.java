package command;

import exception.InvalidParameterException;
import java.io.IOException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class EmailCommandTest {
    private EmailCommand testCommand1;
    private EmailCommand testCommand2;
    //TODO: check the command
    private String[] command = {"--email", "--email-template", "email-template.txt",
            "--output-dir", "outputDir", "--csv-file", "test.csv"};
    private String[] commandIncorrect1 = {"--email","--letter-template","email-template.txt",
            "--output-dir", "outputDir", "--csv-file", "test.csv"};
    private String[] commandIncorrect2 = {"--email"};
    private String[] commandIncorrect3 = {"--test"};


    String help;
    String description;

    @BeforeEach
    void setup() throws InvalidParameterException {

        testCommand1 = new EmailCommand(command);
        help = EmailArgumentConstants.HELP;
        description = EmailArgumentConstants.DESCRIPTION;
    }

    @Test
    void getCommandNameTest() {
        Assertions.assertEquals(this.testCommand1.getCommandName(),"email");
    }

    @Test
    void getHelpTest() {
        Assertions.assertFalse(this.help.isEmpty());
        Assertions.assertEquals(this.testCommand1.getHelp(),this.help);

    }

    @Test
    void getDescriptionTest() {
        Assertions.assertFalse(this.description.isEmpty());
        Assertions.assertEquals(this.testCommand1.getDescription(),this.description);
    }

    @Test
    void runTest() throws InvalidParameterException, IOException {
        this.testCommand1.run();
    }

    @Test
    void InvalidParameterExceptionTest() {
       Assertions.assertThrows(InvalidParameterException.class,
               ()-> new EmailCommand(commandIncorrect1));
    }

    @Test
    void ExceptionTest() {
        Assertions.assertThrows(InvalidParameterException.class,
            ()-> new EmailCommand(commandIncorrect2));
        Assertions.assertThrows(InvalidParameterException.class,
            ()-> new EmailCommand(commandIncorrect3));
    }

 /*   @Test
    void equalsAndHashcodeTest() throws InvalidParameterException {
        Assertions.assertEquals(this.testCommand1,testCommand1);
        Assertions.assertFalse(this.testCommand1!= testCommand1);
        Assertions.assertNotNull(this.testCommand1);
        Assertions.assertEquals(this.testCommand1.hashCode(),testCommand1.hashCode());
        Assertions.assertTrue(this.testCommand1.equals(testCommand1));
    }*/

    @Test
    void toStringTest() {
        Assertions.assertTrue(this.testCommand1.toString().contains("EmailCommand{"));
    }

}