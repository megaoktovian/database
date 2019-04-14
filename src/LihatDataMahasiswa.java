	
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class LihatDataMahasiswa extends JFrame {

    String[][] data = new String[30][3];
    String[] kolom = {"Nama", "Matkul", "Nilai"};
    JTable tabel;
    JScrollPane scrollPane;
    JButton bBalik,bDelete;
    JPanel panelTombol;
    String DBurl = "jdbc:mysql://localhost/praktikum";
    String DBusername = "root";
    String DBpassword = "";
    Connection koneksi;
    Statement statement;            //qwery
    ResultSet resultSet;

    public LihatDataMahasiswa() {
        setTitle("Data Mahasiswa!");
      
        try {
            Class.forName("com.mysql.jdbc.Driver");
            koneksi = DriverManager.getConnection(DBurl,
                      DBusername, DBpassword);
            statement = koneksi.createStatement();
            String sql = "select * from mahasiswa "; //*==semua
            resultSet = statement.executeQuery(sql); //dimasukkan semua result
            int p = 0;
            while (resultSet.next()) {
                data[p][0] = resultSet.getString("Nama");
                data[p][1] = resultSet.getString("Matkul");
                data[p][2] = resultSet.getString("Nilai");
                p++;
            }
            statement.close();
            koneksi.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data Gagal Ditampilkan!", "Hasil", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Driver Tidak Ditemukan!", "Hasil", JOptionPane.ERROR_MESSAGE);
        }
        tabel = new JTable(data, kolom);
        scrollPane = new JScrollPane(tabel);

        setLayout(new FlowLayout());
        add(scrollPane);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        bBalik = new JButton ("BALIK");
        bDelete = new JButton ("DELETE");
        
        panelTombol = new JPanel(new FlowLayout());
        setLayout(new BorderLayout());
        add(panelTombol, BorderLayout.PAGE_END);
        panelTombol.add(bDelete);
        add(panelTombol, BorderLayout.PAGE_END);
        panelTombol.add(bBalik);
        setVisible(true);
        
        bBalik.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new Menu();
               dispose();
            }
        });
        bDelete.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
             try{
             koneksi = DriverManager.getConnection(DBurl,DBusername,DBpassword);
             statement = koneksi.createStatement();
             String query = "delete from mahasiswa";
             PreparedStatement ps = koneksi.prepareStatement(query);
             ps.executeUpdate();
             statement.close();
             koneksi.close();
           }catch(Exception ex){
           }
           new Menu();
           dispose();
           }});
    }     
    public static void main(String[] args) {
        new LihatDataMahasiswa();
    }
}
