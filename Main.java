import javax.swing.*;

public class Main {
        public static void main(String[] args) {
            JFrame frame = new JFrame("GUI_TM01");
            frame.setContentPane(new GUI_TM01().Main);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
            frame.setSize(300,300);
        }
}