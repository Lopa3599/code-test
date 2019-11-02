package com.ge.exercise2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayQuadrantUtil {

	private int quadrantSize;

	char[][] data;

	public ArrayQuadrantUtil(char[][] data) {
		this.data = data;
		this.quadrantSize = data.length / 2;
	}

	public char[] getQuadrantValues(int row, int column) {

		List<Character> tempList = new ArrayList<>();

		char[][] temp = new char[this.quadrantSize][];

		for (int r = 0; r < this.quadrantSize; r++) {
			temp[r] = Arrays.copyOfRange(data[row + r], column, column + quadrantSize);
		}

		if (temp.length > 0) {

			for (int i = 0; i < temp.length; i++) {

				for (int j = 0; j < temp[i].length; j++) {

					char value = temp[i][j];

					tempList.add(value);

				}
			}
		}

		char[] quadrantArray = new char[tempList.size()];

		int i = 0;

		for (Character item : tempList) {

			quadrantArray[i] = item;

			i++;
		}
		
		System.out.println(quadrantArray);

		return quadrantArray;
	}
}
