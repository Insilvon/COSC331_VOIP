/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cosc331_voipClient;

/**
 *
 * @author crcrowe0, emjetton0
 */
public class VoipClient {
    /**
     * Boolean variable that establishes if the client is currently recording.
     */
    public static boolean online = false;

    /**
     * Heartbeat method which creates a new Frame and begins the program.
     * @param args
     */
    public static void main(String[] args) {
        ClientFrame frame = new ClientFrame();  //create new frame
        frame.setVisible(true);     //display frame to user
    }
    
}
