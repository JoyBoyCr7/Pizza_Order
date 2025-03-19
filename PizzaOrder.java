import java.awt.*;
import java.awt.event.*;
import java.util.EventListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javax.swing.*;

public class PizzaOrder extends JFrame implements ItemListener, ActionListener{

    JPanel radioPanel, checkBoxPanel, orderPanel, titlePanel, receiptPanel, buttenPanel, radioButtonsPanel;
    JLabel titleLabel;

    JCheckBox ch1, ch2, ch3, ch4, ch5, ch6;
    ButtonGroup pizzaSizes;
    JButton orderButton, clearButton;
    JRadioButton radio1, radio2, radio3;
    JTextArea receipt;

    double pizzaTotal = 0;
    boolean check1Chosen, check2Chosen, check3Chosen, check4Chosen, check5Chosen, check6Chosen, radio1Chosen, radio2Chosen, radio3Chosen;
    String outputText = "";
    // Image img;

    public static void main(String[] args) {
        PizzaOrder frame = new PizzaOrder();
        frame.setSize(1000,550);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.createGUI();
        frame.setVisible(true);
    }

    private void createGUI(){
        // Container window = getContentPane();
        // window.setLayout(new FlowLayout());
        pizzaTotal = 0;
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
        checkBoxPanel = new JPanel(new GridLayout(4,0));
        ch1 = new JCheckBox("Extra cheese ($.99)");
        ch2 = new JCheckBox("Beef ($1.99)");
        ch3 = new JCheckBox("Pepperni ($1.99)");
        ch4 = new JCheckBox("Sausage ($1.99)");
        ch5 = new JCheckBox("Mushrooms ($1.99)");
        ch6 = new JCheckBox("Chicken ($1.99)");

        checkBoxPanel.add(ch1);
        checkBoxPanel.add(ch2);
        checkBoxPanel.add(ch3);
        checkBoxPanel.add(ch4);
        checkBoxPanel.add(ch5);
        checkBoxPanel.add(ch6);

        ch1.addItemListener(this);
        ch2.addItemListener(this);
        ch3.addItemListener(this);
        ch4.addItemListener(this);

        ch5.addItemListener(this);
        ch6.addItemListener(this);
        

        getContentPane().add(checkBoxPanel, BorderLayout.WEST);
    }

    public void setUpRadio(){
        radioButtonsPanel = new JPanel(new BorderLayout());
        buttenPanel = new JPanel();
        // buttenPanel.setBackground(Color.WHITE);
        pizzaSizes = new ButtonGroup();

        radio1 = new JRadioButton("Small ($7)");
        radio2 = new JRadioButton("Medium ($10)");
        radio3 = new JRadioButton("Large ($12)");

        radio1.addItemListener(this);
        radio2.addItemListener(this);
        radio3.addItemListener(this);

        pizzaSizes.add(radio1);
        pizzaSizes.add(radio2);
        pizzaSizes.add(radio3);

        buttenPanel.add(radio1);
        buttenPanel.add(radio2);
        buttenPanel.add(radio3);

        radioButtonsPanel.add(buttenPanel, BorderLayout.NORTH);

        try {
            Image image = ImageIO.read(new File("pizza_PNG44043.png")); // <--- Use your PNG filename
            Image scaledImage = image.getScaledInstance(300, 200, Image.SCALE_SMOOTH); // optional scaling
            JLabel imageLabel = new JLabel(new ImageIcon(scaledImage));
            // imageLabel.setHorizontalAlignment(JLabel.NORTH); // optional

            // Add the image label below the radio buttons
            radioButtonsPanel.add(imageLabel);

        } catch (IOException e) {
            e.printStackTrace();
            JLabel errorLabel = new JLabel("Image not found!");
            buttenPanel.add(errorLabel, BorderLayout.CENTER);
        }


        
        getContentPane().add(radioButtonsPanel, BorderLayout.CENTER);

    }

    public void SetUpReceipt(){
        receipt = new JTextArea(20,25);
        receiptPanel = new JPanel(new FlowLayout());

        receipt.setLineWrap(true);

        receipt.setWrapStyleWord(true);
        JScrollPane scroll = new JScrollPane(receipt);
        receiptPanel.add(scroll);


        receiptPanel.add(receipt);
        

        getContentPane().add(receiptPanel,BorderLayout.EAST);
    }

    public void setUpSubmit(){
        orderPanel = new JPanel(new FlowLayout());

        orderButton = new JButton("Order");
        
        clearButton = new JButton("clear");
        
        orderPanel.add(orderButton);
        orderPanel.add(clearButton);

        getContentPane().add(orderPanel, BorderLayout.SOUTH);
        

        //
        orderButton.addActionListener(this);
        clearButton.addActionListener(this);

    }

    @Override
    public void itemStateChanged(ItemEvent event){
        Object source = event.getSource();
        pizzaTotal = 0;
        // if (pizzaTotal > 0 ){
        //     pizzaTotal = 0;
        // };

        if (ch1.isSelected()){
            pizzaTotal += .99;
            check1Chosen = true;
        };

        if (ch2.isSelected()){
            pizzaTotal += 1.99;
            check2Chosen = true;
        };

        if (ch3.isSelected()){
            pizzaTotal += 1.99;
            check3Chosen = true;
        };

        if (ch4.isSelected()){
            pizzaTotal += 1.99;
            check4Chosen = true;
        };

        if (ch5.isSelected()){
            pizzaTotal += 1.99;
            check5Chosen = true;
        };

        if (ch6.isSelected()){
            pizzaTotal += 1.99;
            check6Chosen = true;
        };
        
        if (radio1.isSelected()){
            radio1Chosen = true;
            pizzaTotal += 7;
            radio2Chosen = false;
            radio3Chosen = false;
        }else if (radio2.isSelected()){
            radio2Chosen = true;
            pizzaTotal += 10;
            radio1Chosen = false;
            radio3Chosen = false;
        }else if (radio3.isSelected()){
            radio3Chosen = true;
            pizzaTotal += 12;
            radio1Chosen = false;
            radio2Chosen = false;
        } 

        if (event.getStateChange() == ItemEvent.DESELECTED){
            if (source == ch1){
                check1Chosen = false;
            }
            if (source == ch2){
                check2Chosen = false;
            }
            if (source == ch3){
                check3Chosen = false;
            }
            if (source == ch4){
                check4Chosen = false;
            }
        }
    
        
    }

    public void buildOutputString(){
        if(radio1Chosen){
            outputText += "Small Pizza $7\n";
        }
        if(radio2Chosen){
            outputText += "Medium Pizza $10\n";
        }
        if(radio3Chosen){
            outputText += "Large Pizza $12\n";
        }
        if(check1Chosen){
            outputText += "Extra cheese $.99\n";
        }
        if(check2Chosen){
            outputText += "beef $1.99\n";
        }
        if(check3Chosen){
            outputText += "Pepperoni $1.99\n";
        }
        if(check4Chosen){
            outputText += "Sausage $1.99\n";
        }

        if(check5Chosen){
            outputText += "Mushrooms $1.99\n";
        }

        if(check6Chosen){
            outputText += "Chicken $1.99\n";
        }

        if (pizzaTotal > 1){
            outputText += "\n------------------\n";
            String totalInRightForm = String.format("%.2f", pizzaTotal);
            outputText += "Total $" + totalInRightForm;
        }
    };

    public void actionPerformed(ActionEvent event){
        if (event.getSource() == orderButton){
            buildOutputString();
            receipt.setText(outputText);
            outputText="";
        }
        else if (event.getSource() == clearButton){
            ch1.setSelected(false);
            ch2.setSelected(false);
            ch3.setSelected(false);
            ch4.setSelected(false);
            ch5.setSelected(false);
            ch6.setSelected(false);
            
            pizzaSizes.clearSelection();
            radio1Chosen = false;
            radio2Chosen = false;
            radio3Chosen = false;
            receipt.setText("");
            outputText = "";
        }
    };
}