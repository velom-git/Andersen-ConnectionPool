import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;

public class ConPool {
    private static HikariDataSource hikariDataSource;
    static {
        try {
            hikariDataSource = new HikariDataSource();
            hikariDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
            hikariDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/BD?allowPublicKeyRetrieval=true&useSSL=false&verifyServerCertificate=false&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
            hikariDataSource.setUsername("admin");
            hikariDataSource.setPassword("password");
            hikariDataSource.setMinimumIdle(5);  //минимум свободных соединений
            hikariDataSource.setMaximumPoolSize(10); // максимум соединений
            hikariDataSource.setLoginTimeout(10);  //простой в секундах
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DataSource getDataSource() {
        return hikariDataSource;
    }
}
