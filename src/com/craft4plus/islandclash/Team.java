package com.craft4plus.islandclash;

public enum Team {

	RED, BLUE, YELLOW;
	
	public String toString() {
		switch (this) {
		case RED:
			return "Red";
		case BLUE:
			return "Blue";
		case YELLOW:
			return "Yellow";
		}
		return null;
	}
	
}
