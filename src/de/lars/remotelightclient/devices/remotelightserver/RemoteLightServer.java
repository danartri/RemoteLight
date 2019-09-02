package de.lars.remotelightclient.devices.remotelightserver;

import java.awt.Color;

import de.lars.remotelightclient.devices.ConnectionState;
import de.lars.remotelightclient.devices.Device;

public class RemoteLightServer extends Device {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 768993097355819403L;
	private String ip;
	private RLClient client;

	public RemoteLightServer(String id, String ip) {
		super(id);
		this.ip = ip;
		client = new RLClient(ip);
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
		client.setHostname(ip);
	}
	
	public RLClient getClient() {
		return client;
	}

	@Override
	public void send(Color[] pixels) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ConnectionState connect() {
		return client.connect();
	}

	@Override
	public ConnectionState disconnect() {
		return client.disconnect();
	}

	@Override
	public ConnectionState getConnectionState() {
		return client.getState();
	}

}