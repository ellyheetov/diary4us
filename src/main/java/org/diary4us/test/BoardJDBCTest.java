package org.diary4us.test;

import org.diary4us.config.DBconfig;
import org.diary4us.dao.BoardInformDao;
import org.diary4us.dto.BoardInform;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BoardJDBCTest {

    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(DBconfig.class);

        BoardInformDao boardInformDao = ac.getBean(BoardInformDao.class);

        BoardInform boardInform = new BoardInform();
        boardInform.setBoardId(1);
        boardInform.setTitle("Hello");
        boardInform.setContent("First Submit");

        //insert
        int insertionCount = boardInformDao.insert(boardInform);
        System.out.println(insertionCount + " insertion completed");

        //update
        boardInform.setContent("Second Submit");
        int updateCount = boardInformDao.update(boardInform);
        System.out.println(updateCount + " update completed");

        //delete
        int deleteCount = boardInformDao.deleteById(1);
        System.out.println(deleteCount + " delete completed");

    }
}

/*
 Role resultRole = roleDao.selectById(101);
        System.out.println(resultRole);

                int deleteCount = roleDao.deleteById(101);
                System.out.println(deleteCount + " 건 삭제하였습니다.");

                Role resultRole2 = roleDao.selectById(101);
                System.out.println(resultRole2);
                }

 */