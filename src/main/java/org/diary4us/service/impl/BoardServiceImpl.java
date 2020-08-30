package org.diary4us.service.impl;

import org.diary4us.dao.BoardInformDao;
import org.diary4us.dto.BoardInform;
import org.diary4us.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    BoardInformDao boardInformDao;

    @Override
    public List<BoardInform> getBoards(Integer start) {
        List<BoardInform> list = boardInformDao.selectAll(start, BoardService.LIMIT);
        return list;
    }

    @Override
    @Transactional(readOnly = false)
    public int deleteBoard(Long id) {
        int deleteCount = boardInformDao.deleteById(id);
        return deleteCount;
    }

    @Override
    @Transactional(readOnly = false)
    public BoardInform addBoard(BoardInform boardInform) {
        boardInform.setRegdate(new Date());
        Long id = boardInformDao.insert(boardInform);
//        boardInform.setBoardId(id);

        return boardInform;
    }

    @Override
    public int getCount() {
        return boardInformDao.selectCount();
    }
}
