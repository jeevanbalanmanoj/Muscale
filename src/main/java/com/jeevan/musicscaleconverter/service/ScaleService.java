package com.jeevan.musicscaleconverter.service;

import java.util.Map;

import org.springframework.stereotype.Service;
@Service
public class ScaleService {

	static String notes[];
	static Integer[] majorScaleSequence;
	static Integer[] minorScaleSequence;

	static {
		notes = new String[12];
		notes[0] = "C";
		notes[1] = "C#";
		notes[2] = "D";
		notes[3] = "D#";
		notes[4] = "E";
		notes[5] = "F";
		notes[6] = "F#";
		notes[7] = "G";
		notes[8] = "G#";
		notes[9] = "A";
		notes[10] = "A#";
		notes[11] = "B";

		majorScaleSequence = new Integer[] { 2, 2, 1, 2, 2, 2, 1 };
		minorScaleSequence = new Integer[] { 2, 1, 2, 2, 1, 2, 2 };

	}

	public String getScale(String rootNote, Integer[] scaleSequence) {

		String scale = null;

		Integer startingIndex = 0;
		for (int i = 0; i < notes.length; i++) {
			if (notes[i].equals(rootNote)) {
				startingIndex = i;
				break;
			}
		}

		Integer index = startingIndex;
		scale = notes[index] + " ";
		for (Integer gap : scaleSequence) {
			index += gap;
			scale += notes[index % 12] + " ";
		}

		return scale;
	}

	public String transposeScale(String toKey, String fromKey, String source) {

		String result = null;
		String fromScale = getScale(toKey, majorScaleSequence);
		String toScale = getScale(fromKey, majorScaleSequence);
		String fromScaleNotes[] = fromScale.trim().split("\\s+");
		String toScaleNotes[] = toScale.trim().split("\\s+");
		result = source;
		for (int i = 0; i < fromScaleNotes.length; i++) {

			result = result.replaceAll("(?<!\\S)" + fromScaleNotes[i] + "(?!\\S)", "H" + toScaleNotes[i]);
		}
		return result.replaceAll("H", "");

	}

}
