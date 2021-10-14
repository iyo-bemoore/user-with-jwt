package be.bemoore.userwithjwt.api;

import be.bemoore.userwithjwt.Utils.Mappings;
import be.bemoore.userwithjwt.models.Role;
import be.bemoore.userwithjwt.models.User;
import be.bemoore.userwithjwt.service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(Mappings.USERS_BASE_URL)
public class UserController {
  private final UserService userService;

  @GetMapping(Mappings.ALL_USERS)
  public ResponseEntity<List<User>>getUsers(){
     return ResponseEntity.ok().body(userService.getUsers());
  }
    @PostMapping(Mappings.CREATE_USER)
    public ResponseEntity<User>saveUser(@RequestBody User user){

        return ResponseEntity.created(getCurrentUri("/api/user/create")).body(userService.saveUser(user));
    }
    @PostMapping(Mappings.CREATE_ROLE)
    public ResponseEntity<Role>saveRole(@RequestBody Role role){
        return ResponseEntity.created(getCurrentUri("/api/role/create")).body(userService.saveRole(role));
    }

    @PostMapping(Mappings.ADD_ROLE_TO_USER)
    public ResponseEntity<?>addRoleToUser(@RequestBody RoleToUserForm form){
        userService.addRoleToUser(form.getUsername(),form.getRoleName());
        return ResponseEntity.ok().build();
    }
    @org.jetbrains.annotations.NotNull
    @org.jetbrains.annotations.Contract("_ -> new")
    private URI getCurrentUri(String path) {
        return URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path(path).toUriString());
  }
}
@Data
class RoleToUserForm {
    private String username;
    private String roleName;
}