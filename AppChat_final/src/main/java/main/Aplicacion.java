package main;

import java.awt.EventQueue;

import javax.swing.UIManager;

import um.tds.*;

public class Aplicacion {
	public static void main(final String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
					Ventana_Perfil ventana = new Ventana_Perfil();
					ventana.mostrarVentana();
				} catch (Exception e) {				
					e.printStackTrace();
				}
			}
		});
	}
}
