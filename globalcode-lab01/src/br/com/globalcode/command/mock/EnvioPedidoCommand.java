package br.com.globalcode.command.mock;

import javax.swing.JTextArea;

import br.com.globalcode.command.BaseCommand;

public class EnvioPedidoCommand implements BaseCommand {

	@Override
	public void execute(JTextArea taMensagens) {
		taMensagens.setText(getClass().getName());
	}

}
