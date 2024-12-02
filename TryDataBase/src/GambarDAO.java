import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GambarDAO {
    public Gambar getGambarById(int imageId) {
        Gambar gambar = null;
        String query = "SELECT id_image, image FROM picture WHERE id_image = ?";
        try (PreparedStatement ps = MyJDBC.getConnection().prepareStatement(query)) {
            ps.setInt(1, imageId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id_image");
                Blob blob = rs.getBlob("image");
                byte[] imageBytes = (blob != null) ? blob.getBytes(1, (int) blob.length()) : null;
                gambar = new Gambar(id, imageBytes);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gambar;
    }
}
