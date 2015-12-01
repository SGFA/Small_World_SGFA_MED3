package Map;

import java.util.ArrayList;

public class MapTwoPlayer extends Map {
	
			
	Field field1pt1 = new Field(TerrainType.WATER 			,fields 		,0		,56		);
	Field field1pt2 = new Field(TerrainType.FARMLAND		,fields 		,206	,56		);
	Field field1pt3 = new Field(TerrainType.FOREST			,fields 		,334	,56		);
	Field field1pt4 = new Field(TerrainType.SWAMP			,fields 		,418	,56		);
	Field field1pt5 = new Field(TerrainType.HILL			,fields	 		,582	,56		);
		                                                                         
	Field field2pt1 = new Field(TerrainType.MOUNTAINLAND	,fields 		,0		,131	);
	Field field2pt2 = new Field(TerrainType.HILL			,fields 		,215	,141	);
	Field field2pt3 = new Field(TerrainType.WATER			,fields 		,321	,56		);
	Field field2pt4 = new Field(TerrainType.MOUNTAINLAND	,fields 		,425	,134	);
	Field field2pt5 = new Field(TerrainType.FARMLAND		,fields 		,520	,106	);
	Field field2pt6 = new Field(TerrainType.FOREST			,fields 		,639	,106	);
	                                                                             
	Field field3pt1 = new Field(TerrainType.FARMLAND		,fields 		,0		,233	);
	Field field3pt2 = new Field(TerrainType.FOREST			,fields 		,228	,252	);
	Field field3pt3 = new Field(TerrainType.FARMLAND		,fields 		,421	,237	);
	Field field3pt4 = new Field(TerrainType.HILL			,fields 		,521	,184	);
	Field field3pt5 = new Field(TerrainType.MOUNTAINLAND	,fields 		,698	,210	);
	                                                                             
	Field field4pt1 = new Field(TerrainType.SWAMP			,fields 		,0		,334	);
	Field field4pt2 = new Field(TerrainType.HILL			,fields 		,120	,323	);
	Field field4pt3 = new Field(TerrainType.SWAMP			,fields 		,327	,359	);
	Field field4pt4 = new Field(TerrainType.MOUNTAINLAND	,fields 		,434	,396	);
	Field field4pt5 = new Field(TerrainType.SWAMP			,fields 		,543	,326	);
	Field field4pt6 = new Field(TerrainType.FOREST			,fields 		,641	,294	);
	Field field4pt7 = new Field(TerrainType.WATER			,fields 		,622	,346	);
	
	public MapTwoPlayer() {
		create();
	}
	
	public void create() {	
		defineAdjacencies();
		setBorders();
		setAttributes();
	}

	public void setAttributes() {
		field1pt2.setContainsMagic(true);
		field1pt3.setContainsMines(true);
		field1pt4.setContainsMountains(true);
		field2pt1.setContainsMines(true);
		field2pt1.setContainsMountains(true);
		field2pt6.setContainsMagic(true);
		field3pt3.setContainsMagic(true);
		field3pt4.setContainsMountains(true);
		field3pt5.setContainsMines(true);
		field4pt1.setContainsMagic(true);
		field4pt3.setContainsMines(true);
	}

	public void setBorders() {
		field1pt1.setBorderPosition(true);
		field1pt2.setBorderPosition(true);
		field1pt3.setBorderPosition(true);
		field1pt4.setBorderPosition(true);
		field1pt5.setBorderPosition(true);
		field2pt1.setBorderPosition(true);
		field2pt6.setBorderPosition(true);
		field3pt1.setBorderPosition(true);
		field3pt5.setBorderPosition(true);
		field4pt1.setBorderPosition(true);
		field4pt2.setBorderPosition(true);
		field4pt3.setBorderPosition(true);
		field4pt4.setBorderPosition(true);
		field4pt5.setBorderPosition(true);
		field4pt7.setBorderPosition(true);
	}

	public void defineAdjacencies() {
		field1pt1.adjacencies.add(field1pt2);
		field1pt1.adjacencies.add(field2pt1);
		
		field1pt2.adjacencies.add(field1pt1);
		field1pt2.adjacencies.add(field2pt1);
		field1pt2.adjacencies.add(field2pt2);
		field1pt2.adjacencies.add(field1pt3);
		
		field1pt3.adjacencies.add(field1pt2);
		field1pt3.adjacencies.add(field2pt2);
		field1pt3.adjacencies.add(field2pt3);
		field1pt3.adjacencies.add(field2pt4);
		field1pt3.adjacencies.add(field1pt4);
		
		field1pt4.adjacencies.add(field1pt3);
		field1pt4.adjacencies.add(field2pt4);
		field1pt4.adjacencies.add(field2pt5);
		field1pt4.adjacencies.add(field1pt5);
		
		field1pt5.adjacencies.add(field1pt4);
		field1pt5.adjacencies.add(field2pt5);
		field1pt5.adjacencies.add(field2pt6);
		
		
		field2pt1.adjacencies.add(field1pt1);
		field2pt1.adjacencies.add(field1pt2);
		field2pt1.adjacencies.add(field2pt2);
		field2pt1.adjacencies.add(field3pt1);
		
		field2pt2.adjacencies.add(field2pt1);
		field2pt2.adjacencies.add(field1pt2);
		field2pt2.adjacencies.add(field1pt3);
		field2pt2.adjacencies.add(field2pt3);
		field2pt2.adjacencies.add(field3pt2);
		field2pt2.adjacencies.add(field3pt1);
		
		field2pt3.adjacencies.add(field1pt3);
		field2pt3.adjacencies.add(field2pt4);
		field2pt3.adjacencies.add(field3pt3);
		field2pt3.adjacencies.add(field3pt2);
		field2pt3.adjacencies.add(field2pt2);
		
		field2pt4.adjacencies.add(field1pt4);
		field2pt4.adjacencies.add(field2pt5);
		field2pt4.adjacencies.add(field3pt4);
		field2pt4.adjacencies.add(field3pt5);
		field2pt4.adjacencies.add(field2pt3);
		field2pt4.adjacencies.add(field1pt3);
		
		field2pt5.adjacencies.add(field1pt4);
		field2pt5.adjacencies.add(field1pt5);
		field2pt5.adjacencies.add(field2pt6);
		field2pt5.adjacencies.add(field3pt4);
		field2pt5.adjacencies.add(field2pt4);
		
		
		field3pt1.adjacencies.add(field2pt1);
		field3pt1.adjacencies.add(field2pt2);
		field3pt1.adjacencies.add(field3pt2);
		field3pt1.adjacencies.add(field4pt2);
		field3pt1.adjacencies.add(field4pt1);
		
		field3pt2.adjacencies.add(field2pt2);
		field3pt2.adjacencies.add(field2pt3);
		field3pt2.adjacencies.add(field3pt3);
		field3pt2.adjacencies.add(field4pt3);
		field3pt2.adjacencies.add(field4pt2);
		field3pt2.adjacencies.add(field3pt1);
		
		field3pt3.adjacencies.add(field2pt3);
		field3pt3.adjacencies.add(field2pt4);
		field3pt3.adjacencies.add(field3pt4);
		field3pt3.adjacencies.add(field4pt5);
		field3pt3.adjacencies.add(field4pt4);
		field3pt3.adjacencies.add(field4pt3);
		field3pt3.adjacencies.add(field3pt2);
		
		field3pt4.adjacencies.add(field2pt4);
		field3pt4.adjacencies.add(field2pt5);
		field3pt4.adjacencies.add(field2pt6);
		field3pt4.adjacencies.add(field3pt5);
		field3pt4.adjacencies.add(field4pt6);
		field3pt4.adjacencies.add(field4pt5);
		field3pt4.adjacencies.add(field3pt3);
		
		field3pt5.adjacencies.add(field2pt6);
		field3pt5.adjacencies.add(field4pt7);
		field3pt5.adjacencies.add(field4pt6);
		field3pt5.adjacencies.add(field3pt4);
		
		field4pt1.adjacencies.add(field3pt1);
		field4pt1.adjacencies.add(field4pt2);
		
		field4pt2.adjacencies.add(field4pt1);
		field4pt2.adjacencies.add(field3pt1);
		field4pt2.adjacencies.add(field3pt2);
		field4pt2.adjacencies.add(field4pt3);
		
		field4pt3.adjacencies.add(field4pt2);
		field4pt3.adjacencies.add(field3pt2);
		field4pt3.adjacencies.add(field3pt3);
		field4pt3.adjacencies.add(field4pt4);

		field4pt4.adjacencies.add(field4pt3);
		field4pt4.adjacencies.add(field3pt3);
		field4pt4.adjacencies.add(field4pt5);
		
		field4pt5.adjacencies.add(field4pt4);
		field4pt5.adjacencies.add(field3pt3);
		field4pt5.adjacencies.add(field3pt4);
		field4pt5.adjacencies.add(field4pt6);
		field4pt5.adjacencies.add(field4pt7);
		
		field4pt6.adjacencies.add(field3pt4);
		field4pt6.adjacencies.add(field3pt5);
		field4pt6.adjacencies.add(field4pt7);
		field4pt6.adjacencies.add(field4pt5);
		
		field4pt7.adjacencies.add(field4pt5);
		field4pt7.adjacencies.add(field4pt6);
		field4pt7.adjacencies.add(field3pt5);
	}

}
