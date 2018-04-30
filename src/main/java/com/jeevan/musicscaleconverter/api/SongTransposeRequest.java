package com.jeevan.musicscaleconverter.api;

public class SongTransposeRequest {
	private String fromScale;
	private String toScale;
	private String song;

	public String getFromScale() {
		return fromScale;
	}

	public void setFromScale(String fromScale) {
		this.fromScale = fromScale;
	}

	public String getToScale() {
		return toScale;
	}

	public void setToScale(String toScale) {
		this.toScale = toScale;
	}

	public String getSong() {
		return song;
	}

	public void setSong(String song) {
		this.song = song;
	}

}
