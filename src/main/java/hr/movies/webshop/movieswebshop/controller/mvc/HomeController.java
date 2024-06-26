package hr.movies.webshop.movieswebshop.controller.mvc;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class HomeController {

    @GetMapping("/")
    public String redirectToMoviesWebShop() {
        return "redirect:/mvc/movieswebshop/getMovies.html";
    }
}
