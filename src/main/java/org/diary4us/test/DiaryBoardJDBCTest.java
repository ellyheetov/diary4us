package org.diary4us.test;

import org.diary4us.config.DBconfig;
import org.diary4us.dao.DiaryBoardDao;
import org.diary4us.dto.DiaryBoard;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;

public class DiaryBoardJDBCTest {

    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(DBconfig.class);

        DiaryBoardDao diaryBoardDao = ac.getBean(DiaryBoardDao.class);

        DiaryBoard diaryBoard = new DiaryBoard();
        diaryBoard.setId(Integer.valueOf("8"));
        diaryBoard.setDiaryTitle("Hello");
        diaryBoard.setDiaryContent("Third Submit");
        diaryBoard.setCreateDate(new Date());

        //insert
        Integer insertionID = diaryBoardDao.insert(diaryBoard);
        System.out.println(insertionID + " insertion completed");
/*
       //update
        diaryBoard.setContent("third Submit");
        int updateCount = diaryBoardDao.update(diaryBoard);
        System.out.println(updateCount + " update completed");

//        delete
        int deleteCount = diaryBoardDao.deleteById(Integer.valueOf("6"));
        System.out.println(deleteCount + " delete completed");
*/
//        System.out.println(diaryBoardDao.selectSome(0,5));
    }
}