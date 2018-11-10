package ssn.facades.exeptions;

import org.jetbrains.annotations.Nullable;

public class EntityNotFoundException extends BaseException {
    public EntityNotFoundException(Class clazz, long id, @Nullable Exception cause) {
        super("There is no " + clazz.getSimpleName() + " with id " + id + ".", cause);
    }

    public EntityNotFoundException(Class clazz, long id) {
        this(clazz, id, null);
    }

    public EntityNotFoundException(Class clazz, String composite) {
        super("There is no " + clazz.getSimpleName() + " with composite id: " + composite + ".");
    }

    public EntityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public EntityNotFoundException(String message) {
        super(message);
    }
}
