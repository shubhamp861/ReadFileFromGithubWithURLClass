package com.example.fileReadFromGithub;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

@SpringBootApplication
public class FileReadFromGithubApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FileReadFromGithubApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		String line,content = null;
		URL url = new URL("https://raw.githubusercontent.com/shubhamp861/Humus_Ang_Repo/main/README.md");
		//replace above url with your url.

//		uc.setRequestProperty("X-Requested-With", "Curl");
//		String userAndPass = username + ":" + password;
//		String basicAuth = "Basic " + new String(Base64.getEncoder().encode(userAndPass.getBytes()));
//		uc.setRequestProperty("Authorization", basicAuth);

		URLConnection uc = url.openConnection();
		BufferedReader reader = new BufferedReader(new InputStreamReader(uc.getInputStream()));
		while ((line = reader.readLine()) != null)
			content += line + "\n";
		System.out.println(content);
	}
}
