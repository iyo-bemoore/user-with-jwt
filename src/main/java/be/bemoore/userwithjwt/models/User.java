package be.bemoore.userwithjwt.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class User {
    @Id
    @GeneratedValue()
    private Long id;
    private String name;
    private String username;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER) // Load all the roles when getting the user
    private Collection<Role> roles = new ArrayList<>();

}
