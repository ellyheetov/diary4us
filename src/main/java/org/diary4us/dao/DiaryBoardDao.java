package org.diary4us.dao;

import org.diary4us.dto.DiaryBoard;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.diary4us.dao.DiaryBoardDaoSqls.*;

@Repository
public class DiaryBoardDao {

    private NamedParameterJdbcTemplate jdbc;
    private RowMapper<DiaryBoard> rowMapper = BeanPropertyRowMapper.newInstance(DiaryBoard.class);
    private SimpleJdbcInsert insertAction;

    public DiaryBoardDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insertAction = new SimpleJdbcInsert(dataSource)
                .withTableName("diaryBoard")
                .usingGeneratedKeyColumns("id");
    }

    public List<DiaryBoard> selectSome(int start, int limit) {
        Map<String, Integer> params = new HashMap<String, Integer>();
        params.put("start", start);
        params.put("limit", limit);
        return jdbc.query(SELECT_SOME, params, rowMapper);
    }

    public Integer insert(DiaryBoard diaryBoard) {
        SqlParameterSource params = new BeanPropertySqlParameterSource(diaryBoard);
        return insertAction.executeAndReturnKey(params).intValue();
    }

    public Integer update(DiaryBoard diaryBoard) {
        SqlParameterSource params = new BeanPropertySqlParameterSource(diaryBoard);
        return jdbc.update(UPDATE, params);
    }

    public Integer deleteById(Integer id) {
        Map<String, ?> params = Collections.singletonMap("id", id);
        return jdbc.update(DELETE_BY_ID, params);
    }

    public DiaryBoard selectById(Integer id) {
        try {
            Map<String, ?> params = Collections.singletonMap("id", id);
            return jdbc.queryForObject(SELECT_BY_ID, params, rowMapper);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
    public int selectCount(){
        return jdbc.queryForObject(SELECT_COUNT, Collections.<String,Object>emptyMap(),Integer.class);
    }
}


