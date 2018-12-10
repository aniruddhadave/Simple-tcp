package com.aniruddha.tcp;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class TCPClient {

	public static void main(String[] args) {
		String message;
		String response;
		
		try {
			Socket socket = new Socket("localhost", 50000);
			BufferedReader brClient = new BufferedReader(new InputStreamReader(System.in));
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			BufferedReader brServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			message = brClient.readLine();
			out.writeBytes(message + "\n");
			
			System.out.println("Enter lowercase message: ");
			response = brServer.readLine();
			System.out.println("Server response: " + response);
			
			socket.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
