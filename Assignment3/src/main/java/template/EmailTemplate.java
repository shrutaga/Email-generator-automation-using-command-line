package template;
import java.io.IOException;

/**
 * Email template class
 */
public class EmailTemplate extends Template {

    /**
     *
     * @param templateName email template file name
     * @throws IOException indicates the input/output exception that occurred
     */
    public EmailTemplate(String templateName) throws IOException {
        super(templateName);
    }

}

