import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SecMain {
    JFrame frame = new JFrame("Music maker");
    JPanel panel = new JPanel();
    JButton play = new JButton("Play");
    JLabel title = new JLabel("Music Maker");
    JTextArea textArea = new JTextArea();

    void a(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        play.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userInput = textArea.getText();
                JOptionPane.showMessageDialog(frame, "Hello, " + userInput + "!");
            }
        });
        frame.add(panel);
        panel.add(title);
        panel.add(textArea);
        panel.add(play);

        frame.setVisible(true);
    }




}
