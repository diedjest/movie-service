package ru.vsu.cs.uvarov_d_p.movie_service.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vsu.cs.uvarov_d_p.movie_service.entity.Actor;
import ru.vsu.cs.uvarov_d_p.movie_service.entity.Movie;
import ru.vsu.cs.uvarov_d_p.movie_service.repository.ActorRepository;
import ru.vsu.cs.uvarov_d_p.movie_service.repository.MovieRepository;
import ru.vsu.cs.uvarov_d_p.movie_service.service.MovieService;

import java.util.List;

/**
 * Реализация сервиса для управления фильмами.
 * Обрабатывает бизнес-логику работы с фильмами и их связями с актерами.
 * @author Dmitriy Uvarov
 */
@Service
@AllArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final ActorRepository actorRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Movie getMovieById(Long id) {
        return movieRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Movie not found"));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Movie updateMovieById(Long id, Movie movie) {
        Movie existing = getMovieById(id);
        existing.setTitle(movie.getTitle());
        existing.setReleaseYear(movie.getReleaseYear());
        existing.setGenre(movie.getGenre());
        existing.setDurationMinutes(movie.getDurationMinutes());
        existing.setDescription(movie.getDescription());
        existing.setRating(movie.getRating());
        return movieRepository.save(existing);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteMovieById(Long id) {
        movieRepository.deleteById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Movie addActorToMovie(Long movieId, Long actorId) {
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new RuntimeException("Movie not found"));

        Actor actor = actorRepository.findById(actorId)
                .orElseThrow(() -> new RuntimeException("Actor not found"));

        actor.getMovies().add(movie);
        movie.getActors().add(actor);

        return movieRepository.save(movie);
    }
}

