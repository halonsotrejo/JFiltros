/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package graficacion_filtros;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.*;
/**
 *
 * @author Trejo
 */

public class Graficacion_filtros extends JFrame implements ActionListener{

    private JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9;
    private JLabel l1;
    private JButton b1;
    private JMenuItem salir;
    private JMenuItem buscar;


    Image img;
    BufferedImage img2;
    Image nuevaImagen;
    File file;
    int[][] matriz;

    //JPanel Ppanel = new JPanel();
    ImagenPanel Ipanel = new ImagenPanel();
    Invertir imge = new Invertir();

    public Graficacion_filtros(){
        //Crear barra de Menu
        JMenuBar Menu = new JMenuBar();
        setJMenuBar(Menu);
        JMenu archivo = new JMenu();
        archivo.setText("Archivo");
        Menu.add(archivo);

        buscar = new JMenuItem();
        buscar.setText("Abrir");
        buscar.addActionListener(this);
        archivo.add(buscar);

        salir = new JMenuItem();
        salir.setText("Salir");
        salir.addActionListener(this);
        salir.setMnemonic('s');
        archivo.add(salir);

        l1 = new JLabel();
        getContentPane().setLayout(null);
        l1.setText("Ingrese los Valores");
        getContentPane().add(l1);
        l1.setBounds(10,0,200, 20);

        t1 = new JTextField();
        getContentPane().add(t1);
        t1.setBounds(0,30,40, 20);
        t2 = new JTextField();
        getContentPane().add(t2);
        t2.setBounds(40,30,40, 20);
        t3 = new JTextField();
        getContentPane().add(t3);
        t3.setBounds(80,30,40, 20);
        t4 = new JTextField();
        getContentPane().add(t4);
        t4.setBounds(0,50,40, 20);
        t5 = new JTextField();
        getContentPane().add(t5);
        t5.setBounds(40,50,40, 20);
        t6 = new JTextField();
        getContentPane().add(t6);
        t6.setBounds(80,50,40, 20);
        t7 = new JTextField();
        getContentPane().add(t7);
        t7.setBounds(0,70,40, 20);
        t8 = new JTextField();
        getContentPane().add(t8);
        t8.setBounds(40,70,40, 20);
        t9 = new JTextField();
        getContentPane().add(t9);
        t9.setBounds(80,70,40, 20);
        //Crear el boton
        b1 = new JButton();
        getContentPane().add(b1);
        b1.setText("Enter");
        b1.setMnemonic('E');
        b1.addActionListener(this);
        b1.setBounds(30,100,80, 20);

        Ipanel.setLayout(null);
        Ipanel.setBounds(150, 0, 430, 330);
        getContentPane().add(Ipanel);

        setSize(600,400);
        setTitle("Editar Imagenen");
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent evt){
        try{
            if(evt.getSource() == b1){
                // matriz = new int[3][3];
           /* matriz[0][0] =  Integer.parseInt(t1.getText());
            matriz[0][1] =  Integer.parseInt(t2.getText());
            matriz[0][2] =  Integer.parseInt(t3.getText());
            matriz[1][0] =  Integer.parseInt(t4.getText());
            matriz[1][1] =  Integer.parseInt(t5.getText());
            matriz[1][2] =  Integer.parseInt(t6.getText());
            matriz[2][0] =  Integer.parseInt(t7.getText());
            matriz[2][1] =  Integer.parseInt(t8.getText());
            matriz[2][2] =  Integer.parseInt(t9.getText());*/

                img = Ipanel.getImagen();
                imge.SetInvertir(img);
                imge.repaint();
            }
            ///////////////////////////////////////////////
            if(evt.getSource() == salir){
                System.exit(0);
            }
            ///////////////////////////////////////////////
            if(evt.getSource() == buscar){
                JFileChooser a = new JFileChooser();
                int resul = a.showOpenDialog(this);
                if(resul == JFileChooser.APPROVE_OPTION){
                    file = a.getSelectedFile();
                    Image imagen = Toolkit.getDefaultToolkit().getImage(file.getPath());
                    Ipanel.setImagen(imagen);
                    Ipanel.repaint();
                }
            }
        }catch(NumberFormatException  e){
            System.out.println("Error : "+e.getMessage());
        }
    }

    public static void main(String[] args) {
        Graficacion_filtros frame = new Graficacion_filtros();
    }
}
