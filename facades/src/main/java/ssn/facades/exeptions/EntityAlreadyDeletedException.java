package ssn.facades.exeptions;

public class EntityAlreadyDeletedException extends BaseException {


    public EntityAlreadyDeletedException(Class clazz, long id) {
       super(clazz.getSimpleName()+" with id "+id+" was already deleted");
    }

    public EntityAlreadyDeletedException(Class clazz, String composite) {
        super(clazz.getSimpleName()+" with composite id "+composite+" was already deleted");
    }

    public EntityAlreadyDeletedException(String message, Throwable cause) {
        super(message, cause);
    }

    public EntityAlreadyDeletedException(String message) {
        super(message);
    }
}
