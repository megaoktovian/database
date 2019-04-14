import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class InputDataMahasiswa extends JFrame {
    
    JLabel lNama, lMatkul, lNilai;
    JTextField tfNama, tfMatkul, tfNilai;
    JButton bSimpan,bBalik;
    JPanel panelForm, panelTombol;
    String DBurl = "jdbc:mysql://localhost/praktikum";
    String DBusername = "root";
    String DBpassword = "";
    Connection koneksi;
    Statement statement;
    
    public InputDataMahasiswa() {
        setTitle("Input Data");
        setSize(400, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        
        lNama = new JLabel("Nama");
        lMatkul = new JLabel("Matkul");
        lNilai = new JLabel("Nilai");
        tfNama = new JTextField(9);
        tfMatkul = new JTextField(50);
        tfNilai = new JTextField(50);
        bSimpan = new JButton("Input");
        bBalik = new JButton("Balik");
        panelForm = new JPanel(new GridLayout(3, 2));
        panelTombol = new JPanel(new FlowLayout());
        
        setLayout(new BorderLayout());
        add(panelForm, BorderLayout.CENTER);
        panelForm.add(lNama);
        panelForm.add(tfNama);
        panelForm.add(lMatkul);
        panelForm.add(tfMatkul);
        panelForm.add(lNilai);
        panelForm.add(tfNilai);
        
        add(panelTombol, BorderLayout.AFTER_LAST_LINE);
        panelTombol.add(bSimpan);
        
        add(panelTombol, BorderLayout.AFTER_LAST_LINE);
        panelTombol.add(bBalik);
        
        bSimpan.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                masukkanData();
            }          }); 
        bBalik.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               new Menu();
               dispose();
            }});
    }
    
    
    public void masukkanData() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            koneksi = DriverManager.getConnection(DBurl,
                      DBusername, DBpassword);
            statement = koneksi.createStatement();
            statement.executeUpdate("insert into mahasiswa values('"+ tfNama.getText() + "','" + 
                      tfMatkul.getText() + "','" 
                      + tfNilai.getText() + "')");
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan!", "Hasil",JOptionPane.INFORMATION_MESSAGE);            
            statement.close();
            koneksi.close();
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, ex/*"Data Gagal Disimpan!", "Hasil", JOptionPane.ERROR_MESSAGE*/);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex/*"Driver Tidak Ditemukan!", "Hasil", JOptionPane.ERROR_MESSAGE*/);
        }
    }
    
    public static void main(String[] args) {
        new InputDataMahasiswa();
    }
}
