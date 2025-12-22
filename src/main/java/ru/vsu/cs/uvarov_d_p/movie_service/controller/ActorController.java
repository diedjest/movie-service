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
import ru.vsu.cs.uvarov_d_p.movie_service.entity.Actor;
import ru.vsu.cs.uvarov_d_p.movie_service.service.impl.ActorServiceImpl;

import java.util.List;

/**
 * Контроллер для управления актерами.
 * Предоставляет REST API для создания, чтения, обновления и удаления актеров,
 * а также для управления связями актеров с фильмами.
 * @author Dmitriy Uvarov
 */
@RestController
@RequestMapping("api/v1/actors")
@AllArgsConstructor
public class ActorController {

    private final ActorServiceImpl actorService;

    /**
     * Создает нового района
     * @param actor - объект актера
     * @return сохраненный объект актера
     */
    @PostMapping("save_actor")
    public Actor saveActor(@RequestBody @Valid Actor actor) {
        return actorService.saveActor(actor);
    }

    /**
     * Получает список всех актеров
     * @return список всех актеров
     */
    @GetMapping
    public List<Actor> getAllActors() {
        return actorService.getAllActors();
    }

    /**
     * Получает актера по идентификатору
     * @param id идентификатор актера
     * @return объект актера
     */
    @GetMapping("/{id}")
    public Actor getActorById(@PathVariable Long id) {
        return actorService.getActorById(id);
    }

    /**
     * Обновляет объект актера
     * @param id идентифкатор актера для обновления
     * @param actor объект актера с новыми данными
     * @return обновленный объект актера
     */
    @PutMapping("update_actor/{id}")
    public Actor updateActorById(
            @PathVariable Long id,
            @RequestBody @Valid Actor actor
    ) {
        return actorService.updateActorById(id, actor);
    }

    /**
     * Удаляет актера по идентификатору
     * @param id идентификатор актера
     */
    @DeleteMapping("delete_actor/{id}")
    public void deleteActorById(@PathVariable Long id) {
        actorService.deleteActorById(id);
    }

    /**
     * Добаляет фильм актеру
     * @param actorId идентификатор актера
     * @param movieId идентификатор фильма
     * @return объект актера с добавленным фильмом
     */
    @PostMapping("/{actorId}/movies/{movieId}")
    public Actor addMovieToActor(
            @PathVariable Long actorId,
            @PathVariable Long movieId
    ) {
        return actorService.addMovieToActor(actorId, movieId);
    }
}

