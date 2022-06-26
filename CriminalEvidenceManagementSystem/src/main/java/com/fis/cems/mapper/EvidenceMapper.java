package com.fis.cems.mapper;

import com.fis.cems.model.CriminalCase;
import com.fis.cems.model.Detective;
import com.fis.cems.model.Evidence;
import com.fis.cems.model.Storage;
import com.fis.cems.model.enums.CaseStatus;
import com.fis.cems.model.enums.CaseType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EvidenceMapper implements IMapper<Evidence> {

    private static final Logger LOGGER = LoggerFactory.getLogger(EvidenceMapper.class);

    @Override
    public Evidence mapRow(ResultSet resultSet) {
        Evidence evidence = new Evidence();

        try {
            evidence.setId(resultSet.getLong("id"));
            evidence.setVersion(resultSet.getInt("version"));
            evidence.setCreatedAt(resultSet.getTimestamp("created_at").toLocalDateTime());
            evidence.setModifiedAt(resultSet.getTimestamp("modified_at").toLocalDateTime());
            evidence.setNumber(resultSet.getString("number"));
            evidence.setItemName(resultSet.getString("item_name"));
            evidence.setArchived(resultSet.getBoolean("archived"));
            evidence.setNotes(resultSet.getString("notes"));

            CriminalCase criminalCase = new CriminalCase();
            criminalCase.setId(resultSet.getLong("criminal_case_id"));
            evidence.setCriminalCase(criminalCase);

            Storage storage = new Storage();
            storage.setId(resultSet.getLong("storage_id"));
            evidence.setStorage(storage);

            return evidence;

        } catch (SQLException ex) {
            LOGGER.error("Can not map data from ResultSet to Evidence: {}", ex.getMessage(), ex);
            return null;
        }
    }

}
