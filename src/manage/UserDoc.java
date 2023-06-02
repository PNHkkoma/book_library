package manage;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDoc {
    public ArrayList<User> getAllUser() {
        ArrayList<User> users = new ArrayList<User>();
        Connection connection = ConnectionSQL.getConnection();
        String sql = "SELECT * FROM user";
        try {
            PreparedStatement preparedStatement = connection.prepareCall(sql);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getString("id"));
                user.setLevel(rs.getString("level"));
                user.setName(rs.getString("name"));
                user.setNameLogin(rs.getString("nameLogin"));
                user.setPassLogin(rs.getString("passLogin"));
                user.setBirthday((java.util.Date) rs.getDate("birthDay"));
                user.setPhonenumber(rs.getString("phoneNumber"));
                user.setEmail(rs.getString("email"));
                user.setCount(rs.getInt("count"));
                users.add(user);
            }
        } catch (Exception e) {
        }
        System.out.println(users);
        return users;
    }

    public void addUser(User user) {
        Connection connection = ConnectionSQL.getConnection();
        java.util.Date date = user.getBirthday();
        Date a = new Date(0);

        a.setTime(date.getTime());

        String sql = "INSERT INTO user VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getId());
            preparedStatement.setString(2, user.getLevel());
            preparedStatement.setString(3, user.getName());
            preparedStatement.setString(4, user.getNameLogin());
            preparedStatement.setString(5, user.getPassLogin());
            preparedStatement.setDate(6, a);
            preparedStatement.setString(7, user.getPhonenumber());
            preparedStatement.setString(8, user.getEmail());
            preparedStatement.setInt(9, user.getCount());
            int rs = preparedStatement.executeUpdate();

            System.out.println("da add");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateUser(User user) {
        Connection connection = ConnectionSQL.getConnection();

        java.util.Date date = user.getBirthday();
        Date a = new Date(0);
        a.setTime(date.getTime());

        String sql = "UPDATE user SET " +
                "level=?,name=?,nameLogin=?,passLogin=?,birthDay=?,phoneNumber=?,email=?,count=? where id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(9, user.getId());
            preparedStatement.setString(1, user.getLevel());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getNameLogin());
            preparedStatement.setString(4, user.getPassLogin());
            preparedStatement.setDate(5, a);
            preparedStatement.setString(6, user.getPhonenumber());
            preparedStatement.setString(7, user.getEmail());
            preparedStatement.setInt(8, user.getCount());
            int rs = preparedStatement.executeUpdate();

            System.out.println("da up");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(String id) {
        Connection connection = ConnectionSQL.getConnection();
        String sql = "DELETE FROM user WHERE id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);

            int rs = preparedStatement.executeUpdate();

            System.out.println("da xoa");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
