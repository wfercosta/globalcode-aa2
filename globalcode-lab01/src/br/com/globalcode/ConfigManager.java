package br.com.globalcode;

public class ConfigManager {
	
	private static ConfigManager _instance = new ConfigManager();
	private String serverName;

	/**
	 * Método construtor
	 */
	private ConfigManager() {}
	
	
	public static ConfigManager getInstance() {
		return _instance;
	}
	

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}
}
