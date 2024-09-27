package fr.phenix333.ai.game.programming.service;

import org.eclipse.paho.client.mqttv3.MqttAsyncClient;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import fr.phenix333.logger.MyLogger;

@Service
public class MqttPublish {

	private static final MyLogger L = MyLogger.create(MqttSubscribe.class);

	@Value("${mqtt.host}")
	private String mqttHost;

	@Value("${mqtt.port}")
	private String mqttPort;

	@Value("${mqtt.user}")
	private String mqttUser;

	@Value("${mqtt.opponent}")
	private String mqttOpponent;

	private MqttClient client;

	/**
	 * Initialise le mqttPublish pour pouvoir le réutiliser plus tard
	 */
	public void mqttPublish() {
		L.function("Initialise le mqttPublish pour pouvoir le reutiliser plus tard");

		String broker = String.format("tcp://%s:%s", this.mqttHost, this.mqttPort);

		MemoryPersistence persistence = new MemoryPersistence();

		try {
			this.client = new MqttClient(broker, MqttAsyncClient.generateClientId(), persistence);

			MqttConnectOptions connOpts = new MqttConnectOptions();
			connOpts.setCleanSession(true);

			client.connect(connOpts);
		} catch (MqttException e) {
			L.error("Une erreur MQTT est remontee", e);

			// Je pars du principe que vue que le projet se base sur MQTT si la
			// fonction pour envoyer un message ne fonctionne plus le projet ne peux
			// fonctionner
			System.exit(-1);
		}
	}

	/**
	 * Envoi un message sur un topic spécifique
	 *
	 * @param theMessage -> String : le message à envoyer
	 */
	public void publish(String theMessage) {
		L.function("Envoi un message sur un topic specifique | message : {}", theMessage);

		MqttMessage message = new MqttMessage(theMessage.getBytes());

		try {
			this.client.publish(String.format("awale/%s", this.mqttOpponent), message);
		} catch (MqttException e) {
			L.error("Une erreur MQTT est remontee", e);

			// Je pars du principe que vue que le projet se base sur MQTT si la
			// fonction pour envoyer un message ne fonctionne plus le projet ne peux
			// fonctionner
			System.exit(-1);
		}

		L.info("Nouveau message envoye : {}", theMessage);
	}

}
