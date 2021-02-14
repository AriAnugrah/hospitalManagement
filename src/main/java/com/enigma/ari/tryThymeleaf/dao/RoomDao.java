package com.enigma.ari.tryThymeleaf.dao;

import com.enigma.ari.tryThymeleaf.entities.Rooms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoomDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Rooms> list() {
        String sql = "SELECT * FROM ROOMS";

        List<Rooms> listRooms = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Rooms.class));

        return listRooms;
    }

    public void save(Rooms rooms) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("rooms").usingColumns("roomname", "code", "bed");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(rooms);

        insertActor.execute(param);
    }

    public Rooms get(int id) {
        String sql = "SELECT * FROM ROOMS WHERE id = ?";
        Object[] args = {id};
        Rooms rooms = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(Rooms.class));
        return rooms;
    }

    public void update(Rooms rooms) {
        String sql = "UPDATE ROOMS SET roomname=:roomname, code=:code, bed=:bed WHERE id=:id";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(rooms);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }

    public void delete(int id) {
        String sql = "DELETE FROM ROOMS WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
