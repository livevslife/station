package com.wap.entity;


import jo.util.ConfigProperties;

public class ConfigUtils
{
	final static String CONFIG_FILE = getRealPath() + "\\config/config.cfg";
	//private final static String CONFIG_FILE = "/opt/NADAPCHECK/conf/nadap-config.cfg";	
	public static ConfigProperties getConfigProperties()
	{
		
		ConfigProperties cfg = new ConfigProperties(CONFIG_FILE);
		return cfg;
	}
	public static String getRealPath() {
		String realPath = ConfigUtils.class.getClassLoader().getResource("").getFile();
		java.io.File file = new java.io.File(realPath);
		realPath = file.getAbsolutePath();
		try {
			realPath = java.net.URLDecoder.decode(realPath, "utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return realPath;
	}
	
}
