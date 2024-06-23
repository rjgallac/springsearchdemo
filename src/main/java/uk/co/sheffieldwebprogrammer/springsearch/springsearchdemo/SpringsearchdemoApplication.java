package uk.co.sheffieldwebprogrammer.springsearch.springsearchdemo;

import co.elastic.clients.elasticsearch.indices.CreateIndexRequest;
import co.elastic.clients.elasticsearch.indices.DeleteIndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.aot.AbstractAotProcessor;

@SpringBootApplication
public class SpringsearchdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringsearchdemoApplication.class, args);
	}


}
