import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MysqlTest {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://127.0.0.1:3307/gateway?useUnicode=true&characterEncoding=utf8";
        String username = "root";
        String password = "000000";
        String driver = "com.mysql.cj.jdbc.Driver";

        Class.forName(driver);
        final Connection conn = DriverManager.getConnection(url, username, password);
        final PreparedStatement ps = conn.prepareStatement("select 'x'");
        final ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String x = rs.getString(1);
            System.out.println(x);
        }

        rs.close();
        ps.close();
        conn.close();
    }
}
