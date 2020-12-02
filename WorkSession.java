import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Handler;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class WorkSession extends JPanel {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    static JButton button = new JButton("Start work session");
    private Timer timer = null;
    static JLabel label = new JLabel("No");
    static JLabel doneLabel = new JLabel("0% complete");
    float count = 0;
    float done = 0;

    public WorkSession() {

        timer = new Timer(1000, new ActionListener() { // Timer 4 seconds
            public void actionPerformed(ActionEvent e) {
                count++;

                if (count == 5) {
                    doneLabel.setText("Complete!");
                }

                doneLabel.setText((count / 5) + "% complete");

            }
        });

        Font timerFont = new Font(Font.SANS_SERIF, Font.BOLD, 26);
        label.setFont(timerFont);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                timer.start(); // start timer

                label.setText("" + count);

            }
        });
    }

    private static void createAndShowGui() {
        JFrame frame = new JFrame();
        frame.add(new WorkSession(), BorderLayout.CENTER);
        frame.add(button, BorderLayout.SOUTH);
        frame.add(doneLabel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

    }

    public Dimension getPreferredSize() {
        return new Dimension(300, 300);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }
}
