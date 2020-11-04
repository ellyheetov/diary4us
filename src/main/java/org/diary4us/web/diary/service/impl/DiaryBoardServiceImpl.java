package org.diary4us.web.diary.service.impl;

import org.diary4us.web.diary.dao.DiaryBoardDao;
import org.diary4us.web.diary.dto.DiaryBoard;
import org.diary4us.web.diary.service.DiaryBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class DiaryBoardServiceImpl implements DiaryBoardService {

    @Autowired
    DiaryBoardDao diaryBoardDao;

    @Override
    public DiaryBoard getBoard(Integer id) {
        DiaryBoard diaryBoard = diaryBoardDao.selectById(id);
        return diaryBoard;
    }

    @Override
    public List<DiaryBoard> getBoards(Integer start) {
        List<DiaryBoard> list = diaryBoardDao.selectSome(start, DiaryBoardService.LIMIT);
        return list;
    }

    @Override
    @Transactional
    public Integer deleteBoard(Integer id) {
        int deleteCount = diaryBoardDao.deleteById(id);
        return deleteCount;
    }

    @Override
    @Transactional
    public DiaryBoard insertBoard(DiaryBoard diaryBoard) {
        diaryBoard.setCreateDate(new Date());
        Integer id = diaryBoardDao.insert(diaryBoard);
        return diaryBoard;
    }

    @Override
    public DiaryBoard updateBoard(DiaryBoard diaryBoard) {
        diaryBoardDao.update(diaryBoard);
        return diaryBoard;
    }

    @Override
    public Integer getCount() {
        return diaryBoardDao.selectCount();
    }
}
