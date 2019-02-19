/*
 * Copyright (c) 2019 Anzen Soluciones S.A. de C.V.
 * Mexico D.F.
 * All rights reserved.
 *
 * THIS SOFTWARE IS  CONFIDENTIAL INFORMATION PROPIETARY OF ANZEN SOLUCIONES.
 * THIS INFORMATION SHOULD NOT BE DISCLOSED AND MAY ONLY BE USED IN ACCORDANCE THE TERMS DETERMINED BY THE COMPANY ITSELF.
 */
package mx.com.anzen.app.abanking.translator.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import mx.com.anzen.abanking.integration.configurations.common.rabbitmq.RabbitMqConfiguration;
import mx.com.anzen.abanking.integration.configurations.server.flows.IntegrationFlowsConfiguration;

/**
 * <p></p>
 * 
 * @author acevedito
 * @version login-translator
 * @since login-translator
 */
@ComponentScan(basePackages = {
        "mx.com.anzen.app.abanking.translator.test"
})
@EnableAutoConfiguration(exclude = {
        MongoDataAutoConfiguration.class,
        DataSourceAutoConfiguration.class,
        RedisAutoConfiguration.class,
        RabbitAutoConfiguration.class
})
@Import(value = {
        IntegrationFlowsConfiguration.class,
        RabbitMqConfiguration.class
})
public class Application {

    public static void main( String[] args ) {
        SpringApplication.run(Application.class, args);
    }
}
