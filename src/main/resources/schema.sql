INSERT INTO author (name, age)
VALUES
('qwerty', 28),
('reanno', 46),
('ivan334', 32),
('apple', 21),
('wind23', 23);

INSERT INTO article (title, text, created, author_id)
VALUES
('Stream API', 'Статья про Stream API', '2017-10-19T10:23', 1),
('Lambda', 'Статья про Lambda', '2019-03-27T16:33', 1),
('Java 13', 'Статья про Java 13', '2019-11-28T17:10', 2),
('Garbage Collectors', 'Статья про GC', '2020-08-07T11:55', 2),
('Hibernate', 'Статья про Hibernate', '2018-12-01T21:30', 2),
('Collections API', 'Collections API', '2020-11-22T22:29', 3);


INSERT INTO nomination (name)
VALUES
('Java 8'),
('Базы Данных'),
('Функциональное Программирование Java');

INSERT INTO article_nomination (nomination_id, article_id, rate)
VALUES
(1, 2, 1),
(1, 1, 3),
(2, 5, 3),
(3, 2, 1),
(3, 6, 2);
