package cn.chaseshu.kafka.test;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Properties;
import java.util.concurrent.Future;

public class ProducerTest {

    public static void main(String[] args) {

        Properties kafkaProps = new Properties();
        kafkaProps.put("bootstrap.servers", "localhost:9092");
        kafkaProps.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        kafkaProps.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        KafkaProducer<String, String> producer = new KafkaProducer<>(kafkaProps);


        ProducerRecord<String, String> record = new ProducerRecord<>("test", "hello" + System.currentTimeMillis());

        try {
            Future<RecordMetadata> future = producer.send(record);
            RecordMetadata metadata = future.get();
            System.out.println(metadata.topic());
            System.out.println(metadata.partition());

        }catch (Exception e){
            e.printStackTrace();
        }



    }
}
