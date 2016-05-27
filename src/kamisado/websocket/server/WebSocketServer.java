/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kamisado.websocket.server;

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
            new HashMap<Integer,KamisadoSessionPair>();
    
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
    }

    @OnClose
        public void close(Session session) {
    }

    @OnError
        public void onError(Throwable error) {
    }

    @OnMessage
        public void handleMessage(String message, Session session) {
            
            int player = (Integer) session.getUserProperties().get("player");
            int game = (Integer) session.getUserProperties().get("game");
            
            System.out.println("message from player "+player+" game "+game+" :"+message);

            KamisadoSessionPair pair = gameSessions.get(game);
            if ( pair.getSession(1)==null || pair.getSession(0)==null ) return; 
            
            int otherPlayer = ( player==0)?1:0;
            Session otherSession = pair.getSession(otherPlayer);
            
            try {
                otherSession.getBasicRemote().sendText(message);
            }
            catch( Exception ex ) {
                ex.printStackTrace();
            } 
    }
}
