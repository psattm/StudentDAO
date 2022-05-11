package per.hrj.dao.connection;

import sun.security.ec.point.ProjectivePoint;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DataBaseConnection {
    private String driverClassName;
    private String url;
    private String username;
    private String password;
    private Connection conn = null;

    //������
    public DataBaseConnection() {
        try {
            InputStream inputStream = DataBaseConnection.class.getClassLoader().getResourceAsStream("datasource.properties");
            Properties properties = new Properties();
            properties.load(inputStream);
            driverClassName = properties.getProperty("driverClassName");
            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");
            Class.forName(driverClassName);
            conn = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
        }
    }

    //�������
    public Connection getConnection() {
        return this.conn;
    }

    //�ر�����
    public void close() throws SQLException {
        this.conn.close();
    }
} 
