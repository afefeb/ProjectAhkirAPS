import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class UserDAO implements DaoInterface<User> {

    @Override
    public int addData(User data) {
        int result = 0;

        try {
            String query = "insert into user(username, password) values(?,?)";
            PreparedStatement ps = MyJDBC.getConnection().prepareStatement(query);
            ps.setString(1,data.getNama());
            ps.setString(2,data.getPassword());
            result = ps.executeUpdate();
        }
        catch (SQLException ex){
            System.out.println(ex.getMessage());
        }



        return 0;
    }

    @Override
    public int delData(User data) {
        int result = 0;
        try{
            String query = "delete from user where username=?";
            PreparedStatement ps = MyJDBC.getConnection().prepareStatement(query);
            ps.setString(1,data.getNama());
            result = ps.executeUpdate();
        }
        catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        return 0;
    }

    @Override
    public int updateData(User data) {
        int result = 0;
        try {
            String query = "update user set password = ? where username = ?";
            PreparedStatement ps = MyJDBC.getConnection().prepareStatement(query);
            ps.setString(1, data.getPassword());
            ps.setString(2, data.getNama());
            result = ps.executeUpdate();

        }
        catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        return 0;
    }

        @Override
    public int showGambar() {
        int result = 0;
        try {

            String query = "SELECT image FROM picture WHERE image_id = ?";
            PreparedStatement ps = MyJDBC.getConnection().prepareStatement(query);
        }
        catch (SQLException ex){
            System.out.println(ex.getMessage());
        }


        return 0;
    }

    @Override
    public ObservableList<User> showData() {
        ObservableList<User> uList = FXCollections.observableArrayList();
        try {
            String query = "SELECT * FROM user;";
            PreparedStatement ps = MyJDBC.getConnection().prepareStatement(query);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                String username = res.getString("username");
                String password = res.getString("password");
                User s = new User(username, password);
                uList.add(s);
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return uList;
    }

}
