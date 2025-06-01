package com.javawebcompiler.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/compiler")
public class JavaCompilerController {

	@PostMapping("/run")
	public ResponseEntity<String> runJavaCode(@RequestBody Map<String, String> payload) {
		String code = payload.get("code");

		try {
			// Create temporary directory and file
			Path tempDir = Files.createTempDirectory("java-compiler");
			Path javaFilePath = tempDir.resolve("Main.java");

			// Write user code to Main.java
			Files.write(javaFilePath, code.getBytes());

			// Compile the code
			Process compileProcess = new ProcessBuilder("javac", javaFilePath.toString()).redirectErrorStream(true)
					.directory(tempDir.toFile()).start();

			String compileOutput = new String(compileProcess.getInputStream().readAllBytes());
			compileProcess.waitFor();

			if (compileProcess.exitValue() != 0) {
				return ResponseEntity.ok("Compilation Error:\n" + compileOutput);
			}

			// Run the compiled class
			Process runProcess = new ProcessBuilder("java", "-cp", tempDir.toString(), "Main").redirectErrorStream(true)
					.start();

			String runOutput = new String(runProcess.getInputStream().readAllBytes());
			runProcess.waitFor();

			return ResponseEntity.ok(runOutput);

		} catch (Exception e) {
			return ResponseEntity.status(500).body("Error: " + e.getMessage());
		}
	}
}
