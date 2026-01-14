package ru.vsu.cs.uvarov_d_p.movie_service.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vsu.cs.uvarov_d_p.movie_service.entity.Actor;
import ru.vsu.cs.uvarov_d_p.movie_service.entity.Movie;
import ru.vsu.cs.uvarov_d_p.movie_service.repository.ActorRepository;
import ru.vsu.cs.uvarov_d_p.movie_service.repository.MovieRepository;
import ru.vsu.cs.uvarov_d_p.movie_service.service.ActorService;

import java.util.List;

/**
 * Реализация сервиса для управления актерами.
 * Обрабатывает бизнес-логику работы с актерами и их связями с фильмами.
 * @author Dmitriy Uvarov
 */
@Service
@AllArgsConstructor
public class ActorServiceImpl implements ActorService {

    private final ActorRepository actorRepository;
    private final MovieRepository movieRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Actor> getAllActors() {
        return actorRepository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Actor getActorById(Long id) {
        return actorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Actor not found"));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Actor updateActorById(Long id, Actor actor) {
        Actor existing = getActorById(id);
        existing.setFirstName(actor.getFirstName());
        existing.setLastName(actor.getLastName());
        existing.setBirthDate(actor.getBirthDate());
        existing.setGender(actor.getGender());
        existing.setCountry(actor.getCountry());
        return actorRepository.save(existing);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteActorById(Long id) {
        actorRepository.deleteById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Actor saveActor(Actor actor) {
        return actorRepository.save(actor);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Actor addMovieToActor(Long actorId, Long movieId) {
        Actor actor = actorRepository.findById(actorId)
                .orElseThrow(() -> new IllegalArgumentException("Actor not found"));

        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new IllegalArgumentException("Movie not found"));

        actor.getMovies().add(movie);
        movie.getActors().add(actor);

        return actorRepository.save(actor);
    }

}

