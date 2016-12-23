package com.neet.DiamondHunter.Main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * This is a class to write coordinates of axe, boat, player and diamonds into a
 * text file namely Item-Coordinates.txt If the file does not exist, create the
 * file and write all default position.
 * 
 * @return The coordinates which is needed. Arrangement: line 1 :
 *         {@code AXE_xaxis, AXE_yaxis, BOAT_xaxis, BOAT_yaxis} line 2 :
 *         {@code player_xaxis, player_yaxis} line 3-17:
 *         {@code diamond_xaxis, diamond_yaxis}
 **/

public class WriteCoord {

	private static File coordFile = new File("Entity-Coordinates.txt");
	
	/**
	 * Retrieve coordinates from the file
	 * @param line The line of coordinates which correspond to the entity to be retrieved
	 * @return The coordinates
	 */
	public static int[] getCoord(int line) {
		// File exist and is ready to be read
		if (coordFile.canRead()) {
			try {

				FileInputStream rdCoords = new FileInputStream(coordFile);
				byte[] data = new byte[(int) coordFile.length()];

				// Read the entire file in one go
				rdCoords.read(data);
				rdCoords.close();
				String[] strLines = new String(data, "UTF-8").split("\n");
				String[] strCoords;
				String[] temp = new String[2];
				// Get only the line for axe/boat coordinates or player
				// coordinate
				if (line == 1) //Axe and boat
					strCoords = new String(strLines[line - 1]).trim().split(",");
				else if(line == 2) //Player
					strCoords = new String(strLines[line - 1]).trim().split(",");
				else { //Diamonds
					int k = 0;
					strCoords = new String[strLines.length * 2 - 4];
					for(int i = line - 1; i < strLines.length; i++) {
						temp = new String(strLines[i]).trim().split(",");
						for(int j = 0; j < temp.length; j++) {
							strCoords[k++] = temp[j];
						}
					}
				}
				
				// Get the coordinates
				int[] coords = new int[strCoords.length];
				for (int i = 0; i < strCoords.length; i++) {
					if(strCoords[i] != null) {
						coords[i] = Integer.parseInt(strCoords[i]);
					}
				}
				return coords;
			} catch (FileNotFoundException e) {
				System.err.println("File does not exist");
				e.printStackTrace();
			} catch (IOException e) {
				System.err.println("No read access to file");
				e.printStackTrace();
			}
		} else {
			System.err.println("Error in reading file");
			return null;
		}
		return null;
	}
}
