package visual;

import javax.swing.JPanel;

import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.GridLayout;

public class PanelJuego extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelJuego() {
		setLayout(new GridLayout(9, 9, 0, 0));	
	
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; i < 9; i++) {
				JButton button = new JButton("?");
				add(button);
			}
		}

	}

}
