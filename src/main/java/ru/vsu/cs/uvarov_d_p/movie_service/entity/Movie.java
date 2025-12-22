package ru.vsu.cs.uvarov_d_p.movie_service.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

/**
 * Сущность, представляющая фильм в системе.
 * Содержит информацию о фильме, включая название, описание,
 * год выпуска, жанр, длительность, рейтинг и актеров, которые в нем снимались.
 * <p>Фильм связан с сущностью {@link Actor} через отношение многие-ко-многим.</p>
 * @author Dmitriy Uvarov
 */
@Entity
@Getter
@Setter
@Table(name = "movies")
public class Movie {

    /**
     * Уникальный идентификатор фильма.
     * Генерируется автоматически базой данных
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * Название фильма.
     * Минимальная длина - 1, максимальная длина - 255
     */
    @Size(min = 1, max = 255)
    private String title;

    /**
     * Год выпуска фильма.
     * Минимальное значение - 1900
     * Максимальное значение - 2100
     */
    @Min(value = 1900)
    @Max(value = 2100)
    private int releaseYear;

    /**
     * Жанр фильма
     * Минимальная длина - 1
     * Максимальная длина - 255
     */
    @Size(min = 1, max = 255)
    private String genre;

    /**
     * Длительность фильма в минутах
     * Минимальное значение - 1
     * Максимальное значение - 1000
     */
    @Min(value = 1)
    @Max(value = 1000)
    private int durationMinutes;

    /**
     * Описание фильма.
     * Максимальная длина 1000 символов
     */
    @Column(length = 1000)
    private String description;

    /**
     * Рейтинг фильма
     * Минимальное значение - 0, максимальное - 10
     */
    @Min(value = 0)
    @Max(value = 10)
    private double rating;

    /**
     * Актеры, сыгравшие в данном фильме.
     * Реализует отношение многие-ко-многим с сущностью {@link Actor}.
     * Использует промежуточную таблицу "movie_actor" для связи.
     * <p>Игнорирует свойство "movies" при сериализации в JSON
     * для предотвращения циклических ссылок.</p>
     */
    @Getter
    @ManyToMany(mappedBy = "movies")
    @JsonIgnoreProperties("movies")
    private Set<Actor> actors = new HashSet<>();

}
