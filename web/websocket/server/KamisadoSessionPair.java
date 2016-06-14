/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kamisado.websocket.server;

import javax.websocket.Session;

/**
 *
 * @author chris
 */
public class KamisadoSessionPair {
    
    private Session[] playerSessions;
    
    public KamisadoSessionPair() {
    
        playerSessions = new Session[2];
        
    }
    
    public void set(int player, Session s ) {
        
        playerSessions[player] = s;
        
    }
    
    public Session getSession(int player ) {
        
        return playerSessions[player];
        
    }
    
}
