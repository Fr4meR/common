/**
 * Copyright (C) 2018 Tobias Hess
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.framersoft.common.dice;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

import de.framersoft.common.utility.ParamUtility;

/**
 * This class represents a dice with the given amount of sides.
 * 
 * @author Tobias Hess
 * @since 2018-12-01
 */
public class Dice {
	
	private int sides;
	
	/**
	 * Constructor
	 * @param sides
	 * 		The number of sides of the dice.
	 */
	public Dice(int sides) {
		ParamUtility.checkZeroNegative(sides);
		this.sides = sides;
	}
	
	/**
	 * Rolls the dice.
	 * @return
	 * 		The result of the roll.
	 */
	public int roll() {
		ThreadLocalRandom random = ThreadLocalRandom.current();
		return random.nextInt(1, sides + 1);
	}

	/**
	 * @return
	 * 		The amount of sides the dice has.
	 */
	public int getSides() {
		return sides;
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(!(obj instanceof Dice)) return false;
		Dice compare = (Dice) obj;
		return Objects.equals(this.sides, compare.sides);
	}

	@Override
	public int hashCode() {
		return Objects.hash(sides);
	}

	@Override
	public String toString() {
		return "Dice={sides=" + sides + "}";
	}
	
	
}
