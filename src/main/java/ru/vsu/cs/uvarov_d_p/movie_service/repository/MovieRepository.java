package ru.vsu.cs.uvarov_d_p.movie_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vsu.cs.uvarov_d_p.movie_service.entity.Actor;
import ru.vsu.cs.uvarov_d_p.movie_service.entity.Movie;

/**
 * Репозиторий для работы с сущностями {@link Movie}.
 * Предоставляет стандартные операции CRUD (Create, Read, Update, Delete)
 * для управления данными о фильмах в базе данных.
 * @author Dmitriy Uvarov
 */
public interface MovieRepository extends JpaRepository<Movie, Long> {
}

