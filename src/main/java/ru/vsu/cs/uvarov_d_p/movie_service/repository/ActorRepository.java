package ru.vsu.cs.uvarov_d_p.movie_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vsu.cs.uvarov_d_p.movie_service.entity.Actor;

/**
 * Репозиторий для работы с сущностями {@link Actor}.
 * Предоставляет стандартные операции CRUD (Create, Read, Update, Delete)
 * для управления данными об актерах в базе данных.
 * @author Dmitriy Uvarov
 */
public interface ActorRepository extends JpaRepository<Actor, Long> {
}

