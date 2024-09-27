package fr.phenix333.ai.game.programming;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.phenix333.ai.game.programming.service.MqttSubscribe;
import fr.phenix333.logger.MyLogger;

@SpringBootApplication
public class AiGameProgrammingMqttApplication implements CommandLineRunner {

	private static final MyLogger L = MyLogger.create(AiGameProgrammingMqttApplication.class);

	@Autowired
	private MqttSubscribe mqttSubscribe;

	public static void main(String[] args) {
		L.function("");

		SpringApplication.run(AiGameProgrammingMqttApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		L.function("Lancement du code principal");

		this.deletePaho();

		this.mqttSubscribe.subscribeMqtt();
	}

	private void deletePaho() {
		L.debug("Supression des dossiers paho (MQTT)");

		File[] fichiers = new File(System.getProperty("user.dir")).listFiles();

		if (fichiers != null) {
			for (File fichier : fichiers) {
				if (fichier.isDirectory() && fichier.getName().startsWith("paho")) {
					File file = new File(fichier, ".lck");
					file.delete();
					fichier.delete();
				}
			}
		}
	}

}
