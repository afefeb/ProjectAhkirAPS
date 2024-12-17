package CRUD;

import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.embed.swing.SwingFXUtils;
import model.Barang;
import util.MySQLConnection;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.image.Image;

import javax.imageio.ImageIO;

public class CRUDUser implements CRUDInterface<Barang> {

    public int addData(Barang data) {
        int result = 0;

        if (data.getImage() != null) {
            try {
                // Mengonversi Image ke byte array
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                BufferedImage bufferedImage = SwingFXUtils.fromFXImage(data.getImage(), null);
                ImageIO.write(bufferedImage, "jpg", byteArrayOutputStream);
                InputStream inputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());

                // Memasukkan data ke database
                String query = "INSERT INTO barang (nama_barang, deskripsi, lokasi, waktu_kehilangan, image) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement ps = MySQLConnection.getConnection().prepareStatement(query);
                ps.setString(1, data.getNama_barang());
                ps.setString(2, data.getDeskripsi());
                ps.setString(3, data.getLokasi());
                ps.setDate(4, Date.valueOf(data.getWaktu_kehilangan()));
                ps.setBinaryStream(5, inputStream, byteArrayOutputStream.size());

                ps.executeUpdate();
                result = 1;
            } catch (SQLException | IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public int updateData(Barang data) {
        int result = 0;
        if (data.getImage() != null) {
            try {
                // Mengonversi Image ke byte array
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                BufferedImage bufferedImage = SwingFXUtils.fromFXImage(data.getImage(), null);
                ImageIO.write(bufferedImage, "jpg", byteArrayOutputStream);
                InputStream inputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());

                // Memasukkan data ke database
                String query = "UPDATE barang SET nama_barang = ?, deskripsi = ?, lokasi = ?, waktu_kehilangan = ?, image = ? WHERE id_barang = ?";
                PreparedStatement ps = MySQLConnection.getConnection().prepareStatement(query);
                ps.setString(1, data.getNama_barang());
                ps.setString(2, data.getDeskripsi());
                ps.setString(3, data.getLokasi());
                ps.setDate(4, Date.valueOf(data.getWaktu_kehilangan()));
                ps.setBinaryStream(5, inputStream, byteArrayOutputStream.size());
                ps.setInt(6, data.getId_barang());

                ps.executeUpdate();
                result = 1;
            } catch (SQLException | IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public int delData(Barang data) {
        int result = 0;
        try {
            String query = "delete from barang where id_barang=?";
            PreparedStatement ps = MySQLConnection.getConnection().prepareStatement(query);
            ps.setInt(1, data.getId_barang());
            result = ps.executeUpdate();
        }
        catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        return result;
    }

    @Override
    public List<Barang> showData() {
        List<Barang> bList = new ArrayList<>();
        try{
            String query = "Select id_barang, nama_barang,deskripsi,lokasi,waktu_kehilangan,status,image FROM Barang;";
            PreparedStatement ps = MySQLConnection.getConnection().prepareStatement(query);
            ResultSet res =ps.executeQuery();
            while (res.next()){
                String id_barang = res.getString("id_barang");
                String nama_barang = res.getString("nama_barang");
                String deskripsi = res.getString("deskripsi");
                String lokasi = res.getString("lokasi");
                Date sqlDate = res.getDate("waktu_kehilangan");
                LocalDate waktu_kehilangan = sqlDate.toLocalDate();
                Blob image = res.getBlob("image");
                Image imageBarang = null;
                // status blom

                if(image != null){
                    byte[] imageBytes = image.getBytes(1,(int)image.length());
                    ByteArrayInputStream inputStream = new ByteArrayInputStream(imageBytes);
                    imageBarang = new Image(inputStream);
                }
                Barang barang = new Barang(nama_barang, deskripsi, lokasi, waktu_kehilangan, imageBarang);
                barang.setId_barang(Integer.parseInt(id_barang));
                bList.add(barang);

            }

        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        return bList;
    }
}
