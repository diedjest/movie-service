# Movie Service

Spring Boot REST API для управления каталогом фильмов и актеров. Проект демонстрирует реализацию классической слоистой архитектуры (Controller - Service - Repository) и работу с реляционными базами данных через Spring Data JPA (Hibernate).

[Ссылка на видео работы сервиса](https://drive.google.com/file/d/1Du5Z14IHu60vbZq8y0H6SQ-ZbSrDjvui/view?usp=sharing)

## API Endpoints

### Актеры
- `GET    /api/v1/actors` - список всех актеров
- `GET    /api/v1/actors/{id}` - получить актера по ID
- `POST   /api/v1/actors/save_actor` - создать актера
- `PUT    /api/v1/actors/update_actor/{id}` - обновить данные актера
- `DELETE /api/v1/actors/delete_actor/{id}` - удалить актера
- `POST   /api/v1/actors/{actorId}/movies/{movieId}` - добавить фильм актеру

### Фильмы
- `GET    /api/v1/movies` - список всех фильмов
- `GET    /api/v1/movies/{id}` - получить фильм по ID
- `POST   /api/v1/movies/save_movie` - создать фильм
- `PUT    /api/v1/movies/update_movie/{id}` - обновить информацию о фильме
- `DELETE /api/v1/movies/delete_movie/{id}` - удалить фильм
- `POST   /api/v1/movies/{movieId}/actors/{actorId}` - добавить актера в фильм

## Архитектура и технические решения
* **Слоистая архитектура:** Четкое разделение бизнес-логики (`ActorServiceImpl`, `MovieServiceImpl`), REST-контроллеров и слоя доступа к данным.
* **Связи JPA:** Реализована двунаправленная связь `@ManyToMany` между сущностями `Movie` и `Actor`.
* **Безопасная сериализация:** Использование `@JsonIgnoreProperties` для предотвращения бесконечной рекурсии (StackOverflowError) при генерации JSON-ответов для связанных сущностей.
* **Валидация данных:** Интеграция `spring-boot-starter-validation` (Jakarta Validation) для проверки входящих DTO на соответствие бизнес-правилам (аннотации `@Min`, `@Max`, `@Size`, `@Valid`).
* **Контейнеризация:** Использование `docker-compose` для быстрого и унифицированного развертывания инфраструктуры (PostgreSQL).
* **Документация API:** Интеграция Swagger UI / OpenAPI (`springdoc-openapi-starter-webmvc-ui`) для удобного тестирования конечных точек.
* **Интеграционное тестирование:** Настроены зависимости `Testcontainers` для безопасного тестирования слоя БД в изолированных Docker-контейнерах.

## Стек технологий
* **Язык:** Java 17
* **Фреймворк:** Spring Boot 3.3.x (Web, Data JPA, Validation)
* **База данных:** PostgreSQL 17
* **Миграции/Сборка:** Maven
* **Инструменты:** Lombok, Swagger/OpenAPI, Docker, Testcontainers

## Запуск проекта

### Требования
* Java 17
* Docker и Docker Compose
* Maven

### Шаги по запуску

1. **Запуск базы данных:**
   В корне проекта выполните команду для поднятия контейнера PostgreSQL:
   ```bash
   docker-compose up -d
   ```
   *БД будет доступна на порту 5432 (database: `movie_service_db`, user: `postgres`, password: `pass`).*

2. **Сборка и запуск приложения:**
   ```bash
   ./mvnw clean package
   java -jar target/movie_service-0.0.1-SNAPSHOT.jar
   ```
   *Приложение запустится на порту `8080`.*

3. **Тестирование API:**
   Откройте Swagger UI в браузере для просмотра и вызова доступных эндпоинтов:
   [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
