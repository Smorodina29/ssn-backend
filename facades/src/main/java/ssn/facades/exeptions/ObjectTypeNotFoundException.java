package ssn.facades.exeptions;

/**
 * @author Aleksandr Petukhov
 */
public class ObjectTypeNotFoundException extends RuntimeException {

    public ObjectTypeNotFoundException(String objectType) {
        this(objectType, null);
    }

    public ObjectTypeNotFoundException(String objectType, Throwable cause) {
        super("ObjectType " + objectType + " has not found", cause);
    }
}
