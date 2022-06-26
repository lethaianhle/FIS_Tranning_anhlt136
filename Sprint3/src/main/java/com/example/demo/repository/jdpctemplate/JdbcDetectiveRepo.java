package com.example.demo.repository.jdpctemplate;

import com.example.demo.model.enums.Rank;
import com.example.demo.model.Detective;
import com.example.demo.repository.jdpctemplate.mapper.DetectiveRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

//@Transactional
@Repository
public class JdbcDetectiveRepo implements DetectiveRepo {

    private RowMapper<Detective> rowMapper = new DetectiveRowMapper();

     JdbcTemplate jdbcTemplate;

    public JdbcDetectiveRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate=jdbcTemplate;
    }

    @Override
    public List<Detective> findAll() {
        String sql = "SELECT * FROM detective";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public Optional<Detective> findByBadgeNumber(String badgeNumber) {
        String sql = "SELECT * from detective where badge_number= ?";
        Detective detective = jdbcTemplate.queryForObject(sql, rowMapper, badgeNumber);
        return detective == null ? Optional.empty() : Optional.of(detective);
    }

    @Override
    public List<Detective> findByRank(Rank rank) {
        String sql = "SELECT * FROM detective WHERE rank = ?";
        return jdbcTemplate.query(sql, rowMapper, rank);
    }

    @Override
    public void save(Detective detective) {
        jdbcTemplate.update(
                "INSERT INTO detective(id, badge_number, rank, armed, status, person_id) values(?,?,?,?,?,?)",
                detective.getId(),
                detective.getBadgeNumber(),
                detective.getRank(),
                detective.getStatus(),
                detective.getPerson().getId()
        );
    }

    @Override
    public void delete(Detective detective) {
        jdbcTemplate.update("DELETE FROM detective WHERE id = ?", detective.getId());
    }

    @Override
    public Detective update(Detective detective) {
        jdbcTemplate.update(
                "INSERT INTO detective(id, badge_number, rank, armed, status, person_id) values(?,?,?,?,?,?)",
                detective.getId(),
                detective.getBadgeNumber(),
                detective.getRank(),
                detective.getStatus(),
                detective.getPerson().getId()
        );

        return findById(detective.getId()).orElse(null);
    }

    @Override
    public int deleteById(Long id) {
        return jdbcTemplate.update("DELETE FROM detective WHERE id =? ", id);
    }

    @Override
    public Optional<Detective> findById(Long id) {
        String sql = "SELECT d.id, d.badge_number, d.rank, d.armed, d.status, d.person_id, " +
                     "p.username, p.first_name, p.last_name, p.hiring_date "+
                     "FROM detective d, person p WHERE d.id= ? and d.person_id = p.id";
        return Optional.of(jdbcTemplate.queryForObject(sql, rowMapper, id));
    }
}
