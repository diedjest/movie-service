package ru.vsu.cs.uvarov_d_p.movie_service.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Transient;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashSet;
import java.util.Set;

/**
 * Сущность, представляющая актера в системе.
 * Содержит информацию об актере, включая персональные данные,
 * возраст и фильмы, в которых актер снимался.
 * <p>Актер связан с сущностью {@link Movie} через отношение многие-ко-многим.</p>
 * @author Dmitriy Uvarov
 */
@Entity
@Getter
@Setter
@Table(name = "actors")
public class Actor {

    /**
     * Уникальный идентификатор актера.
     * Генерируется автоматически базой данных.
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * Имя актера.
     * Минимальная длина - 1 символ, максимальная длина - 100 символов
     */
    @Size(min = 1, max = 255)
    private String firstName;

    /**
     * Фамилия актера.
     * Минимальная длина - 1 символ, максимальная длина - 100 символов
     */
    @Size(min = 1, max = 255)
    private String lastName;

    /**
     * Дата рождения актера.
     * Используется для вычисления возраста.
     */
    private LocalDate birthDate;

    /**
     * Возраст актера, вычисляемый на основе даты рождения.
     * @see #getAge()
     */
    @Transient
    private int age;

    /**
     * Пол актера.
     */
    @Size(min = 1, max = 255)
    private String gender;

    /**
     * Страна происхождения актера.
     */
    @Size(min = 1, max = 255)
    private String country;

    /**
     * Набор фильмов, в которых снимался актер.
     * Реализует отношение многие-ко-многим с сущностью {@link Movie}.
     * Использует промежуточную таблицу "movie_actor" для связи.
     * <p>Игнорирует свойство "actors" при сериализации в JSON
     * для предотвращения циклических ссылок.</p>
     */
    @Getter
    @ManyToMany
    @JoinTable(
            name = "movie_actor",
            joinColumns = @JoinColumn(name = "actor_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id")
    )
    @JsonIgnoreProperties("actors")
    private Set<Movie> movies = new HashSet<>();

    /**
     * Вычисляет возраст актера на основе даты рождения и текущей даты.
     * @return возраст актера в годах
     */
    public int getAge() {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }
}
