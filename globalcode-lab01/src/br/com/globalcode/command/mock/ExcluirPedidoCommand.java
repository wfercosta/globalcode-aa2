package br.com.globalcode.command.mock;

import javax.swing.JTextArea;

import br.com.globalcode.command.BaseCommand;

public class ExcluirPedidoCommand implements BaseCommand {

	@Override
	public void execute(JTextArea taMensagens) {
		taMensagens.setText(getClass().getName());
	}

}
