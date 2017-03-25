package visual;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Menu extends JPanel {

	/**
	 * Create the panel.
	 */
	public Menu() {
		
		System.out.println("Generamos un JPanel Menu");
		
		JButton btnJugar = new JButton("Jugar");
		btnJugar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println("CLICK");
			}
		});
		JButton btnAyuda = new JButton("Ayuda");		
		JButton btnAcercaDe = new JButton("Acerca de...");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(165)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnAcercaDe, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnAyuda, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnJugar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))
					.addContainerGap(171, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(88)
					.addComponent(btnJugar)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnAyuda)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnAcercaDe)
					.addContainerGap(121, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
}
