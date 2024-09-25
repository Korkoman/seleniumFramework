package ExceptionHandling;

import java.util.NoSuchElementException;

public class elementsExceptions extends Exception{

    public elementsExceptions(String exceptionMessage) {
        super(exceptionMessage);
    }
}
