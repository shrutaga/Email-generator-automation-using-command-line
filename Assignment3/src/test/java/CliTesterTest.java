import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//Test class for main method

class CliTesterTest {
    private String[] args1 = {"--email", "--email-template", "/Users/admin/Desktop/test_template.txt",
            "--output-dir", "/Users/admin/Desktop/test_dir", "--csv-file",
            "/Users/admin/Desktop/test.csv"};

    private String[] args2 = {"--letter", "--letter-template", "/Users/admin/Desktop/test_template.txt",
            "--output-dir", "/Users/admin/Desktop/test_dir", "--csv-file",
            "/Users/admin/Desktop/test.csv"};

    private String[] args3 = {"--test", "--letter-template", "/Users/admin/Desktop/test_template.txt",
            "--output-dir", "/Users/admin/Desktop/test_dir", "--csv-file",
            "/Users/admin/Desktop/test.csv"};

    @BeforeEach
    void setup() {

    }

    @Test
    void isCommand() {
        Assertions.assertTrue(CliTester.isCommand(args1,"--email"));
        Assertions.assertTrue(CliTester.isCommand(args2,"--letter"));
        Assertions.assertFalse(CliTester.isCommand(args3,"test"));
    }

    @Test
    void testsForMain() {

    }
}