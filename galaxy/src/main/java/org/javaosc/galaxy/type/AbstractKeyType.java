
package org.javaosc.galaxy.type;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.javaosc.galaxy.jdbc.core.ResultType;

/**
 * 
 * @description
 * @author Dylan Tao
 * @date 2014-09-09
 * Copyright 2014 Javaosc Team. All Rights Reserved.
 */
public abstract class AbstractKeyType<K, V> implements ResultType<Map<K, V>> {

    @Override
    public Map<K, V> handle(ResultSet rs) throws SQLException {
        Map<K, V> result = createMap();
        while (rs.next()) {
            result.put(createKey(rs), createRow(rs));
        }
        return result;
    }

    protected Map<K, V> createMap() {
        return new HashMap<K, V>();
    }
    
    protected abstract K createKey(ResultSet rs) throws SQLException;
    
    protected abstract V createRow(ResultSet rs) throws SQLException;

}
