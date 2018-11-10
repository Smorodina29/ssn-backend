package ssn.facades.exeptions;

import lombok.Getter;

@Getter
public class InvalidFieldValueException extends BaseException {
    private final String reasons;
    private final String fieldName;
    private Class requestClass;

    public InvalidFieldValueException(String fieldName, Class requestClass, String reasons) {
        super("'" + fieldName + "' field is invalid for " + requestClass.getSimpleName() + " cause " + reasons);
        this.fieldName = fieldName;
        this.reasons = reasons;
        this.requestClass = requestClass;
    }

    public InvalidFieldValueException(String fieldName, String reasons) {
        super("'" + fieldName + "' field is invalid cause " + reasons);
        this.fieldName = fieldName;
        this.reasons = reasons;
    }
}
