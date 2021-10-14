package be.bemoore.userwithjwt.api;

import be.bemoore.userwithjwt.Utils.Mappings;
import be.bemoore.userwithjwt.models.User;
import be.bemoore.userwithjwt.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
