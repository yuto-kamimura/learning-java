package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class DBTest {
    public static void main(String[] args) {
        // データベース接続情報
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "postgres";

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // データベースに接続
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");

            // ステートメントの作成
            stmt = conn.createStatement();

            // クエリの実行
            String sql = "SELECT user_id, username, email FROM Users";
            rs = stmt.executeQuery(sql);

            // 結果セットの処理
            while (rs.next()) {
                int userId = rs.getInt("user_id");
                String username = rs.getString("username");
                String email = rs.getString("email");

                System.out.printf("ID: %d, Username: %s, Email: %s%n", userId, username, email);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            // リソースの解放
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
