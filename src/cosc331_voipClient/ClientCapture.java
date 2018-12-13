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
 * @author crcrowe0, emjetton0
 */
public class ClientCapture extends Thread{
    /**
     * DataLine which reads the recorded input
     */
    public TargetDataLine audioInput = null;
    /**
     * Socket that controls output data
     */
    public DatagramSocket dataOutput;
    /**
     * Buffer which saves voice data. 512 bytes.
     */
    byte byteBuffer[] = new byte[512];
    /**
     * Address of the target server.
     */
    public InetAddress serverIP;
    /**
     * Port of the target server.
     */
    public int serverPort;

    /**
     * Thread-implemented metod. Will read data from this class, package it, and send it.
     */
    @Override
    public void run(){
        int i = 0;
        while(VoipClient.online){
            audioInput.read(byteBuffer, 0, byteBuffer.length);
            DatagramPacket data = new DatagramPacket(byteBuffer, byteBuffer.length, serverIP, serverPort);
            System.out.println("send #"+i++);
            try {
                dataOutput.send(data);
            } catch (IOException ex) {
                Logger.getLogger(ClientCapture.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        audioInput.close();
        audioInput.drain();
        System.out.println("Ending thread");
    }
}
