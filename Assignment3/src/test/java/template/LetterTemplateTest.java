package template;

import exception.InvalidParameterException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

class LetterTemplateTest {
    private Template testTemplate;
    Map<String, String> record = new HashMap<>();
    String fileName = "outputDir/file1.txt";
    File file1 = new File(fileName);

    @BeforeEach
    void setup() throws IOException {
        this.testTemplate = new LetterTemplate("letter-template.txt");
        record.put("company_name","Company1");
        record.put("last_name","test");
        record.put("first_name","Abc");
        record.put("email","test1@gmail.com");
        record.put("address","123,2nd ave");
        record.put("city","Seattle");
        record.put("county","Kings");
        record.put("state","Washington");
        record.put("zip","98153");

    }

    @Test
    void getTemplateFileNameTest() {
        Assertions.assertEquals(this.testTemplate.getTemplateFileName(),"letter-template.txt");
    }

    @Test
    void generateFileTest() throws IOException {
        this.testTemplate.generateFile(record,file1);
        boolean checkFile = file1.exists();
        Assertions.assertTrue(checkFile);
    }

}