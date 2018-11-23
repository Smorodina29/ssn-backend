package ssn.web.contracts;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import ssn.facades.model.enums.RoleName;

import javax.validation.groups.Default;
import org.hibernate.validator.constraints.NotBlank;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {
    private Long id;

    @NotBlank(groups = {Default.class, UserRegistrationChecks.class})
    @Length(min = 3, max = 24, groups = {Default.class, UserRegistrationChecks.class})
    private String login;

    private RoleName role;

    @Length(min = 0, max = 500, groups = {Default.class, UserRegistrationChecks.class})
    private String name;

    public interface UserRegistrationChecks {}
}
