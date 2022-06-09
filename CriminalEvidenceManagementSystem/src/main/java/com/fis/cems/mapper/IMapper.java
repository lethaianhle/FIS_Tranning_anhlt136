package com.fis.cems.mapper;

import java.sql.ResultSet;

public interface IMapper<T> {
    T mapRow(ResultSet resultSet);
}
