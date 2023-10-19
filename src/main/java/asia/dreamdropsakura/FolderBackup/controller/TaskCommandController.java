package asia.dreamdropsakura.FolderBackup.controller;

import asia.dreamdropsakura.FolderBackup.entity.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;

/**
 * 压缩任务前端控制器
 *
 * @author TheFairyTale
 * @since 2023-10-19
 */
@Slf4j
@RestController
@RequestMapping("/task")
public class TaskCommandController {

    @GetMapping("/test")
    public ResponseData test() {
        return ResponseData.ok("hello");

    }

    @GetMapping("/listAll")
    public ResponseData listAllTask() {
        Connection connection = null;
        String resultStr = "";

        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if (null == connection) return ResponseData.error("database connection cannot be open.");

        Boolean execute = false;
        try {
            Statement statement = connection.createStatement();
            // 1.先检查表是否存在及表内是否含数据
            PreparedStatement queryByIdStatement = connection.prepareStatement("select id, name, email, country, password from users where id = ?");
            queryByIdStatement.setInt(1, 1);
            ResultSet queryByIdResult = queryByIdStatement.executeQuery();
            if (queryByIdResult != null) {
                StringBuilder stringBuilder = new StringBuilder("------------------------------------------\n");
                stringBuilder.append("# id | name | email | country | password #\n");
                while (queryByIdResult.next()) {
                    stringBuilder.append("------------------------------------------\n");
                    int id = queryByIdResult.getInt("id");
                    String name = queryByIdResult.getString("name");
                    String email = queryByIdResult.getString("email");
                    String country = queryByIdResult.getString("country");
                    String password = queryByIdResult.getString("password");
                    stringBuilder.append("# "+id+" | "+name+" | "+email+" | "+country+" | "+password+" #\n");
                }
                stringBuilder.append("------------------------------------------\n");
                resultStr = stringBuilder.toString();
            } else {
                execute = statement.execute("create table users (" +
                        "  id  int Not null primary key," +
                        "  name varchar(20) Not null," +
                        "  email varchar(20)," +
                        "  country varchar(20)," +
                        "  password varchar(20)" +
                        "  );");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ResponseData.ok(execute.toString(), resultStr);
    }
}
