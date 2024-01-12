package com.lucas.websocket;

import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import javax.websocket.server.ServerEndpoint;

/**
 * @author Lucas
 * @Description TODO
 * @date 2023-06-16 10:08
 */
@ServerEndpoint("sss")
public class WebSocketTest extends TextWebSocketHandler implements WebSocketHandler {

}
