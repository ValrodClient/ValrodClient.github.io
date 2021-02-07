import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI{
	
	public static JLabel lbl;
	public static JLabel statue;
	
	public GUI() {
		JFrame f = new JFrame();
		JPanel p = new JPanel();
		
		lbl = new JLabel("Checking for update..");
		lbl.setForeground(new Color(0, 189, 95));
		lbl.setFont(new Font("Verdana", Font.PLAIN, 18));
		lbl.setHorizontalAlignment(JLabel.CENTER);
		
		statue = new JLabel("");
		statue.setForeground(new Color(0, 189, 95));
		statue.setFont(new Font("Verdana", Font.PLAIN, 15));
		statue.setHorizontalAlignment(JLabel.CENTER);
		
		p.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		p.setLayout(new GridLayout(0, 1));
		p.setBackground(new Color(36, 36, 36));
		p.add(lbl);
		p.add(statue);
		
		f.add(p, BorderLayout.CENTER);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setTitle("ValrodClient installer");
		f.setPreferredSize(new Dimension(utils.windowWidth, utils.windowHeight));
		f.setResizable(false);
		f.setLocationRelativeTo(null);
		URL url = getClass().getResource("icon.png");
		ImageIcon imgicon = new ImageIcon(url);
		f.setIconImage(imgicon.getImage());
		f.pack();
		f.setVisible(true);
		utils.update();
	}
}
