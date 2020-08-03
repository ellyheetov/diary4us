package org.diary4us.dao;

import org.diary4us.dto.BoardInform;
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
import java.util.List;
import java.util.Map;

import static org.diary4us.dao.BoardInformDaoSqls.*;

@Repository
public class BoardInformDao {

    private NamedParameterJdbcTemplate jdbc;
    private RowMapper<BoardInform> rowMapper = BeanPropertyRowMapper.newInstance(BoardInform.class);
    private SimpleJdbcInsert insertAction;

    public BoardInformDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("board");
    }

    public List<BoardInform> selectAll(){
        return jdbc.query(SELECT_ALL, Collections.emptyMap(), rowMapper);
    }
    public int insert(BoardInform boardInform){
        SqlParameterSource params = new BeanPropertySqlParameterSource(boardInform);
        return insertAction.execute(params);
    }
    public int update(BoardInform boardInform){
        SqlParameterSource params = new BeanPropertySqlParameterSource(boardInform);
        return jdbc.update(UPDATE, params);
    }
    public int deleteById(Integer id){
        Map<String,?> params = Collections.singletonMap("boardId",id);
        return jdbc.update(DELETE_BY_ID,params);
    }
    public BoardInform selectById(Integer id){
        try{
            Map<String, ?> params = Collections.singletonMap("boardId",id);
            return jdbc.queryForObject(SELECT_BY_ID,params,rowMapper);
        }catch(EmptyResultDataAccessException e){
            return null;
        }
    }
}


