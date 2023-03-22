package template;

import java.io.IOException;

/**
 * Letter template class
 */
public class LetterTemplate extends Template{

    /**
     *
     * @param templateName letter template file name
     * @throws IOException indicates the input/output exception that occurred
     */
    public LetterTemplate(String templateName) throws IOException {
        super(templateName);
    }
}
