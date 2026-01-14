package ru.vsu.cs.uvarov_d_p.movie_service.service;

import ru.vsu.cs.uvarov_d_p.movie_service.entity.Actor;
import ru.vsu.cs.uvarov_d_p.movie_service.entity.Movie;

import java.util.List;

/**
 * Сервисный интерфейс для управления бизнес-логикой работы с фильмами.
 * Определяет контракт операций CRUD (Create, Read, Update, Delete)
 * и специфичных бизнес-операций для сущности {@link Movie}.
 * @author Dmitriy Uvarov
 */
public interface MovieService {

    /**
     * Сохраняет фильм в базу данных
     * @param movie объект фильма
     * @return сохраенный объект фильма
     */
    Movie saveMovie(Movie movie);

    /**
     * Получает список со всеми фильмами
     * @return список фильмов
     */
    List<Movie> getAllMovies();

    /**
     * Получает фильм по идентификатору
     * @param id идентификатор фильма
     * @return объект фильма
     */
    Movie getMovieById(Long id);

    /**
     * Обновляет фильм по идентификатору
     * @param id идентификатор обновляемого фильма
     * @param movie новые данные о фильме
     * @return обновленный объект фильма
     */
    Movie updateMovieById(Long id, Movie movie);

    /**
     * Удаляет фильм по идентификатору
     * @param id идентификатор фильма
     */
    void deleteMovieById(Long id);

    /**
     * Добавляет актера в фильм
     * @param movieId идентификатор фильма
     * @param actorId идентификатор актера
     * @return объект фильма с добавленным актером
     */
    Movie addActorToMovie(Long movieId, Long actorId);
}
