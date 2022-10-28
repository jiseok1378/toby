package com.tody.util.connection;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionMaker {
    Connection makeNewConnection() throws SQLException;
}
