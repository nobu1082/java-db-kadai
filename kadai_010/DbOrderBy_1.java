package kadai_010;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DbOrderBy_1 {
    public static void main(String[] args) {

        Scanner scanner = null;
        Connection con = null;
        Statement statement = null;

        try {
            System.out.println("0(昇順)か1(降順)を入力してください：");
            scanner = new Scanner(System.in); // 入力待ち

            //入力内容に応じて並べ替え方向を決定
            String order = switch( scanner.nextInt() ) {
                case 0 -> "ASC;";
                case 1 -> "DESC;";
                default -> "ASC;"; // デフォルトは昇順扱い
            };

            // データベースに接続
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost/challenge_java",
                "root",
                "0938"
            );

            System.out.println("データベース接続成功");

            // SQLクエリを準備
            statement = con.createStatement();
            String sql = "SELECT * FROM scores ORDER BY score_math DESC ,score_english DESC";

            // SQLクエリを実行（DBMSに送信）
            System.out.println("データ取得を実行：" + sql);
            ResultSet result = statement.executeQuery(sql);

            // SQLクエリの実行結果を抽出
            while(result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");
                int score_math = result.getInt("score_math");
                int score_english = result.getInt("score_english");
                System.out.println(result.getRow() + "件目：id=" + id
                                   + "／name=" + name + "／score_math=" + score_math + "/score_english" + score_english );
            }
        } catch(InputMismatchException e) {
            System.out.println("入力が正しくありません");
        } catch(SQLException e) {
            System.out.println("エラー発生：" + e.getMessage());
        } finally {
            // 使用したオブジェクトを解放
            if( scanner != null ) {
                scanner.close();
            }
            if( statement != null ) {
                try { statement.close(); } catch(SQLException ignore) {}
            }
            if( con != null ) {
                try { con.close(); } catch(SQLException ignore) {}
            }
        }
    }
}
