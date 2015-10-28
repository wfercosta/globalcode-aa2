package br.com.globalcode.command;

import javax.swing.JTextArea;

/**
 * Interface command
 * @author wfer
 */
public interface BaseCommand {

	/**
	 * Método de execução do comando.
	 * @param taMensagens
	 */
	void execute(JTextArea taMensagens);
	
}
