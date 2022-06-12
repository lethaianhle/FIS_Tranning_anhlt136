package com.fis.cems.mapper;

import com.fis.cems.model.CriminalCase;
import com.fis.cems.model.Detective;
import com.fis.cems.model.Evidence;
import com.fis.cems.model.enums.CaseStatus;
import com.fis.cems.model.enums.CaseType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

public class CriminalCaseMapper implements IMapper<CriminalCase> {
    private static final Logger LOGGER = LoggerFactory.getLogger(CriminalCaseMapper.class);
    @Override
    public CriminalCase mapRow(ResultSet resultSet) {
        CriminalCase criminalCase = new CriminalCase();
        try {
            criminalCase.setId(resultSet.getLong("id"));
            criminalCase.setVersion(resultSet.getInt("version"));
            criminalCase.setCreatedAt(resultSet.getTimestamp("created_at").toLocalDateTime());
            criminalCase.setModifiedAt(resultSet.getTimestamp("modified_at").toLocalDateTime());
            criminalCase.setNumber(resultSet.getString("number"));
            criminalCase.setType(CaseType.valueOf(resultSet.getString("type")));
            criminalCase.setShortDescription(resultSet.getString("short_description"));
            criminalCase.setDetailedDescription(resultSet.getString("detailed_description"));
            criminalCase.setStatus(CaseStatus.valueOf(resultSet.getString("status")));
            criminalCase.setNotes(resultSet.getString("notes"));
            // continue...

            return criminalCase;
        } catch (SQLException ex) {
            LOGGER.error("Can not map data from ResultSet to CriminalCase!");
            ex.printStackTrace();
            return null;
        }

    }
}
