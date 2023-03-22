package fileReader;

import exception.InvalidParameterException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class CsvFileReaderTest {
    private CsvFileReader testFileReader;
    String fileName = "test.csv";
    Map<String, String> record = new HashMap<>();
    List<Map<String, String>> testList = new ArrayList<>();

    @BeforeEach
    void setup() throws InvalidParameterException, IOException {
        testFileReader = new CsvFileReader(fileName);
        testFileReader.readFile();
        record.put("company_name","Company1");
        record.put("last_name","test");
        record.put("first_name","Abc");
        record.put("email","test1@gmail.com");
        record.put("address","324 bellevue");
        record.put("city","Seattle");
        record.put("county","Kings");
        record.put("state","Washington");
        record.put("zip","98555");
        testList.add(0,record);
    }

    @Test
    void readFile() throws InvalidParameterException, IOException {
        Assertions.assertEquals(testFileReader.readFile(), testList);
    }


}