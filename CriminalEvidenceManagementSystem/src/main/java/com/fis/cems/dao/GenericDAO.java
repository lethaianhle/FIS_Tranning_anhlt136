package com.fis.cems.dao;

import com.fis.cems.mapper.IMapper;

import java.util.List;

public interface GenericDAO<T> {
    <T> List<T> query(String sql, IMapper<T> rowMapper, Object... parameters);

	<T> T get(long id);

    void update(String sql, Object... parameters);

    Long create(String sql, Object... parameters);

    int count(String sql, Object... parameters);
}
