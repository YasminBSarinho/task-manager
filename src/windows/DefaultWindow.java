package windows;

import javax.swing.*;
import java.awt.*;

public class DefaultWindow extends JFrame {
    private JButton rightButton;
    private JButton leftButton;

    public DefaultWindow(String title){
        setTitle(title);
        setSize(650, 600); // Largura, altrua
        setLocationRelativeTo(null); // inicializa no centro
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // finazliza o programa quanfo fecha a janela
        //getContentPane().setBackground(Color.gray);
        setResizable(true); // nao permite redimencionar  580 108 580 4x108
        addButtons();
    }

    private void addButtons(){
        rightButton = new JButton("Botao");
        rightButton.setBounds(412, 480, 128, 40);
        add(rightButton);

        leftButton = new JButton("Outro");
        leftButton.setBounds(88, 480, 128, 40);
        add(leftButton);
    }

    public JButton getRightButton() {
        return rightButton;
    }

    public void setRightButton(JButton rightButton) {
        this.rightButton = rightButton;
    }

    public JButton getLeftButton() {
        return leftButton;
    }

    public void setLeftButton(JButton leftButton) {
        this.leftButton = leftButton;
    }
}
