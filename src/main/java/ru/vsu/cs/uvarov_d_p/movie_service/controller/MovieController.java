package ru.vsu.cs.uvarov_d_p.movie_service.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vsu.cs.uvarov_d_p.movie_service.entity.Movie;
import ru.vsu.cs.uvarov_d_p.movie_service.service.impl.MovieServiceImpl;

import java.util.List;

/**
 * Контроллер для управления фильмами.
 * Предоставляет REST API для создания, чтения, обновления и удаления фильмов,
 * а также для управления связями фильмов с актерами.
 * @author Dmitriy Uvarov
 */
@RestController
@RequestMapping("api/v1/movies")
@AllArgsConstructor
public class MovieController {

    private final MovieServiceImpl movieService;

    /**
     * Создает объект фильма
     * @param movie объект фильма
     * @return сохраненный объект фильма
     */
    @PostMapping("save_movie")
    public Movie saveMovie(@RequestBody @Valid Movie movie) {
        return movieService.saveMovie(movie);
    }

    /**
     * Получает список фильмов
     * @return список фильмов
     */
    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    /**
     * Получает фильм по идентификатору
     * @param id идентификатор фильма
     * @return объект фильма
     */
    @GetMapping("/{id}")
    public Movie getMovieById(@PathVariable Long id) {
        return movieService.getMovieById(id);
    }

    /**
     * Удаляет фильм по идентификатору
     * @param id идентификатор фильма
     */
    @DeleteMapping("delete_movie/{id}")
    public void deleteMovieById(@PathVariable Long id) {
        movieService.deleteMovieById(id);
    }

    /**
     * Обновляет объект фильма по идентификатору
     * @param id идентификатор обновляемого фильма
     * @param movie объект фильма с новыми данными
     * @return обновленный объект фильма
     */
    @PutMapping("update_movie/{id}")
    public Movie updateMovieById(
            @PathVariable Long id,
            @RequestBody @Valid Movie movie) {
        return movieService.updateMovieById(id, movie);
    }

    /**
     * Добавляет актера в фильм
     * @param movieId идентификатор фильма
     * @param actorId идентификатор актера
     * @return объект фильма с добавленным актером
     */
    @PostMapping("/{movieId}/actors/{actorId}")
    public Movie addActorToMovie(
            @PathVariable Long movieId,
            @PathVariable Long actorId
    ) {
        return movieService.addActorToMovie(movieId, actorId);
    }
}

