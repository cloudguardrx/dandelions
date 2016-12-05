package org.cg.dandelions.model;

import java.util.Set;

public class Movement {

	/*-
	 * Examples Include: Squat, Run, Doube Under
	 *     
	 * Relations:
	 * Movement have-many tags
	 * 
	 */

	public String name;
	public String description;
	public Set<Tag> tags;

}
