package com.joepritzel.breakingj.generate;

import java.io.File;
import java.nio.file.Files;

import com.joepritzel.breakingj.create.Creator;

public class GenerateClass {

	public void generate(File dir, Creator creator) throws Exception {
		File packageDir = new File(dir, creator.getPackageName().replace('.', '/'));
		packageDir.mkdirs();
		File classFile = new File(packageDir, creator.getSimpleName() + ".class");
		classFile.createNewFile();
		Files.write(classFile.toPath(), creator.create());
	}

}
