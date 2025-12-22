package ru.vsu.cs.uvarov_d_p.movie_service.service;

import ru.vsu.cs.uvarov_d_p.movie_service.entity.Actor;

import java.util.List;

/**
 * Сервисный интерфейс для управления бизнес-логикой работы с актерами.
 * Определяет контракт операций CRUD (Create, Read, Update, Delete)
 * и специфичных бизнес-операций для сущности {@link Actor}.
 * @author Dmitriy Uvarov
 */
public interface ActorService {

    /**
     * Сохраняет актера в системе
     * @param actor объект актера
     * @return сохраненный объект актера
     */
    Actor saveActor(Actor actor);

    /**
     * Получает список всех актеров
     * @return список актеров
     */
    List<Actor> getAllActors();

    /**
     * Получает актера по идентификатору
     * @param id идентификатор актера
     * @return объект актера
     */
    Actor getActorById(Long id);

    /**
     * Обновляет актера по идентификатору
     * @param id идентификатор обновляемого актера
     * @param actor новый объект актера
     * @return обновленный объект актера
     */
    Actor updateActorById(Long id, Actor actor);

    /**
     * Удаляет актера по идентификатору
     * @param id идентификатор актера
     */
    void deleteActorById(Long id);

    /**
     * Добавляет фильм актеру
     * @param actorId идентификатор актера
     * @param movieId идентификатор фильма
     * @return объект актера с сохраненным фильмом
     */
    Actor addMovieToActor(Long actorId, Long movieId);
}
