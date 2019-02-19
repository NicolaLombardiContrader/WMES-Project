package wmes.main;

import java.util.Properties;
import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionSingleton {


    private static Connection connection = null;


    private ConnectionSingleton() {
    }


    public static Connection getInstance() {
        if (connection == null) {
            try {
               
                /* 
                 
                Properties properties = new Properties();
                InputStream inputStream = new FileInputStream("config.properties");
                properties.load(inputStream);
                String vendor = properties.getProperty("db.vendor");
                String driver = properties.getProperty("db.driver");
                String host = properties.getProperty("db.host");
                String port = properties.getProperty("db.port");
                String dbName = properties.getProperty("db.name");
                String username = properties.getProperty("db.username");
                String password = properties.getProperty("db.password");
                String jdbcAdditionalParams=properties.getProperty("db.jdbc_params");
                */
                //Class c = Class.forName(driver);
                
                Properties properties = new Properties();
                String vendor="mysql";
                String driver="com.mysql.cj.jdbc.Driver";
                String host="127.0.0.1";
                String port="3306";
                String dbName="wms";
                String username="root";
                String password ="root";
                String jdbcAdditionalParams="useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
                
    			Class c = Class.forName(driver);
    			//System.out.println("Ho caricato: " + c.getName());
                String url = "jdbc:" + vendor + "://" + host + ":" + port + "/" + dbName+"?"+jdbcAdditionalParams;
    			connection = (Connection) DriverManager.getConnection(url, username, password);

                //DriverManagerDataSource dataSource = new DriverManagerDataSource(myUrl, username, password);
                //dataSource.setDriverClassName(driver);
                //connection = dataSource.getConnection();
            
            } catch (Exception e) {
                GestoreEccezioni.getInstance().gestisciEccezione(e);
            }
        }
        return connection;
    }

}
