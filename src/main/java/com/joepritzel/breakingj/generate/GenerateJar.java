package com.joepritzel.breakingj.generate;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;
import java.util.jar.Manifest;

public class GenerateJar {

	public void generate(File dir, File jarFile) throws FileNotFoundException, IOException {

		Manifest manifest = new Manifest();
		Attributes global = manifest.getMainAttributes();
		global.put(Attributes.Name.MANIFEST_VERSION, "1.0.0");
		global.put(new Attributes.Name("Created-By"), "Breaking-Java");

		try (final JarOutputStream jos = new JarOutputStream(new FileOutputStream(jarFile), manifest)) {

			Files.walkFileTree(dir.toPath(), new SimpleFileVisitor<Path>() {
				@Override
				public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
					JarEntry je = new JarEntry(removeBaseDir(dir, file.toFile()));
					jos.putNextEntry(je);
					byte[] ba = Files.readAllBytes(file);
					jos.write(ba);
					jos.closeEntry();
					return FileVisitResult.CONTINUE;
				}

				private String removeBaseDir(File baseDir, File file) {
					String s = file.getAbsolutePath();
					s = s.substring(baseDir.getAbsolutePath().length() + 1);
					return s;
				}
			});
		}
	}

}
