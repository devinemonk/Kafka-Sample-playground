to enter in docker
docker exec -it kafka /bin/sh


to create a new topic
/bin/kafka-topics --create --replication-factor 1 --partitions 1 --topic KAFKA-SAMPLE-TOPIC --bootstrap-server localhost:29092


to produce message
/bin/kafka-console-producer --broker-list localhost:29092 --topic KAFKA-SAMPLE-TOPIC

to consume message
/bin/kafka-console-consumer --bootstrap-server localhost:29092 --topic KAFKA-SAMPLE-TOPIC --from-beginning


