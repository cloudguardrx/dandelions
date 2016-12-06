package org.cg.dandelions.model;

import org.bson.Document;

public class Movement {

	/*-
	 * Examples Include: Squat, Run, Doube Under
	 *     
	 * Relations:
	 * Movement have-many tags
	 * 
	 */

	public Movement() {
	}

	public Movement(Document document){
		this.id = document.getObjectId("_id").toHexString();
		this.name = document.getString("name");
		this.description = document.getString("description");
				
	}

	public String id;
	public String name;
	public String description;

}
