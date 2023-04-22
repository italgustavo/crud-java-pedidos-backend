package com.italgustavo.gestao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GestaoPedidosBackendApplication {

	public static void main(String[] args) {
		try {
			SpringApplication.run(GestaoPedidosBackendApplication.class, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
