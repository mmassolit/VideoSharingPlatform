import javassist.NotFoundException;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.videosharing.api.dto.UserPayload;
import com.videosharing.model.User;
import com.videosharing.service.IUserService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/clients")
@AllArgsConstructor
public final class UserController {
    private final IUserService userService;

    @GetMapping(params = {"page", "size"})
    public ResponseEntity<List<User>> index(@RequestParam("page") int page,
                                              @RequestParam("size") int size)
            throws NotFoundException {
        Page<User> resultPage = userService.findPaginated(page, size);
        if (page >= resultPage.getTotalPages())
            throw new NotFoundException(String.format("Page %d of size %d does not exist", page, size));

        return ResponseEntity.ok(resultPage.getContent());
    }

    @PostMapping
    public ResponseEntity<User> create(@Valid @RequestBody UserPayload payload) {
        User newUser = new User(payload.getName(), payload.getSurname(), payload.getEmail());
        
        return ResponseEntity.ok(userService.save(newUser));
    }

    @GetMapping("{userId}")
    public ResponseEntity<User> show(@PathVariable String userId) throws NotFoundException {
        return ResponseEntity.ok(userService.getById(userId));
    }

    @DeleteMapping("{userId}")
    public ResponseEntity<Void> delete(@PathVariable String userId) throws NotFoundException {
        userService.deleteById(userId);
        return ResponseEntity.noContent().build();
    }
}