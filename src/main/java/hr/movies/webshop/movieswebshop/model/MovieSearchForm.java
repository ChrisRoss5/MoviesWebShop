package hr.movies.webshop.movieswebshop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieSearchForm {
    private String title;
    private String description;
    private Integer genreId;
    private Integer ageRatingId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate releaseDateFrom;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate releaseDateTo;
    private BigDecimal priceFrom;
    private BigDecimal priceTo;
    private Integer durationMinutesFrom;
    private Integer durationMinutesTo;
}
