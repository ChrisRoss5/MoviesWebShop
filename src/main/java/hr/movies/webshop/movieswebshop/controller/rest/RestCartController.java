package hr.movies.webshop.movieswebshop.controller.rest;

import hr.movies.webshop.movieswebshop.dto.CartDTO;
import hr.movies.webshop.movieswebshop.dto.MovieRequestDTO;
import hr.movies.webshop.movieswebshop.model.User;
import hr.movies.webshop.movieswebshop.repository.UserRepository;
import hr.movies.webshop.movieswebshop.service.PurchaseService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/movieswebshop")
@AllArgsConstructor
public class RestCartController {

    private PurchaseService purchaseService;
    private UserRepository userRepository;

    @PostMapping("/purchase")
    public ResponseEntity<MovieRequestDTO> purchaseMovie(@RequestBody CartDTO cartDTO, Authentication authentication) {
        User user = userRepository.findByUsername(authentication.getName());
        boolean success = purchaseService.purchase(cartDTO, user);
        if (success)
            return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }
}
