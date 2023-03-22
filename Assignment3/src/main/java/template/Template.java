package template;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Abstract template class
 */
public abstract class Template {

    /**
     *
     */
    protected static final String TEMPLATE_PARAM_REGEX = "\\[\\[(.*?)\\]\\]";
    private String templateFileName;
    private List<String> templateParameters = new ArrayList<>();

    /**
     *
     * @param templateName template file name
     * @throws IOException indicates the input/output exception that occurred
     */
    public Template(String templateName) throws IOException {
        this.templateFileName = templateName;
        //Read template file
        BufferedReader reader = new BufferedReader(new FileReader(templateName));
        String line;

      while(((line = reader.readLine()) != null)) {
          Pattern p = Pattern.compile(TEMPLATE_PARAM_REGEX);
          Matcher m = p.matcher(line);
          while(m.find()) {
              //TODO: we are not using the template parameters so do we need it or remove it??
              templateParameters.add(m.group(1));
          }
        }
       // System.out.println("template parameters: " + templateParameters);
    }

    /**
     *
     * @return template file's name
     */
    public String getTemplateFileName() {
        return templateFileName;
    }

    /**
     *
     * @param parameterValue csv file records in the form of map of string key value pair
     * @param fileName the filename format that is to be generated
     * @throws IOException indicates the input/output exception that occurred
     */
    public void generateFile(Map<String, String> parameterValue,
                             File fileName) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(getTemplateFileName()));

        // Create the new file.
        fileName.createNewFile();
        FileWriter filewriter = new FileWriter(fileName);
        BufferedWriter outputStream= new BufferedWriter(filewriter);
        String line;
        while ((line = reader.readLine()) != null) {
            Pattern p = Pattern.compile(TEMPLATE_PARAM_REGEX);
            Matcher m = p.matcher(line);
            while (m.find()) {
                if (parameterValue.containsKey(m.group(1))) {
                    line = line.replaceFirst(TEMPLATE_PARAM_REGEX, parameterValue.get(m.group(1)));
                }
            }
            outputStream.write(line);
            outputStream.write("\n");
        }
        outputStream.flush();
        outputStream.close();
        reader.close();
    }
}

