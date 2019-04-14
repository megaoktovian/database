	
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Menu extends JFrame{
   JLabel menu = new JLabel("MENU");
    
   JRadioButton rbInput = new JRadioButton(" Input Data ");
   JRadioButton rbLihat = new JRadioButton(" Lihat Data ");
   
   JButton bExit= new JButton("Exit");
   JButton bPilih=new JButton("PILIH");
   
   JPanel panelTombol;
   
  public Menu(){
      setTitle("MENU");
      setSize(400, 200);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setVisible(true);


      ButtonGroup group = new ButtonGroup();
      group.add(rbInput);
      group.add(rbLihat);
      
      setLayout(null);
      add(menu);
      add(rbInput);
      add(rbLihat);
      add(bExit);
      add(bPilih);
      
      menu.setBounds(160, 5, 100, 30);
      rbInput.setBounds(10, 15, 100, 30);
      rbLihat.setBounds(10, 45, 100, 30);
      bExit.setBounds(100, 95, 80, 30);
      bPilih.setBounds(180, 95, 80, 30);
      
      bExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }});
      bPilih.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              if(rbInput.isSelected()) {
                  new InputDataMahasiswa().setVisible(true);
                  dispose();
              }
              if(rbLihat.isSelected()) {
                  new LihatDataMahasiswa().setVisible(true);
                  dispose();
              }
          }
      });
} 
    public static void main(String[] args) {
        new Menu();
    }
}
