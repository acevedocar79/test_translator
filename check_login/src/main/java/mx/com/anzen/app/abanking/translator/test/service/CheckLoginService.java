/*
 * Copyright (c) 2019 Anzen Soluciones S.A. de C.V.
 * Mexico D.F.
 * All rights reserved.
 *
 * THIS SOFTWARE IS  CONFIDENTIAL INFORMATION PROPIETARY OF ANZEN SOLUCIONES.
 * THIS INFORMATION SHOULD NOT BE DISCLOSED AND MAY ONLY BE USED IN ACCORDANCE THE TERMS DETERMINED BY THE COMPANY ITSELF.
 */
package mx.com.anzen.app.abanking.translator.test.service;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import mx.com.anzen.abanking.integration.configurations.common.exception.TranslatorException;
import mx.com.anzen.abanking.integration.configurations.common.util.IntegrationCommonConstants;

/**
 * <p></p>
 * 
 * @author acevedito
 * @version test_Translator
 * @since test_Translator
 */
@Service
public class CheckLoginService {

    @ServiceActivator(inputChannel = "checkLogin", outputChannel = IntegrationCommonConstants.MAP_RESPONSE_CHANNEL_NAME)
    public Message<Map<String, Object>> login(Map<String, Object> input, @Headers Map<String, Object> headers) 
            throws TranslatorException {

        Map<String, Object> output = new HashMap<>();
        output.put("response", "checkLogin OK");

        return MessageBuilder
                .withPayload(output).copyHeaders(headers).build();
    }
}
