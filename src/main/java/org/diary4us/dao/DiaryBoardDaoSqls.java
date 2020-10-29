package org.diary4us.dao;

public class DiaryBoardDaoSqls {
    public static final String SELECT_ALL = "SELECT id, diary_title, diary_content, create_date, modify_date FROM diaryBoard ORDER BY id";
    public static final String SELECT_BY_ID = "SELECT id, diary_title, diary_content, create_date, modify_date FROM diaryBoard WHERE board_id = :id";
    public static final String SELECT_COUNT = "SELECT count(*) FROM diaryBoard";
    public static final String SELECT_SOME = "SELECT id, diary_title, diary_content, create_date, modify_date FROM diaryBoard ORDER BY id ASC limit :start, :limit";


    public static final String INSERT = "INSERT INTO diaryBoard VALUES (diary_title = :title, diary_content = :content)";
    public static final String UPDATE = "UPDATE diaryBoard SET diary_title = :title, diary_content = :content WHERE id = :id";

    public static final String DELETE_BY_ID = "DELETE FROM diaryBoard WHERE id = :id";

}
