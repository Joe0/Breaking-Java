package com.joepritzel.breakingj.create;

public interface Creator {
	public String getClassName();

	public String getSimpleName();

	public String getPackageName();

	public byte[] create() throws Exception;
}
