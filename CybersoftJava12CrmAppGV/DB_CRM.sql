drop DATABASE MY_CRM;

CREATE DATABASE  IF NOT EXISTS MY_CRM
DEFAULT CHARACTER SET utf8
COLLATE utf8_bin ;

USE MY_CRM;

CREATE TABLE IF NOT EXISTS role (
    id 	          INT NOT NULL AUTO_INCREMENT,
    name          VARCHAR(100) NOT NULL,
    description   VARCHAR(100),
    PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS user (
    id        INT NOT NULL AUTO_INCREMENT,
    email     VARCHAR(100) NOT NULL,
    password  VARCHAR(255) NOT NULL,
    name      VARCHAR(255) NOT NULL,
    address   VARCHAR(255),
    phone     VARCHAR(50),
    role_id   INT,
    PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS task (
    id            INT NOT NULL AUTO_INCREMENT,
    name          VARCHAR(255) NOT NULL,
    description   VARCHAR(255),
    start_date    date,
    end_date      date,
    project       INT,
    user          INT,
    status        INT,
    PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS project_user (
    projectid        INT,
    userid           INT,
    join_date        date,
    role_description varchar(255)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS project (
    id           INT NOT NULL AUTO_INCREMENT,
    name         VARCHAR(255) NOT NULL,
    description  VARCHAR(255),
    start_date   date,
    end_date     date,
    owner        INT,
    PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS status (
    id           INT,
    name         VARCHAR(255) NOT NULL,
    description  VARCHAR(255),
    PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE user ADD FOREIGN KEY (role_id) REFERENCES role (id)  ON DELETE CASCADE;

ALTER TABLE task ADD FOREIGN KEY (user) REFERENCES user (id)  ON DELETE CASCADE;
ALTER TABLE task ADD FOREIGN KEY (status) REFERENCES status (id)  ON DELETE CASCADE;
ALTER TABLE task ADD FOREIGN KEY (project) REFERENCES project (id)  ON DELETE CASCADE;

ALTER TABLE project ADD FOREIGN KEY (owner) REFERENCES user (id)  ON DELETE CASCADE;

ALTER TABLE project_user ADD FOREIGN KEY (projectid) REFERENCES project (id)  ON DELETE CASCADE;
ALTER TABLE project_user ADD FOREIGN KEY (userid) REFERENCES user (id)  ON DELETE CASCADE;

INSERT INTO `MY_CRM`.`role` (`name`, `description`) VALUES ('role1', 'description 1');
INSERT INTO `MY_CRM`.`role` (`name`, `description`) VALUES ('role2', 'description 2');
INSERT INTO `MY_CRM`.`role` (`name`, `description`) VALUES ('role3', 'description 3');
INSERT INTO `MY_CRM`.`role` (`name`, `description`) VALUES ('role4', 'description 4');
INSERT INTO `MY_CRM`.`role` (`name`, `description`) VALUES ('role5', 'description 5');

INSERT INTO `MY_CRM`.`user` (`email`, `password`, `name`, `address`, `phone`, `role_id`) VALUES ('admin@gmail.com', '1234', 'Admin', '007HCM', '094444444', 4);
INSERT INTO `MY_CRM`.`user` (`email`, `password`, `name`, `address`, `phone`, `role_id`) VALUES ('tan@gmail.com', '123abc', 'Trần Minh Tân', '1HCM', '0987654321', 4);
INSERT INTO `MY_CRM`.`user` (`email`, `password`, `name`, `address`, `phone`, `role_id`) VALUES ('hoa@gmail.com', 'hoahau69', 'Nguyễn Thị Hoa', '2HCM', '0999999999', 3);
INSERT INTO `MY_CRM`.`user` (`email`, `password`, `name`, `phone`, `role_id`) VALUES ('hieu@gmail.com', 'hieu007', 'Hồ Quang Hiếu', '0969696969', 1);
INSERT INTO `MY_CRM`.`user` (`email`, `password`, `name`, `address`, `phone`, `role_id`) VALUES ('tin@gmail.com', 'tin404', 'Nguyễn Hữu Tín', '4HCM', '0979797979', 4);
INSERT INTO `MY_CRM`.`user` (`email`, `password`, `name`, `address`, `role_id`) VALUES ('linh@gmail.com', 'linh789', 'Lung Linh', '5HCM', 5);
INSERT INTO `MY_CRM`.`user` (`email`, `password`, `name`, `address`, `phone`, `role_id`) VALUES ('thuy@gmail.com', 'thuynguyen', 'Phạm Thuỳ', '6HCM', '0909090909', 4);
INSERT INTO `MY_CRM`.`user` (`email`, `password`, `name`, `role_id`) VALUES ('diem@gmail.com', 'diemtran', 'Trần Diễm', 5);

INSERT INTO `MY_CRM`.`status` (`id`, `name`, `description`) VALUES (1, 'Inprogress', 'descInprogress');
INSERT INTO `MY_CRM`.`status` (`id`, `name`, `description`) VALUES (2, 'Done', 'descDone');
INSERT INTO `MY_CRM`.`status` (`id`, `name`, `description`) VALUES (3, 'Release', 'descRelease');


INSERT INTO `MY_CRM`.`project` (`name`, `description`, `start_date`, `end_date`, `owner`) VALUES ('project1', 'pro desc 1', '2021-05-31', '2022-05-31', 1);
INSERT INTO `MY_CRM`.`project` (`name`, `description`, `start_date`, `end_date`, `owner`) VALUES ('project2', 'pro desc 2', '2010-01-23', '2013-06-10', 3);
INSERT INTO `MY_CRM`.`project` (`name`, `description`, `start_date`, `end_date`, `owner`) VALUES ('project3', 'pro desc 3', '2010-01-26', '2014-04-15', 5);
INSERT INTO `MY_CRM`.`project` (`name`, `description`, `start_date`, `end_date`, `owner`) VALUES ('project4', 'pro desc 4', '2015-12-24', '2025-08-22', 2);
INSERT INTO `MY_CRM`.`project` (`name`, `description`, `owner`) VALUES ('project5', 'pro desc 5', 1);

INSERT INTO `MY_CRM`.`project_user` (`projectid`, `userid`, `join_date`, `role_description`) VALUES (1, 1, '2021-04-30', 'joined');
INSERT INTO `MY_CRM`.`project_user` (`projectid`, `userid`, `join_date`, `role_description`) VALUES (3, 5, '2010-01-01', 'joined');
INSERT INTO `MY_CRM`.`project_user` (`projectid`, `userid`, `join_date`, `role_description`) VALUES (4, 7, '2015-11-30', 'joined');
INSERT INTO `MY_CRM`.`project_user` (`projectid`, `userid`, `join_date`, `role_description`) VALUES (3, 6, '2010-02-10', 'joined');
INSERT INTO `MY_CRM`.`project_user` (`projectid`, `userid`, `join_date`, `role_description`) VALUES (5, 2, '2021-07-04', 'joined');
INSERT INTO `MY_CRM`.`project_user` (`projectid`, `userid`, `join_date`, `role_description`) VALUES (2, 1, '2010-01-09', 'joined');

INSERT INTO `MY_CRM`.`task` (`name`, `description`, `start_date`, `end_date`, `project`, `user`, `status`) VALUES ('task1', 'desc task 1','2021-04-30', '2022-05-31', 1, 1, 2);
INSERT INTO `MY_CRM`.`task` (`name`, `description`, `start_date`, `end_date`, `project`, `user`, `status`) VALUES ('task2', 'desc task 2','2010-01-01', '2014-04-15', 3, 5, 2);
INSERT INTO `MY_CRM`.`task` (`name`, `description`, `start_date`, `end_date`, `project`, `user`, `status`) VALUES ('task3', 'desc task 3','2010-02-10', '2014-04-15', 3, 6, 2);
INSERT INTO `MY_CRM`.`task` (`name`, `description`, `project`, `user`, `status`) VALUES ('task4', 'desc task 4', 5, 2, 3);
INSERT INTO `MY_CRM`.`task` (`name`, `description`, `start_date`, `project`, `user`, `status`) VALUES ('task5', 'desc task 5','2015-11-30', 4, 7, 1);
INSERT INTO `MY_CRM`.`task` (`name`, `description`, `start_date`, `end_date`, `project`, `user`, `status`) VALUES ('task6', 'desc task 6','2010-01-09', '2013-06-10', 2, 1, 2);

