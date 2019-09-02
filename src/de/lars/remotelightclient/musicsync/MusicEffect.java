package de.lars.remotelightclient.musicsync;

import de.lars.remotelightclient.musicsync.sound.SoundProcessing;

public class MusicEffect {
	
	private String name;
	private String displayname;
	private boolean bump;
	private float pitch;
	private double pitchTime;
	private double volume;
	private SoundProcessing soundProcessor;
	private double sensitivity;
	private double maxSpl, minSpl, spl;
	
	
	public MusicEffect(String name) {
		this.name = name;
		this.displayname = name; //TODO Language system
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDisplayname() {
		return displayname;
	}

	public void setDisplayname(String displayname) {
		this.displayname = displayname;
	}
	
	public boolean isBump() {
		return bump;
	}

	public void setBump(boolean bump) {
		this.bump = bump;
	}

	public float getPitch() {
		return pitch;
	}

	public void setPitch(float pitch) {
		this.pitch = pitch;
	}

	public double getPitchTime() {
		return pitchTime;
	}

	public void setPitchTime(double pitchTime) {
		this.pitchTime = pitchTime;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	//TODo add onRender()
	
	public SoundProcessing getSoundProcessor() {
		return soundProcessor;
	}

	public void setSoundProcessor(SoundProcessing soundProcessor) {
		this.soundProcessor = soundProcessor;
	}

	public double getSensitivity() {
		return sensitivity;
	}

	public void setSensitivity(double sensitivity) {
		this.sensitivity = sensitivity;
	}

	public double getMaxSpl() {
		return maxSpl;
	}

	public void setMaxSpl(double maxSpl) {
		this.maxSpl = maxSpl;
	}

	public double getMinSpl() {
		return minSpl;
	}

	public void setMinSpl(double minSpl) {
		this.minSpl = minSpl;
	}

	public double getSpl() {
		return spl;
	}

	public void setSpl(double spl) {
		this.spl = spl;
	}

	public void onEnable() {}
	public void onDisable() {}
	public void onLoop() {}

}