import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;


public class GeradorTicket {
	static JFrame frame;
	

	public static void main(String[] args) {				
	
				
		frame = new JFrame("Test");
		frame.setTitle("GeradorTickets");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);		
		addFrameContent();				
		frame.pack();
		open();
		
	}
	public static void open() {		
		frame.setSize(1000,300);				
		frame.setVisible(true);
	}
	
	public static String generate(String str1, String str2) {
		String msg = "Nicks dos jogadores que partilham IP: Marjavente e Nitrox \r\n"
				+ "\r\n"
				+ "Motivo da Partilha de IP: Somos da mesma família e eu vou lá passar uns dias\r\n"
				+ "\r\n"
				+ "Detalhes adicionais (se necessários): Desde o dia " + str1 + " até ao dia " + str2;
		
		
		StringSelection stringSelection = new StringSelection(msg);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, null);
		
		return msg;
		
	
	}
	
	public static void openOgame() {
		
		   URI uri;
		try {
			uri = new URI("https://ogame.support.gameforge.com/index.php?page=support&action=next&id=213&fld=pt");
			try {
				java.awt.Desktop.getDesktop().browse(uri);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		} catch (URISyntaxException e) {
			
			e.printStackTrace();
		}
		   
		   
		
	}

	private static void addFrameContent() {
		
		
		
        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        JTextField datainicio = new JTextField("", 20);
        JTextField datafim = new JTextField("", 20);
        JTextArea gerado = new JTextArea("");
        JButton button = new JButton("Gerar");
        gerado.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	gerado.setText(generate(datainicio.getText(), datafim.getText()));
            	openOgame();
            }
        });
        
        panel.add(new JLabel("Data de Inicio "));
        panel.add(datainicio);
        panel.add(Box.createHorizontalStrut(25));
        panel.add(new JLabel("Data de Fim "));
        panel.add(datafim);
        panel.add(Box.createHorizontalStrut(25));
        panel.add(button);
        frame.add(panel, BorderLayout.NORTH);
        frame.add(gerado);
    }

}
