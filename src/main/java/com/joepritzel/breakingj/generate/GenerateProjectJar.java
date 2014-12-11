package com.joepritzel.breakingj.generate;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

import com.joepritzel.breakingj.create.ReturnTypeCreator;

public class GenerateProjectJar {

	public static void main(String[] args) throws Exception {
		new GenerateProjectJar().generate(new File(args[0]));
	}

	private void generate(File output) throws Exception {
		File tempDir = new File("tmpDir");

		new GenerateClass().generate(tempDir, new ReturnTypeCreator());

		new GenerateJar().generate(tempDir, output);

		deleteTempDir(tempDir);
	}

	private void deleteTempDir(File tempDir) throws IOException {
		Files.walkFileTree(tempDir.toPath(), new SimpleFileVisitor<Path>() {
			@Override
			public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
				Files.delete(file);
				return FileVisitResult.CONTINUE;
			}

			@Override
			public FileVisitResult postVisitDirectory(Path dir, IOException e) throws IOException {
				Files.delete(dir);
				return FileVisitResult.CONTINUE;
			}
		});
		tempDir.delete();
	}
}
