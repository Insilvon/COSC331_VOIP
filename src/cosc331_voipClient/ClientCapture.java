/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cosc331_voipClient;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.TargetDataLine;

/**
 *
 * @author colin
 */
public class ClientCapture extends Thread{
    public TargetDataLine audioInput = null;
    public DatagramSocket dout;
    byte byteBuffer[] = new byte[512];
    public InetAddress serverIP;
    public int serverPort;
    @Override
    public void run(){
        int i = 0;
        while(VoipClient.calling){
            audioInput.read(byteBuffer, 0, byteBuffer.length);
            DatagramPacket data = new DatagramPacket(byteBuffer, byteBuffer.length, serverIP, serverPort);
            System.out.println("send #"+i++);
            try {
                dout.send(data);
            } catch (IOException ex) {
                Logger.getLogger(ClientCapture.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        audioInput.close();
        audioInput.drain();
        System.out.println("Ending thread");
    }
}
