# Installation

Java 17

## Pour lancer en local

### Logger

```
mvn install:install-file -Dfile='src/main/libs/logger-0.0.1-SNAPSHOT.jar' -DgroupId='fr.phenix333' -DartifactId=logger -Dversion='0.0.1-SNAPSHOT' -Dpackaging=jar
```

### Lancement

```
Lancer comme vous voulez en ligne de commande ou ide
```

## Pour lancer le .jar

Arguments:

- mqtt.host=<test.mosquitto.org>
- mqtt.port=<1883>
- mqtt.user=\<Colin>
- mqtt.opponent=\<Jake>
- command=\<python3 test.py>

```
java -jar ai-game-programming-mqtt-0.0.1-SNAPSHOT.jar --host.port='test.mosquitto.org' --mqtt.port=1883 --mqtt.user=Colin --mqtt.opponent=Jake --command='java -jar src/test/test.jar'
```

<br>
<br>

# Testé en Java Jar / Python / C++
