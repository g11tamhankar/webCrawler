package com.hackathon.comtrac;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import org.eclipse.jetty.util.Jetty;

import spark.JettyLogger;

public class SocketConnection {

	public static boolean isListening(String hostIp, int port) {
		String hostName = null;
		Socket socket = null;
		try {
			hostName = InetAddress.getByName(hostIp).getHostName();
			socket = new Socket(hostName, 9443);
			socket.close();
			return true;
		} catch (UnknownHostException e) {			
			return false;
		} catch (IOException e) {
			return false;
		}
	}
}
