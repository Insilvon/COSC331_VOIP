/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cosc331_voipClient;

/**
 *
 * @author colin
 */
public class VoipClient {

    public static boolean calling = false;
    public static void main(String[] args) {
        ClientFrame frame = new ClientFrame();
        frame.setVisible(true);
    }
    
}
