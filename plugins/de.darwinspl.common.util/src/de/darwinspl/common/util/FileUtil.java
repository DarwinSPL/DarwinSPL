package de.darwinspl.common.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileUtil {

	public static String readFileContent(File file) throws IOException {
		return new String(Files.readAllBytes(file.toPath()));
	}
	
}
