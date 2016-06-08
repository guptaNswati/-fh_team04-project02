/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kamisado.websocket.server;

import java.io.BufferedReader;
import java.io.StringReader;
import java.math.BigDecimal;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import javax.enterprise.context.ApplicationScoped;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.HashMap;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonArray;


/**
 * WebSocketServer for CS40A Team04Project02
 * @author chrisB
 */


@ApplicationScoped
@ServerEndpoint("/actions")
public class WebSocketServer {
    
    private static int sessionCount=0;
    //private static Session[] playerSessions = new Session[10];
    private static  Map<Integer,KamisadoSessionPair> gameSessions =
            new ConcurrentHashMap<Integer,KamisadoSessionPair>();
    
    @OnOpen
    public void open(Session session) {
        
        System.out.println("in open(Session) ...");
        
        int count = sessionCount++;
        
        int player = (count % 2); // 1/0
        int game = count/2;   // 0,1,2,3...
        
        KamisadoSessionPair pair = gameSessions.get( game );
        if (pair == null ) pair = new KamisadoSessionPair();
        
        System.out.println("constructed SessionPair");
        
        pair.set(player,session);
        System.out.println("set Session in pair...");
        
        gameSessions.put(game, pair);
        System.out.println("saved Pair in Map");
       
        session.getUserProperties().put("player", player );
        session.getUserProperties().put("game", game );

        System.out.println("open...game("+game+") -- player("+player+") -- sessionCount="+sessionCount);
        
        // Send message back to browser with Player color ( WHITE / BLACK )
        
        JsonObjectBuilder bldr = Json.createObjectBuilder();
        
        String playerString= player==0?"WHITE":"BLACK";
        bldr.add("type", "login");
        bldr.add("player",playerString);
        
        sendMessage(session, bldr.build().toString());
        
        if ( player==1 ) {
            sendPlayMessage( pair );
        }
        
    }

    @OnClose
        public void close(Session session) {
    }

    @OnError
        public void onError(Throwable error) {
    }

    @OnMessage
        public void handleMessage(String message, Session session) {
            
            JsonObject jsonObj = Json.createReader( new BufferedReader( new StringReader( message) )).readObject();

            int player = (Integer) session.getUserProperties().get("player");
            int game = (Integer) session.getUserProperties().get("game");
            
            KamisadoSessionPair pair = gameSessions.get(game);
            if ( pair.getSession(1)==null || pair.getSession(0)==null ) return;
            
            int otherPlayer = ( player==0)?1:0;
            Session otherSession = pair.getSession(otherPlayer);
            Session thisSession = pair.getSession(player);
                          
            switch ( jsonObj.getString("type") ) {
                                   
                    case "move":
                        
                        sendMessage( otherSession, message );
                        break;
                        
                    case "nickname":
                        
                        thisSession.getUserProperties().put("nickname", jsonObj.getString("nickname"));
                        break;
                        
                    case "chat":
                        
                        sendMessage( otherSession, message );
                        break;

            }
    }
        
    private void sendPlayMessage( KamisadoSessionPair pair ) {
        
        JsonObjectBuilder bldr = Json.createObjectBuilder();
        
        bldr.add("type", "play" );
        
        try {
        
            sendMessage( pair.getSession(0), bldr.build().toString() );
            sendMessage( pair.getSession(1), bldr.build().toString() );
        
        }
        catch( Exception ex ) {
            
            System.out.println("Error while sending 'play' message...");
        
        }
    }
    
    private void sendMessage( Session s, String msg ) {
        
        try {
            
            s.getBasicRemote().sendText(msg);
            
        }
        catch( Exception ex ) {
            
            System.out.println("Exception while sneding message to browser...");
            
        }
    }
}
