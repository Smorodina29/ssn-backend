package ssn.commons.api.response;

import lombok.Getter;

@Getter
public enum ValidationErrorCodes {
    UnknownConstraint(99),
    Future(100),
    Past(101),
    Max(102),
    Min(103),
    Range(104),
    Size(105),
    Length(106),
    NotEmpty(107),
    NotNull(108),
    NotBlank(109),
    Pattern(110),
    Email(111),
    Phone(112),
    ValidPersistenceKey(113);

    private final int code;

    ValidationErrorCodes(final int code) {
        this.code = code;
    }

    public static ValidationErrorCodes valueOrDefault(String value) {
        try {
            return ValidationErrorCodes.valueOf(value);
        }
        catch (IllegalArgumentException e) {
            return UnknownConstraint;
        }
    }
}
