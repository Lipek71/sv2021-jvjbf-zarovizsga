CREATE TABLE `players`
(
    `id`                BIGINT(20)      AUTO_INCREMENT PRIMARY KEY ,
    `name`              VARCHAR(255)    DEFAULT NULL,
    `position`     VARCHAR(255)    DEFAULT NULL,
    `birth_date`        DATE            DEFAULT NULL,
    `teams_id`          BIGINT(20)      DEFAULT NULL,
    CONSTRAINT `fk_teams_players_id` FOREIGN KEY (`teams_id`) REFERENCES `exam`.`teams` (`id`) ON UPDATE RESTRICT ON DELETE RESTRICT
);