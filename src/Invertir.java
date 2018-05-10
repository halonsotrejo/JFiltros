import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import javax.swing.JPanel;

/**
 *
 * @author Trejo
 */

public class Invertir extends Canvas{

    private BufferedImage bi;
    private BufferedImage foto;
    private int r,g,b;
    private Color color;
    private ImageObserver rootPane;

    public Invertir(){}

    public void SetInvertir(Image im){
        bi = new BufferedImage(im.getWidth(null),im.getHeight(null),BufferedImage.TYPE_INT_RGB);
        this.foto = bi;
        for(int i = 0; i < foto.getWidth(); i++){
            for(int j = 0; j < foto.getHeight(); j++){
                //se obtiene el color del pixel
                color = new Color(foto.getRGB(i,j));
                //se extraen los valores RGB
                r = color.getRed();
                g = color.getGreen();
                b = color.getBlue();
                //se coloca en la nueva imagen con los valores invertidos
                foto.setRGB(i, j, new Color(255-r,255-g,255-b).getRGB());
            }
        }
    }
    public BufferedImage getFoto(){
        return this.foto;
    }
    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.drawImage(foto,0,0,rootPane);
    }
}
