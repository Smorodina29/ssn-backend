package ssn.facades.exeptions;

public class EntityNotFoundByOtherEntityException extends BaseException {


    private final Class notFound;
    private final Class variable;
    private final long variableId;

    public EntityNotFoundByOtherEntityException(Class notFound, Class variable, long variableId) {
        super("Can't find" + notFound.getSimpleName() + " by " + variable.getSimpleName() + " with id " + variableId + ".");
        this.notFound = notFound;
        this.variable = variable;
        this.variableId = variableId;
    }
}
