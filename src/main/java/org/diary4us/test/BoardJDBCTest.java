package org.diary4us.test;

import org.diary4us.config.DBconfig;
import org.diary4us.dao.BoardInformDao;
import org.diary4us.dto.BoardInform;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Date;

public class BoardJDBCTest {

    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(DBconfig.class);

        BoardInformDao boardInformDao = ac.getBean(BoardInformDao.class);

        BoardInform boardInform = new BoardInform();
        boardInform.setBoardId(Long.valueOf("4"));
        boardInform.setTitle("Hello");
        boardInform.setContent("Second Submit");

        //insert
        Long insertionID = boardInformDao.insert(boardInform);
        System.out.println(insertionID + " insertion completed");

        //update
        boardInform.setContent("third Submit");
        int updateCount = boardInformDao.update(boardInform);
        System.out.println(updateCount + " update completed");

//        delete
        int deleteCount = boardInformDao.deleteById(Long.valueOf("6"));
        System.out.println(deleteCount + " delete completed");

    }
}