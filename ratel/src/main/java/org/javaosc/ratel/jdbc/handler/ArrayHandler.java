
package org.javaosc.ratel.jdbc.handler;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.javaosc.ratel.jdbc.core.ResultType;
import org.javaosc.ratel.jdbc.core.RowConvert;
import org.javaosc.ratel.jdbc.core.RowConvertHandler;

/**
 * 
 * @description
 * @author Dylan Tao
 * @date 2014-09-09
 * Copyright 2014 Javaosc Team. All Rights Reserved.
 */
public class ArrayHandler implements ResultType<Object[]> {

    
    static final RowConvert ROW_PROCESSOR = new RowConvertHandler();

    
    private static final Object[] EMPTY_ARRAY = new Object[0];

    
    private final RowConvert convert;

    
    public ArrayHandler() {
        this(ROW_PROCESSOR);
    }

    
    public ArrayHandler(RowConvert convert) {
        super();
        this.convert = convert;
    }

    
    @Override
    public Object[] handle(ResultSet rs) throws SQLException {
        return rs.next() ? this.convert.toArray(rs) : EMPTY_ARRAY;
    }

}
