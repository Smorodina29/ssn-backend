package ssn.dal.model;

import lombok.*;
import ssn.facades.model.enums.RoleName;
import ssn.facades.model.UserFacade;

import javax.persistence.*;
import java.io.Serializable;

@ToString(of = {"id", "name", "login"})
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "user")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class User implements Serializable, UserFacade {
    @Id
    @SequenceGenerator(name = "user_id", sequenceName = "user_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Setter
    private String login;

    @Setter
    private String name;

    private String password;

    @Setter
    private Boolean deleted;

    private RoleName role;

    public User(String login, String name, String password) {
        this.login = login;
        this.name = name;
        this.password = password;
    }
}
