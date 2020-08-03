package org.diary4us.dao;

public class BoardInformDaoSqls {
    public static final String SELECT_ALL = "SELECT board_id, title, content, regdate FROM board ORDER BY board_id";
    public static final String UPDATE = "UPDATE board SET title = :title, content = :content WHERE board_id = :boardId";
    public static final String DELETE_BY_ID = "DELETE FROM board WHERE board_id = :boardId";
    public static final String SELECT_BY_ID = "SELECT board_id, title, content, regdate FROM board WHERE board_id = :boardId";
}