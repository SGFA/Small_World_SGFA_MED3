package example;

import java.util.ArrayList;

/**
 * Creates a field, using the TerrainType enumerator as a parameter to set the terrain type.
 * @param  TerrainType an enumerator which sets the type of water. 
 * Example: Terraintype.WATER
 * @see TerrainType
 */
public class Field {

	// The innate defence value of a field. Starts at 2, which is set in the constructor below. 
	// The idea is that this value will always equal itself + the size of the arraylist of units, 
	// and can be modified by other methods as required.
	private int defenceValue;

	// booleans to check if a field contains any of the the three innate resources
	private boolean containingMagic = false;
	private boolean containingMines = false;
	private boolean containingMountains = false;
	
	/**
	 * Boolean to check if a field is adjacent to border of map. Set to false  
	 * by default.
	 */
	private boolean borderPosition = false;
	
	/**
	 * Conquerable is true by default and must be set to false for water fields
	 */ 
	private boolean conquerable = true;

	/**
	 * The type of a terrain (water, swamp, farmland, etc.) is set here
	 */ 
	private String terrainType;

	/**
	 * Contains all the fields adjacent to this field
	 * @see Field.isAdjacentTo();
	 */
	ArrayList<Field> adjacencies = new ArrayList<Field>();

	// This array is supposed to be an array of units, we used strings as we don't have the 
	// unit class yet
	private int amountOfUnits = 0;
	
	private int fieldOwner = 0;
	
	/**
	 * @param  terrainType an enumerator which sets the type of terrain. 
	 * Example: Terraintype.WATER
	 * @see TerrainType
	 */	
	public Field(TerrainType terrainType, ArrayList<Field> allFields) {
		// Constructor
		
		allFields.add(this);
		
		setDefenceValue(2);

		setTerrainType(terrainType);
		
		// If statement which sets conquerable to true if field is water
		if (this.terrainType.equals("Water")) {
			setConquerable(false);
		}
		
		
		

	}

	/**
	 * Method that uses a switch and the construction parameters to set the terrain type for 
	 * the field via our TerrainType enumerator.
	 * @param  terrainType an enumerator which sets the type of terrain. 
	 * Example: Terraintype.WATER
	 */ 
	private void setTerrainType(TerrainType terrainType) {
		switch (terrainType) {
		case WATER:
			this.terrainType = "Water";
			break;
		case FOREST:
			this.terrainType = "Forest";
			break;
		case HILL:
			this.terrainType = "Hill";
			break;
		case SWAMP:
			this.terrainType = "Swamp";
			break;
		case MOUNTAINLAND:
			this.terrainType = "Mountainland";
			break;
		case FARMLAND:
			this.terrainType = "Farmland";
			break;


		}
	}

	/**
	 * Method which checks if this field is adjacent to another field
	 * @param otherField The field it compares to
	 * @return True or false
	 */
	public boolean isAdjacentTo(Field otherField) {
		if (adjacencies.contains(otherField)) return true;
		else return false;
	}

	// Everything below this line is just encapsulation methods for the various variables for
	// maximum object-orientation

	int getDefenceValue() {
		return defenceValue;
	}

	void setDefenceValue(int defenceValue) {
		this.defenceValue = defenceValue;
	}

	// Notice lack of set method for terrainType - it's not needed, as it's always locked in 
	// upon instantiation
	String getTerrainType() {
		return terrainType;
	}

	boolean isContainsMagic() {
		return containingMagic;
	}

	void setContainsMagic(boolean containingMagic) {
		this.containingMagic = containingMagic;
	}

	boolean isContainsMines() {
		return containingMines;
	}

	void setContainsMines(boolean containingMines) {
		this.containingMines = containingMines;
	}

	boolean isContainsMountains() {
		return containingMountains;
	}

	void setContainsMountains(boolean containingMountains) {
		this.containingMountains = containingMountains;
	}

	boolean isBorderPosition() {
		return borderPosition;
	}

	void setBorderPosition(boolean borderPosition) {
		this.borderPosition = borderPosition;
	}

	boolean isConquerable() {
		return conquerable;
	}

	// This method is private as conquerable is defined only in constructor
	private void setConquerable(boolean conquerable) {
		this.conquerable = conquerable;
	}

	int getAmountOfUnits() {
		return amountOfUnits;
	}

	void setAmountOfUnits(int amountOfUnits) {
		this.amountOfUnits = amountOfUnits;
	}

	int getFieldOwner() {
		return fieldOwner;
	}

	void setFieldOwner(int fieldOwner) {
		this.fieldOwner = fieldOwner;
	}

}
