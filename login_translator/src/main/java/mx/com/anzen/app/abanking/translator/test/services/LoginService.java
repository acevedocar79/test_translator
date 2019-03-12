/*
 * Copyright (c) 2019 Anzen Soluciones S.A. de C.V.
 * Mexico D.F.
 * All rights reserved.
 *
 * THIS SOFTWARE IS  CONFIDENTIAL INFORMATION PROPIETARY OF ANZEN SOLUCIONES.
 * THIS INFORMATION SHOULD NOT BE DISCLOSED AND MAY ONLY BE USED IN ACCORDANCE THE TERMS DETERMINED BY THE COMPANY ITSELF.
 */
package mx.com.anzen.app.abanking.translator.test.services;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import mx.com.anzen.abanking.integration.configurations.common.util.IntegrationCommonConstants;
import mx.com.anzen.app.abanking.common.beans.dto.UserSession;

/**
 * <p></p>
 * 
 * @author acevedito
 * @version login-translator
 * @since login-translator
 */
@Service
public class LoginService {

    @ServiceActivator(inputChannel = "login", outputChannel = IntegrationCommonConstants.MAP_RESPONSE_CHANNEL_NAME)
    public Message<Map<String, Object>> login(Map<String, Object> input,
                                              @Headers Map<String, Object> headers,
                                              @Header(IntegrationCommonConstants.ABANKING_MONITORING_ID) String monitoringId) {

        String id_session = UUID.randomUUID().toString();
        Map<String, Object> output = new HashMap<>();
        output.put("id_session", id_session);

        return MessageBuilder
                .withPayload(output)
                .copyHeaders(headers)
                .setHeader(IntegrationCommonConstants.ABANKING_SESSION, id_session)
                .build();
    }

    @ServiceActivator(inputChannel = "logout", outputChannel = IntegrationCommonConstants.MAP_RESPONSE_CHANNEL_NAME)
    public Message<Map<String, Object>> logout(Map<String, Object> input,
                                               @Headers Map<String, Object> headers,
                                               @Header(IntegrationCommonConstants.ABANKING_SESSION) String userSession,
                                               @Header(IntegrationCommonConstants.ABANKING_MONITORING_ID) String monitoringId) {
        Map<String, Object> output = new HashMap<>();
        output.put("logout", true);

        return MessageBuilder.withPayload(output)
                .copyHeaders(headers)
                .removeHeader(IntegrationCommonConstants.ABANKING_SESSION)
                .build();
    }
}
