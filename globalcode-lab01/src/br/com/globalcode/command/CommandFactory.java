package br.com.globalcode.command;

public interface CommandFactory {
	
	
	String DEFALUT_BASE_PACKAGE_COMMAND = "br.com.globalcode.command";
	String DEFAULT_SUFIX_COMMAND_CLASS = "Command";
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	BaseCommand create (String name);
	
}
