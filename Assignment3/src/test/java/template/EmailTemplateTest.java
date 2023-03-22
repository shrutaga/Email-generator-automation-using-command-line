package template;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

class EmailTemplateTest {
    private Template testTemplate;
    Map<String, String> record = new HashMap<>();
    String fileName = "outputDir/file1.txt";
    File file1 = new File(fileName);

    @BeforeEach
    void setup() throws IOException {
        this.testTemplate = new EmailTemplate("email-template.txt");
        record.put("company_name","Company1");
        record.put("last_name","test");
        record.put("first_name","Abc");
        record.put("email","test1@gmail.com");

    }

   @Test
    void getTemplateFileNameTest() {
        Assertions.assertEquals(this.testTemplate.getTemplateFileName(),"email-template.txt");
    }

    @Test
    void generateFileTest() throws IOException {
        this.testTemplate.generateFile(record,file1);
        boolean checkFile = file1.exists();
        Assertions.assertTrue(checkFile);
    }
}