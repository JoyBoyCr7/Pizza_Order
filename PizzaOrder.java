import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PizzaOrder extends JFrame{

    JPanel radioPanel, checkBoxPanel, orderPanel, titlePanel, receiptPanel, buttenPanel;
    JLabel titleLabel;

    ButtonGroup pizzaSizes;
    JRadioButton radio1, radio2, radio3;
    JTextArea receipt;

    public static void main(String[] args) {
        PizzaOrder frame = new PizzaOrder();
        frame.setSize(800,800);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.createGUI();
        frame.setVisible(true);
    }

    private void createGUI(){
        // Container window = getContentPane();
        // window.setLayout(new FlowLayout());
        setUpTitle();
        setUpCheckbox();
        setUpRadio();
        
        SetUpReceipt();
        setUpSubmit();
        
    }

    public void setUpTitle(){
        titlePanel = new JPanel(new FlowLayout());
        titleLabel = new JLabel("Ronard's Pizzaria");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titlePanel.add(titleLabel);
        getContentPane().add(titleLabel, BorderLayout.NORTH);
    }

    public void setUpCheckbox(){
        checkBoxPanel = new JPanel(new FlowLayout());
        JCheckBox ch1 = new JCheckBox("Extra cheese");
        JCheckBox ch2 = new JCheckBox("beef");
        JCheckBox ch3 = new JCheckBox("peporni");
        JCheckBox ch4 = new JCheckBox("sasage");
        checkBoxPanel.add(ch1);
        checkBoxPanel.add(ch2);
        checkBoxPanel.add(ch3);
        checkBoxPanel.add(ch4);

        getContentPane().add(checkBoxPanel, BorderLayout.WEST);
    }

    public void setUpRadio(){
        buttenPanel = new JPanel(new FlowLayout());
        // buttenPanel.setBackground(Color.WHITE);
        pizzaSizes = new ButtonGroup();

        radio1 = new JRadioButton("Small");
        radio2 = new JRadioButton("mideam");
        radio3 = new JRadioButton("large");

        pizzaSizes.add(radio1);
        pizzaSizes.add(radio2);
        pizzaSizes.add(radio3);

        buttenPanel.add(radio1);
        buttenPanel.add(radio2);
        buttenPanel.add(radio3);

        getContentPane().add(buttenPanel, BorderLayout.EAST);

    }

    public void SetUpReceipt(){
        receipt = new JTextArea(40,25);
        receiptPanel = new JPanel(new FlowLayout());
        receipt.setLineWrap(true);
        receipt.setWrapStyleWord(true);
        receiptPanel.add(receipt);

        getContentPane().add(receiptPanel,BorderLayout.CENTER);
    }

    public void setUpSubmit(){
        orderPanel = new JPanel(new FlowLayout());

        JButton orderButton = new JButton("Order");
        
        orderPanel.add(orderButton);

        getContentPane().add(orderPanel, BorderLayout.SOUTH);
    }
}