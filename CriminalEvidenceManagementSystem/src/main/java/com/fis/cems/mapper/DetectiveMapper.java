package com.fis.cems.mapper;

import com.fis.cems.model.CriminalCase;
import com.fis.cems.model.Detective;
import com.fis.cems.model.Evidence;
import com.fis.cems.model.Storage;
import com.fis.cems.model.enums.EmploymentStatus;
import com.fis.cems.model.enums.Rank;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DetectiveMapper implements IMapper<Detective> {

    private static final Logger LOGGER = LoggerFactory.getLogger(DetectiveMapper.class);

    @Override
    public Detective mapRow(ResultSet resultSet) {
        Detective detective = new Detective();

        try {
            detective.setId(resultSet.getLong("id"));
            detective.setVersion(resultSet.getInt("version"));
            detective.setCreatedAt(resultSet.getTimestamp("created_at").toLocalDateTime());
            detective.setModifiedAt(resultSet.getTimestamp("modified_at").toLocalDateTime());

            detective.setUsername(resultSet.getString("username"));
            detective.setFirstName(resultSet.getString("first_name"));
            detective.setLastName(resultSet.getString("last_name"));
            detective.setPassword(resultSet.getString("password"));
            detective.setHiringDate(resultSet.getTimestamp("hiring_date").toLocalDateTime());
            detective.setBadgeNumber(resultSet.getString("badge_number"));
            detective.setRank(Rank.valueOf(resultSet.getString("rank")));
            detective.setArmed(resultSet.getBoolean("armed"));
            detective.setStatus(EmploymentStatus.valueOf(resultSet.getString("status")));

            return detective;

        } catch (SQLException ex) {
            LOGGER.error("Can not map data from ResultSet to Detective: {}", ex.getMessage(), ex);
            return null;
        }
    }
}
