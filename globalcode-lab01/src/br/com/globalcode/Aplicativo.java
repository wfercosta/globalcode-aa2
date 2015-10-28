package br.com.globalcode;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import br.com.globalcode.command.BaseCommand;
import br.com.globalcode.command.CommandFactory;

public class Aplicativo extends JFrame {
    
    /**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 4951507248031495291L;
	
	JTextArea taMensagens = new JTextArea();
	CommandFactory factory = null;
    
    public static void main(String[] args) {
        new Aplicativo();
    }
    
    public Aplicativo() {
        super("Curso de Design Patterns - lab01");
        init();
    }

	private void init() {
		configurarJPanel();
        this.factory = getFactory();
	}

	private void configurarJPanel() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel panel = montaPainelBotoes();
        add(panel,BorderLayout.SOUTH);
        add(taMensagens,BorderLayout.CENTER);
        setSize(500,200);
        setVisible(true);
	}
    
    private CommandFactory getFactory() {
    	try {
			Properties properties = new Properties();
			properties.load(getClass().getResourceAsStream("/config.properties"));
			String name = properties.getProperty("br.com.globalcode.command.factory");
			return (CommandFactory) Class.forName(name).newInstance();
		} catch (Exception e) {
			throw new RuntimeException("Erro ao criar a factory");
		}
    }
    
    private JButton criarJButton(String rotulo, String command, JPanel panel, ActionListener listener) {
    	JButton button = new JButton(rotulo);
    	button.setActionCommand(command);
    	button.addActionListener(listener);
    	panel.add(button);
    	return button;
    }
    
    private JPanel montaPainelBotoes() {
        
    	JPanel panel = new JPanel();
        
    	ActionListener listener = new ActionListener() {
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			performarCliqueBotao(e.getActionCommand());
    		}
    	};
    	
    	criarJButton("Excluir Pedido", "ExcluirPedido", panel, listener);
    	criarJButton("Novo Pedido", "NovoPedido", panel, listener);
    	criarJButton("Gerar PDF", "GeracaoPDF", panel, listener);
        criarJButton("Enviar Pedido", "EnvioPedido", panel, listener);
        
        return panel;
    }
    
    private void performarCliqueBotao(String action) {
    	BaseCommand command = factory.create(action);
    	command.execute(taMensagens);
    }
    
}
