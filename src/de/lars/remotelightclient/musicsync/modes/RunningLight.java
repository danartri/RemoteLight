package de.lars.remotelightclient.musicsync.modes;

import de.lars.remotelightclient.musicsync.MusicEffect;
import de.lars.remotelightclient.network.Client;
import de.lars.remotelightclient.network.Identifier;

public class RunningLight extends MusicEffect {
	
	private double lastTime = 0;

	public RunningLight() {
		super("RunningLight");
	}
	
	@Override
	public void onLoop() {
		double pitch = this.getPitch();
		double time = this.getPitchTime();
		
		if(time != lastTime) {
			lastTime = time;
			int r = 0, g = 0, b = 0;
			
			if(pitch < 50) {
				r = 180;
			} else if(pitch < 200) {
				r = 250;
				g = 20;
			} else if(pitch < 400) {
				r = 50; g = 250;
			} else if(pitch < 800) {
				g = 250;
			} else if(pitch < 1000) {
				g = 250;
				b = 50;
			} else if(pitch < 1600) {
				b = 250;
			} else {
				b = 250;
				g = 150;
			}
			
			Client.send(new String[] {Identifier.WS_SHIFT_RIGHT, 3+""});
			for(int i = 0; i < 3; i++) {
				Client.send(new String[] {Identifier.WS_COLOR_PIXEL, i+"", r+"", g+"", b+""});
			}
		} else {
			Client.send(new String[] {Identifier.WS_SHIFT_RIGHT, 3+""});
			for(int i = 0; i < 3; i++) {
				Client.send(new String[] {Identifier.WS_COLOR_PIXEL, i+"", 0+"", 0+"", 0+""});
			}
		}
		super.onLoop();
	}

}