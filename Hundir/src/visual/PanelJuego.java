package visual;

import javax.swing.JPanel;

import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class PanelJuego extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelJuego() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0};
		gridBagLayout.rowHeights = new int[]{0};
		gridBagLayout.columnWeights = new double[]{Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				JButton button = new JButton("?");
				GridBagConstraints lugar = new GridBagConstraints();
				System.out.println("Posicion: "+ i + " " + j);
				lugar.gridx = i;
				lugar.gridy = j;
				add(button, lugar);
			}
		}
	
		
		

	}

}
