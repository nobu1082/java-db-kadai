package kadai_010;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbInsert_1 {
    public static void main(String[] args) {

        Connection con = null;
        PreparedStatement statement = null;

        // ユーザーリスト
        String[][] userList = {
            { "1","侍健太", "65" ,"90" },
            { "2","刀沢彩香", "85","70" },
            { "3","戦国広志", "75","85" },
            { "4","武士山美咲", "75","95" },
            { "5","武者小路勇気", "0","0" }
        };

        try {
            // データベースに接続
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost/challenge_java",
                "root",
                "0938"
            );

            System.out.println("データベース接続成功");

            // SQLクエリを準備
            String sql = "INSERT INTO scores (id, name,score_math,score_english) VALUES (?, ? , ? ,?);";
            statement = con.prepareStatement(sql);

            // リストの1行目から順番に読み込む
            int rowCnt = 0;
            for( int i = 0; i < 5; i++ ) {
                // SQLクエリの「?」部分をリストのデータに置き換え
                statement.setString(1, userList[i][0]); 
                statement.setString(2, userList[i][1]); 
                statement.setString(3, userList[i][2]);
                statement.setString(4, userList[i][3]);
             
                // SQLクエリを実行（DBMSに送信）
                System.out.println("レコード追加:" + statement.toString() );
                rowCnt = statement.executeUpdate();
                System.out.println( rowCnt + "件のレコードが追加されました");
            }
        } catch(SQLException e) {
            System.out.println("エラー発生：" + e.getMessage());
        } finally {
            // 使用したオブジェクトを解放
            if( statement != null ) {
                try { statement.close(); } catch(SQLException ignore) {}
            }
            if( con != null ) {
                try { con.close(); } catch(SQLException ignore) {}
            }
        }
    }
}
