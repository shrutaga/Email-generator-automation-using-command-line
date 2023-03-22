package exception;

/**
 * Invalid Parameter Exception- indicates that some parameters entered are not correct
 */
public class InvalidParameterException extends Exception{
    /**
     *
     * @param msg error message to be displayed in case of an exception
     */
    public InvalidParameterException(String msg) {
        super(msg);
    }
}
