# Movie Service
Spring Boot REST API для управления фильмами и актерами.

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

- `POST   /api/v1/actors/{movieId}/actors/{actorId}` - добавить актера в фильм
