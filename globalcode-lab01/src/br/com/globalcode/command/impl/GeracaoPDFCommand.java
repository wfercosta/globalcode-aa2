package br.com.globalcode.command.impl;

import javax.swing.JTextArea;

import br.com.globalcode.command.BaseCommand;

public class GeracaoPDFCommand implements BaseCommand {

	@Override
	public void execute(JTextArea taMensagens) {
		taMensagens.setText(getClass().getName());
	}

}
