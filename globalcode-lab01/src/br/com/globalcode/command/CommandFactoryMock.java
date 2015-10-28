package br.com.globalcode.command;

public class CommandFactoryMock implements CommandFactory {

	private static final String DEFAULT_SUBPACKAGE_COMMAND = ".mock.";
	
	@Override
	public BaseCommand create(String name) {

		try {
			StringBuilder builder = new StringBuilder();
			
			builder.append(DEFALUT_BASE_PACKAGE_COMMAND);
			builder.append(DEFAULT_SUBPACKAGE_COMMAND);
			builder.append(name);
			builder.append(DEFAULT_SUFIX_COMMAND_CLASS);
			
			return (BaseCommand) Class.forName(builder.toString()).newInstance();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
