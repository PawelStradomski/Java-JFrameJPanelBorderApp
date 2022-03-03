
package jframejpanelkrawedzie;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

/**
 *
 * @author pawelstradomski
 */
public class JFrameJPanelKrawedzie extends JFrame
{

    public JFrameJPanelKrawedzie()
    {
        this.setTitle("Krawedzie ramek");
        this.setBounds(600, 300, 300, 200);
        this.setDefaultCloseOperation(3);
        initComponent();  
    }
    
    public void initComponent()
    {
        this.getContentPane().setLayout(new GridLayout(2, 1));      //2-wiersze, 1-kolumna
        this.getContentPane().add(panelRadio);                      //inaczej: this.add(panel);
        this.getContentPane().add(panelKrawedzi);
        
                                                                    //panel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));//ustawia krawedzie panela, lub inny sp:
        panelRadio.setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED), "Krawedzie", TitledBorder.RIGHT, TitledBorder.BOTTOM));
        
        budujButton("CreateEdchedBorder", BorderFactory.createEtchedBorder());
        budujButton("CreatedLoweredBevelBorder", BorderFactory.createLoweredBevelBorder());
    }
    
    public void budujButton(final String nazwa, final Border br)    //dla klas wewnetrznych zmienne musza byc final
    {
        JRadioButton przelacznik = new JRadioButton(nazwa);
        przelacznik.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelKrawedzi.setBorder(BorderFactory.createTitledBorder(br, nazwa));
            }
        });
        panelRadio.add(przelacznik);
        grupaRadio.add(przelacznik);
    }
    private JPanel panelRadio = new JPanel();
    private JPanel panelKrawedzi = new JPanel();
    private ButtonGroup grupaRadio = new ButtonGroup();

    
    public static void main(String[] args) {
        new JFrameJPanelKrawedzie().setVisible(true);
    }
    
}
