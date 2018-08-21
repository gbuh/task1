package com.epam.task1.app.repository.impl;

import com.epam.task1.app.entity.User;
import com.epam.task1.app.exception.UserNotFoundException;
import com.epam.task1.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class H2UserRepository implements UserRepository {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    private static final class UserMapper implements RowMapper<User> {

        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setFirstName(rs.getString("fist_name"));
            user.setLastName(rs.getString("last_name"));
            user.setEmail(rs.getString("email"));
            user.setPhoneNumber(rs.getString("phone_number"));
            user.setVersion(rs.getInt("version"));
            user.setCreateDate(rs.getDate("create_date").toLocalDate());
            user.setUpdateDate(rs.getDate("update_date").toLocalDate());
            user.setCreatedUser(rs.getString("created_user"));
            user.setUpdatedUser(rs.getString("updated_user"));
            return user;
        }
    }

    @Override
    public User getById(Long id) {
        String query = "SELECT * FROM users WHERE id =:id";
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        try {
            return jdbcTemplate.queryForObject(query, params, new UserMapper());
        } catch (DataAccessException e) {
            throw new UserNotFoundException(id, e);
        }
    }

    @Override
    public List<User> findAll() {
        Map<String, Object> params = new HashMap<>();
        List<User> result = jdbcTemplate.query("SELECT * FROM users", params, new UserMapper());
        return result;
    }

    @Override
    public void delete(final Long id) {
        final String query = "DELETE FROM users WHERE id =:id";
        try {
            final Map<String, Long> params = new HashMap<>();
            params.put("id", id);
            jdbcTemplate.update(query, params);
        } catch (DataAccessException e) {
            throw new UserNotFoundException(id, e);
        }
    }

    @Override
    public void update(User user) {
        String query =
                "UPDATE users SET id = ?, first_name = ?, last_name = ?, email = ?, phone_number = ?, version = ?, create_date = ?, update_date = ?, created_user = ?, updated_user = ?";
        Map<String, Object> params = new HashMap<>();
        params.put("id", user.getId());
        params.put("first_name", user.getFirstName());
        params.put("last_name", user.getLastName());
        params.put("email", user.getEmail());
        params.put("phone_number", user.getPhoneNumber());
        params.put("version", user.getVersion());
        params.put("create_date", user.getCreateDate());
        params.put("update_date", user.getUpdateDate());
        params.put("created_user", user.getCreatedUser());
        params.put("updated_user", user.getUpdatedUser());
        jdbcTemplate.update(query, params);
    }

    @Override
    public void insert(User user) {
        String query =
                "INSERT INTO users VALUES (:id, :first_name, :last_name, :email, :phone_number, :version, :create_date, :update_date, :created_user, :updated_user";
        Map<String, Object> params = new HashMap<>();
        params.put("id", user.getId());
        params.put("first_name", user.getFirstName());
        params.put("last_name", user.getLastName());
        params.put("email", user.getEmail());
        params.put("phone_number", user.getPhoneNumber());
        params.put("version", user.getVersion());
        params.put("create_date", user.getCreateDate());
        params.put("update_date", user.getUpdateDate());
        params.put("created_user", user.getCreatedUser());
        params.put("updated_user", user.getUpdatedUser());
        jdbcTemplate.update(query, params);
    }
}
