package javaguiassignemnt;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.time.Duration;
import java.time.LocalTime;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class OptionTwo {

    public static void main(String[] args) throws ParseException {

        int yourChoice = JOptionPane.showOptionDialog(null, "Choose option", "Click a button", JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, new String[]{"Settings", "Cancle"}, null);
        switch (yourChoice) {
            case JOptionPane.NO_OPTION:
                break;
            case JOptionPane.YES_OPTION:
                JFrame f = new JFrame();
                f.setLocation(700, 300);
                f.setSize(500, 500);
                f.setDefaultCloseOperation(EXIT_ON_CLOSE);
                JPanel p = new JPanel();

                MyFrame frame = new MyFrame() {
                };

                frame.setLocation(700, 300);
                frame.setVisible(true);

                frame.okBtn.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (frame.cdBtn.isSelected()) {
                            int t = Integer.parseInt(frame.cdTimer.getText());
                            int item = frame.speedBox.getSelectedIndex();
                            switch (item) {
                                case 0:
                                    break;
                                case 1:
                                    t = (t / 2);
                                    break;
                                case 3:
                                    t = (t / 3);
                                    break;
                                case 4:
                                    t = (t / 4);
                                    break;
                                case 5:
                                    t = (t / 5);
                                    break;
                            }

                            Timer timer;
                            timer = new Timer(t * 1000, new ActionListener() {

                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    f.setVisible(true);
                                    f.setLocation(100, 300);
                                    p.setBackground(frame.c);
                                    f.add(p);

                                }

                            });

                            timer.start();
                            timer.setRepeats(false);

                            Timer timerT = new Timer(1500, new ActionListener() {

                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    if (p.getBackground() == frame.c) {
                                        p.setBackground(Color.WHITE);
                                    } else {
                                        p.setBackground(frame.c);
                                    }
                                }
                            });
                            timerT.start();
                            timerT.setRepeats(true);
                            frame.okBtn.setEnabled(false);
                            frame.cdBtn.setEnabled(false);
                            frame.colorBtn.setEnabled(false);
                            frame.speedBox.setEnabled(false);
                            frame.onTime.setEnabled(false);
                            frame.timeVal.setEditable(false);
                            frame.cdTimer.setEditable(false);
                            frame.stopBtn.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    frame.okBtn.setEnabled(true);
                                    frame.cdBtn.setEnabled(true);
                                    frame.colorBtn.setEnabled(true);
                                    frame.speedBox.setEnabled(true);
                                    frame.onTime.setEnabled(true);
                                    frame.timeVal.setEditable(true);
                                    frame.cdTimer.setEditable(true);
                                    f.dispose();
                                    timer.stop();
                                  
                                }
                            });
                        } else {
                            frame.okBtn.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    String inputTime = frame.timeVal.getText();
                                    LocalTime inpTime = LocalTime.parse(inputTime);
                                    LocalTime nowTime = LocalTime.now();
                                    String nowIsTime = nowTime.toString();
                                    long unit = Duration.between(nowTime, inpTime).toMillis();
                                    Timer tt = new Timer((int) unit, new ActionListener() {

                                        @Override
                                        public void actionPerformed(ActionEvent e) {

                                            f.setVisible(true);
                                            f.setLocation(150, 700);
                                            f.add(p);
                                            p.setBackground(frame.c);
                                        }
                                    });
                                    tt.start();
                                    Timer timerT = new Timer(1500, new ActionListener() {

                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            if (p.getBackground() == frame.c) {
                                                p.setBackground(Color.WHITE);
                                            } else {
                                                p.setBackground(frame.c);
                                            }
                                        }
                                    });timerT.start();
                                    timerT.setRepeats(true);
                                    frame.okBtn.setEnabled(false);
                                    frame.cdBtn.setEnabled(false);
                                    frame.colorBtn.setEnabled(false);
                                    frame.speedBox.setEnabled(false);
                                    frame.onTime.setEnabled(false);
                                    frame.timeVal.setEditable(false);
                                    frame.cdTimer.setEditable(false);
                                }
                            });

                        }
                        frame.stopBtn.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                frame.okBtn.setEnabled(true);
                                frame.cdBtn.setEnabled(true);
                                frame.colorBtn.setEnabled(true);
                                frame.speedBox.setEnabled(true);
                                frame.onTime.setEnabled(true);
                                frame.timeVal.setEditable(true);
                                frame.cdTimer.setEditable(true);
                                f.dispose();

                            }
                        });

                    }
                });

        }

    }
}
