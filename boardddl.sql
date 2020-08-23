CREATE TABLE `board` (
  `board_id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '게시글 번호',
   `title` VARCHAR(255) NOT NULL COMMENT '제목',
  `content` TEXT DEFAULT NULL COMMENT 'board content',
  `regdate` DATETIME NULL DEFAULT NULL COMMENT '등록일',
  `password` INT(20) NOT NULL,
  PRIMARY KEY (`board_id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;

  INSERT INTO board (board_id, title, content, regdate) VALUE (1,'첫번쨰 글','첫번째 글입니다','2017-12-21 12:16:14');
  INSERT INTO board (board_id, title, content, regdate) VALUE (2,'2번쨰 글','번째 글입니다','2017-12-21 12:16:14');
  INSERT INTO board (board_id, title, content, regdate) VALUE (3,'세번쨰 글','번째 글입니다','2017-12-21 12:16:14');
  INSERT INTO board (board_id, title, content, regdate) VALUE (4,'네번째 글','이 편지는 영국에서 최초로 시작되어 일년에 한 바퀴 돌면서 받는 사람에게 행운을 주었고 지금은 당신에게로 옮겨진 이 편지는 4일 안에 당신의 ...','2017-12-21 12:16:14');