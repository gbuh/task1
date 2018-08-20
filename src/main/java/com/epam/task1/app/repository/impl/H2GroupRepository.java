package com.epam.task1.app.repository.impl;

import com.epam.task1.app.entity.Groups;
import com.epam.task1.app.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class H2GroupRepository implements GroupRepository {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    private static final class GroupMapper implements RowMapper<Groups> {

        @Override
        public Groups mapRow(ResultSet rs, int rowNum) throws SQLException {
            Groups Groups = new Groups();
            Groups.setName(rs.getString("name"));
            Groups.setVersion(rs.getInt("version"));
            Groups.setCreateDate(rs.getDate("create_date").toLocalDate());
            Groups.setUpdateDate(rs.getDate("update_date").toLocalDate());
            Groups.setCreatedUser(rs.getString("created_user"));
            Groups.setUpdatedUser(rs.getString("updated_user"));
            return Groups;
        }
    }

    @Override
    public List<Groups> findAll() {
        Map<String, Object> params = new HashMap<>();
        List<Groups> result = jdbcTemplate.query("SELECT * FROM Groups", params, new GroupMapper());
        return result;
    }

    @Override
    public List<Groups> findAll(Sort sort) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Groups> findAllById(Iterable<Long> ids) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends Groups> List<S> saveAll(Iterable<S> entities) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void flush() {
        // TODO Auto-generated method stub

    }

    @Override
    public <S extends Groups> S saveAndFlush(S entity) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Groups> entities) {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteAllInBatch() {
        // TODO Auto-generated method stub

    }

    @Override
    public Groups getOne(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends Groups> List<S> findAll(Example<S> example) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends Groups> List<S> findAll(Example<S> example, Sort sort) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Page<Groups> findAll(Pageable pageable) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends Groups> S save(S entity) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<Groups> findById(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean existsById(Long id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public long count() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void deleteById(Long id) {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(Groups entity) {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteAll(Iterable<? extends Groups> entities) {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteAll() {
        // TODO Auto-generated method stub

    }

    @Override
    public <S extends Groups> Optional<S> findOne(Example<S> example) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends Groups> Page<S> findAll(Example<S> example, Pageable pageable) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends Groups> long count(Example<S> example) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public <S extends Groups> boolean exists(Example<S> example) {
        // TODO Auto-generated method stub
        return false;
    }

}
