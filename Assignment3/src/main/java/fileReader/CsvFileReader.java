package fileReader;

import exception.InvalidParameterException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *  CsvFileReader class reads the csv file provided and returns the data in form of records which is a list of map
 */
public class CsvFileReader implements IFileReader{

    private static final String CSV_SEPARATOR_REGEX = "\"([^\"]*)\"";
    private String fileName;

    /**
     *
     * @param fileName the csv filename to be read
     */
    public CsvFileReader(String fileName) {
        this.fileName = fileName;
    }

    /**
     *
     * @return list of records from the csv file
     * @throws IOException indicates the input/output exception that occurred
     * @throws InvalidParameterException indicates that some parameters entered are not correct
     */
    public List<Map<String, String>> readFile() throws IOException, InvalidParameterException {
        List<Map<String, String>> records = new ArrayList<>();
        List<String> headers = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(this.fileName));
        String line;
        if((line = reader.readLine()) != null) {
            Pattern p = Pattern.compile(CSV_SEPARATOR_REGEX);
            Matcher m = p.matcher(line);
            while(m.find()) {
                headers.add(m.group(1));
            }
        }

        while ((line = reader.readLine()) != null && !line.trim().isEmpty()) {
            List<String> entry = new ArrayList<>();
            Pattern p = Pattern.compile(CSV_SEPARATOR_REGEX);
            Matcher m = p.matcher(line);
            while(m.find()) {
                entry.add(m.group(1));
            }

            if(entry.size() != headers.size()) {
                String errorMsg = "CSV file is of wrong format, or issue with regex parsing";
                throw new InvalidParameterException(errorMsg);
            }
            Map<String, String> record = new HashMap<>();
            for(int i=0; i<headers.size(); i++) {
                record.put(headers.get(i), entry.get(i));
            }
            records.add(record);
        }
        return records;
    }


}

