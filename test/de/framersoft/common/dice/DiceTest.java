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

import static org.junit.Assert.*;

import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;

import de.framersoft.common.dice.Dice;

/**
 * Test case for {@link Dice}
 * 
 * @author tshess
 *
 */
public class DiceTest {

	/**
	 * Tests if the constructor is throwing an exception on invalid parameters.
	 */
	@Test(expected = InvalidParameterException.class)
	public void testDice1() {
		new Dice(0);
	}

	/**
	 * Tests if the constructor is throwing an exception on invalid parameters.
	 */
	@Test(expected = InvalidParameterException.class)
	public void testDice2() {
		new Dice(-1);
	}

	/**
	 * Tests if the constructor is throwing an exception on invalid parameters.
	 */
	@Test(expected = InvalidParameterException.class)
	public void testDice3() {
		new Dice(-123);
	}

	/**
	 * Tests {@link Dice#getSides()}.
	 */
	@Test
	public void testGetSides() {
		Dice d = new Dice(6);
		assertEquals(6, d.getSides());
	}
	
	/**
	 * Tests the roll method of different sided {@link Dice}s.
	 */
	@Test
	public void testRoll() {
		Collection<Integer> sidesToTest = Arrays.asList(3, 6, 8, 10, 12, 20, 100);
		sidesToTest.stream().forEach(sides -> testRollingAvarage(sides));		
	}
	
	/**
	 * Tests if the expected average dice roll with given sides is correct. 
	 * @param sides
	 * 		The amount of sides for the dice to test.
	 */
	private void testRollingAvarage(int sides) {
		Dice d = new Dice(sides);
		long sum = 0;
		double avg = 0;
		for (int i = 0; i < 100000000; i++) {
			int roll = d.roll();
			sum += roll;
			avg = sum / (i + 1.0);
		}
		
		//Calculate the expected average roll
		double expectedAvg = 0;
		for(int i = 1; i <= sides; i++) {
			expectedAvg += i;
		}
		expectedAvg = expectedAvg / sides;
		
		assertEquals(expectedAvg, avg, 0.1);
	}
}
