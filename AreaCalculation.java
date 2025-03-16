import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class AreaCalculation extends JFrame implements ActionListener {
    private JButton button, button2;

    public static void main(String[] args) {
        AreaCalculation frame = new AreaCalculation();
        frame.setSize(800,800);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.createGUI();
        frame.setVisible(true);
    }

    private void createGUI(){
        Container window = getContentPane();
        window.setLayout(new FlowLayout());
        button = new JButton("press me");
        button2 = new JButton("press button2");
        window.add(button);
        window.add(button2);;
        button.addActionListener(this);
        button2.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event){
        int Area;
        int length;
        int width;
        length = 20;
        width = 10;
        Area = length * width;
        JOptionPane.showMessageDialog(null, "area is: " + Area);
    };
}
