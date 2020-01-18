package app.entities;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class User {

    private String name;
    private String password;

    @Override
    public String toString() {
        return "User{" + "name='" + name + '\'' + ", password='" + password + '\'' + '}';
    }
}
