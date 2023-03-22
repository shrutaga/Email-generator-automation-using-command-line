package fileReader;

import exception.InvalidParameterException;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 *  Contract for File reader interface
 */
public interface IFileReader {

    /**
     * @return list of records from the csv file
     * @throws IOException indicates the input/output exception that occurred
     * @throws InvalidParameterException indicates that some parameters entered are not correct
     */
    List<Map<String, String>> readFile() throws IOException, InvalidParameterException;
}
