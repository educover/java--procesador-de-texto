

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.text.*;

public class PracticaProcesadorTexto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProcesadorMarco procesador = new ProcesadorMarco();
		procesador.setVisible(true);
		procesador.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class ProcesadorMarco extends JFrame{
	public ProcesadorMarco(){
		setBounds(150, 100, 500, 500);
		add(new ProcesadorLamina());
	}
}

class ProcesadorLamina extends JPanel{
	public ProcesadorLamina(){
		setLayout(new BorderLayout());
		
		JPanel laminaMenu = new JPanel();
		
		JMenuBar mimenu = new JMenuBar();
		
		fuente = new JMenu("Fuente");
		estilo = new JMenu("Estilo");
		tamagno = new JMenu("Tamaño");
		
		configuraMenu("Arial", "Fuente", "Arial", 9, 10);
		configuraMenu("Courier", "Fuente", "Courier", 9, 10);
		configuraMenu("Verdana", "Fuente", "Verdana", 9, 10);
		
		//configuraMenu("Negrita", "Estilo", "", Font.BOLD, 10);
		//configuraMenu("Cursiva", "Estilo", "", Font.ITALIC, 10);
		
		JCheckBoxMenuItem negrita = new JCheckBoxMenuItem("Negrita");
		JCheckBoxMenuItem cursiva = new JCheckBoxMenuItem("Cursiva");
		JCheckBoxMenuItem subra = new JCheckBoxMenuItem("Subrayado");
		negrita.addActionListener(new StyledEditorKit.BoldAction());
		cursiva.addActionListener(new StyledEditorKit.ItalicAction());
		subra.addActionListener(new StyledEditorKit.UnderlineAction());
		
		estilo.add(negrita);
		estilo.add(cursiva);
		estilo.add(subra);
		
		//configuraMenu("10", "Tamaño", "", 9, 10);
		//configuraMenu("14", "Tamaño", "", 9, 14);
		//configuraMenu("18", "Tamaño", "", 9, 18);
		//configuraMenu("24", "Tamaño", "", 9, 24);
		
		ButtonGroup grupoTamagno = new ButtonGroup();
		
		JRadioButtonMenuItem doce = new JRadioButtonMenuItem("12");
		JRadioButtonMenuItem dieciseis = new JRadioButtonMenuItem("16");
		JRadioButtonMenuItem veinte = new JRadioButtonMenuItem("20");
		JRadioButtonMenuItem veinte4 = new JRadioButtonMenuItem("24");
		
		grupoTamagno.add(doce);
		grupoTamagno.add(dieciseis);
		grupoTamagno.add(veinte);
		grupoTamagno.add(veinte4);
		
		doce.addActionListener(new StyledEditorKit.FontSizeAction("", 12));
		dieciseis.addActionListener(new StyledEditorKit.FontSizeAction("", 16));
		veinte.addActionListener(new StyledEditorKit.FontSizeAction("", 20));
		veinte4.addActionListener(new StyledEditorKit.FontSizeAction("", 24));
		
		tamagno.add(doce);
		tamagno.add(dieciseis);
		tamagno.add(veinte);
		tamagno.add(veinte4);
		
		mimenu.add(fuente);
		mimenu.add(estilo);
		mimenu.add(tamagno);
		
		laminaMenu.add(mimenu);
		
		add(laminaMenu, BorderLayout.NORTH);
		
		miTexT = new JTextPane();
		
		add(miTexT, BorderLayout.CENTER);
		
		JPopupMenu emergente = new JPopupMenu();
		JMenuItem negritaE = new JMenuItem("Negrita");
		JMenuItem cursivaE = new JMenuItem("Cursiva");
		
		negritaE.addActionListener(new StyledEditorKit.BoldAction());
		cursivaE.addActionListener(new StyledEditorKit.ItalicAction());
		
		emergente.add(negritaE);
		emergente.add(cursivaE);
		
		miTexT.setComponentPopupMenu(emergente);
		//------------------------------
		/*JToolBar barra = new JToolBar();
		
		JButton negritaBarra = new JButton(new ImageIcon(""));
		JButton cursivaBarra = new JButton(new ImageIcon(""));
		JButton subBarra = new JButton(new ImageIcon(""));
		
		JButton amarilloBarra = new JButton(new ImageIcon(""));
		JButton rojoBarra = new JButton(new ImageIcon(""));
		JButton azulBarra = new JButton(new ImageIcon(""));
		
		JButton derecha = new JButton(new ImageIcon(""));
		JButton izquierda = new JButton(new ImageIcon(""));
		JButton centro = new JButton(new ImageIcon(""));
		JButton justificado = new JButton(new ImageIcon(""));
		
		negritaBarra.addActionListener(new StyledEditorKit.BoldAction());
		cursivaBarra.addActionListener(new StyledEditorKit.ItalicAction());
		subBarra.addActionListener(new StyledEditorKit.UnderlineAction());
		
		azulBarra.addActionListener(new StyledEditorKit.ForegroundAction("Poner Azul", Color.BLUE));
		rojoBarra.addActionListener(new StyledEditorKit.ForegroundAction("Poner rojo", Color.RED));
		amarilloBarra.addActionListener(new StyledEditorKit.ForegroundAction("Poner amarillo", Color.YELLOW));
		
		derecha.addActionListener(new StyledEditorKit.AlignmentAction("Alinea ", 2));
		centro.addActionListener(new StyledEditorKit.AlignmentAction("Alinea ", 1));
		izquierda.addActionListener(new StyledEditorKit.AlignmentAction("Alinea ", 0));
		justificado.addActionListener(new StyledEditorKit.AlignmentAction("Alinea ", 3));
		
		barra.add(negritaBarra);
		barra.add(cursivaBarra);
		barra.add(subBarra);
		
		barra.addSeparator();
		
		barra.add(amarilloBarra);
		barra.add(azulBarra);
		barra.add(rojoBarra);
		
		barra.addSeparator();
		
		barra.add(izquierda);
		barra.add(centro);
		barra.add(derecha);
		barra.add(justificado);*/
		
		barra = new JToolBar();
		
		configuraMenu("N").addActionListener(new StyledEditorKit.BoldAction());
		configuraMenu("C").addActionListener(new StyledEditorKit.ItalicAction());
		configuraMenu("S").addActionListener(new StyledEditorKit.UnderlineAction());
		barra.addSeparator();
		
		configuraMenu("R").addActionListener(new StyledEditorKit.ForegroundAction("rojo", Color.RED));
		configuraMenu("A").addActionListener(new StyledEditorKit.ForegroundAction("azul", Color.BLUE));
		configuraMenu("AM").addActionListener(new StyledEditorKit.ForegroundAction("amarillo", Color.YELLOW));
		barra.addSeparator();
		
		configuraMenu("I").addActionListener(new StyledEditorKit.AlignmentAction("izq", 0));
		configuraMenu("C").addActionListener(new StyledEditorKit.AlignmentAction("cen", 1));
		configuraMenu("D").addActionListener(new StyledEditorKit.AlignmentAction("der", 2));
		configuraMenu("J").addActionListener(new StyledEditorKit.AlignmentAction("just", 3));
		
		barra.setOrientation(1);
		add(barra, BorderLayout.WEST);
	}
	
	public JButton configuraMenu(String nombre){
		JButton boton = new JButton(nombre);
		barra.add(boton);
		return boton;
	}
	
	public void configuraMenu(String rotulo, String menu, String tipoLetra, int estilos, int tam){
		JMenuItem elemMenu = new JMenuItem(rotulo);
		if (menu=="Fuente"){
			fuente.add(elemMenu);
		} else if(menu=="Estilo"){
			estilo.add(elemMenu);
		} else if(menu=="Tamaño"){
			tamagno.add(elemMenu);
			elemMenu.addActionListener(new StyledEditorKit.FontSizeAction("cambia tamaño", tam));
		}
		
		elemMenu.addActionListener(new GestionaEventos(rotulo, tipoLetra, estilos, tam));
		
	}
	
	private class GestionaEventos implements ActionListener{

		
		String tipoTexto, menu;
		int estiloLetra, tamagnoLetra;
		
		public GestionaEventos(String elemento, String texto2, int estilo2, int tamLetra){
		tipoTexto = texto2;	
		estiloLetra = estilo2;
		tamagnoLetra = tamLetra;
		menu=elemento;
		}	
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			letras = miTexT.getFont();
			if (menu=="Arial" || menu=="Verdana" || menu=="Courier"){
				estiloLetra = letras.getStyle();
				tamagnoLetra = letras.getSize();
			} else 
			
			if (menu=="Negrita" || menu=="Cursiva"){
				
				tipoTexto = letras.getFontName();
				tamagnoLetra = letras.getSize();
			} else 
			
			if (menu=="10" || menu=="14" || menu=="18" || menu=="24"){
				tipoTexto = letras.getFontName();
				estiloLetra = letras.getStyle();
			}
			
			miTexT.setFont(new Font(tipoTexto, estiloLetra, tamagnoLetra));
			System.out.println("Tipo: " + tipoTexto + " Estilo: " + estiloLetra + " Tamaño: "+ tamagnoLetra);
		}
		
	}
	
	/* private class GestionaEventos implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			miTexT.setFont(new Font("Arial", Font.PLAIN, 14));
		}
		
	} */
	private JTextPane miTexT;
	private JMenu fuente, estilo, tamagno;
	private Font letras;
	private JToolBar barra;
	
}