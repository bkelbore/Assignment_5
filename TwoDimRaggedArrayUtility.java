import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class TwoDimRaggedArrayUtility {

	public TwoDimRaggedArrayUtility() {
	}

	/**
	 * read from the file
	 */ 

	
	public static double[][] readFile(File file) throws FileNotFoundException {

		int RowNumber = 0;
		int ColmnNumber = 0;

		// read file
		Scanner readThisFile = new Scanner(file);

		String[][] mylist = new String[10][];
		while (readThisFile.hasNext()) {

			String[] list = readThisFile.nextLine().split(" ");

			mylist[RowNumber] = new String[list.length];

			// number of col
			ColmnNumber = list.length;

			for (int i = 0; i < list.length; i++)
				mylist[RowNumber][i] = list[i];
			RowNumber++; // count number of rows

		}

		// stored in array
		readThisFile.close();

		// store into 2d

		double[][] doubleList = new double[RowNumber][];

		// print the double list
		for (int Row = 0; Row < doubleList.length; Row++) {
			if (mylist[Row] != null) {
				int size = mylist[Row].length;
				doubleList[Row] = new double[size];
				for (int col = 0; col < mylist[Row].length; col++) {
					doubleList[Row][col] = Double.parseDouble(mylist[Row][col]);
				}
			}
		}

		return doubleList;
	}

	/**
	 * write to a file
	 * 
	 */
	public static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException {

		// check if passed file exits

		// create a file
		PrintWriter writeToFile = new PrintWriter(outputFile);

		// write to file
		for (int n = 0; n < data.length; n++) {
			for (int j = 0; j < data[n].length; j++) {
				writeToFile.print(data[n][j] + " ");
			}
			writeToFile.println();
		}
		// close file
		writeToFile.close();

	}

	/**
	 * calculate the total sum of all elements in 2d array
	 *
	 */
	public static double getTotal(double[][] data) {

		// accumulates total sum
		double total = 0;

		for (int row = 0; row < data.length; row++) {
			for (int col = 0; col < data[row].length; col++)
				total += data[row][col];
		}
		return total;
	}

	/**
	 * calculate the average
	 * 
	 */
	public static double getAverage(double[][] data) {
		double Total = 0;
		int elements = 0;
		for (int row = 0; row < data.length; row++) {
			for (int col = 0; col < data[row].length; col++) {
				Total += data[row][col];
				elements++;
			}
		}
		return Total / elements;
	}

	/**
	 * calculate the row total
	 * 
	 */
	public static double getRowTotal(double[][] data, int row) {

		// holds index 0
		double RowTotal = 0;

		for (int i = 0; i < data[row].length; i++) {
			RowTotal += data[row][i];
		}
		return RowTotal;
	}

	/**
	 * calculates the total of columns
	 * 
	 */
	public static double getColumnTotal(double[][] data, int col) {

		// holds index 0
		double colTotal = 0;

		for (int j = 0; j < data.length; j++) {
			if (col < data[j].length)
				colTotal += data[j][col];
		}
		return colTotal;
	}

	/**
	 * calculates the highest row value
	 * 
	 */
	public static double getHighestInRow(double[][] data, int row) {

		// holds highest number at row
		double largestRow = data[row][0];

		for (int i = 1; i < data[row].length; i++) {
			if (row < data[i].length) {
				if (largestRow < data[row][i]) {
					largestRow = data[row][i];
				}
			}
		}
		return largestRow;
	}

	/**
	 * calculates the highest row index
	 * 
	 */
	public static int getHighestInRowIndex(double[][] data, int row) {

		// holds highest index at row
		int largestRowIndex = 0;

		// holds highest number is a row
		double largestRow = data[row][0];

		for (int i = 1; i < data[row].length; i++) {
			if (data[row][i] > largestRow) {
				largestRow = data[row][i];
				largestRowIndex = i;
			}
		}

		return largestRowIndex;
	}

	/**
	 * calculates the lowest value in row
	 *
	 */
	public static double getLowestInRow(double[][] data, int row) {

		// holds highest number at row
		double lowestRow = data[row][0];

		for (int i = 1; i < data[row].length; i++) {
			if (lowestRow > data[row][i]) {
				lowestRow = data[row][i];
			}
		}
		return lowestRow;
	}

	/**
	 * calculates the lowest index in a row
	 *
	 */
	public static int getLowestInRowIndex(double[][] data, int row) {

		// holds highest index at row
		int lowestRowIndex = 0;

		// holds highest number is a row
		double lowestRow = data[row][0];

		for (int i = 1; i < data[row].length; i++) {

			if (lowestRow > data[row][i]) {
				// largest number
				lowestRow = data[row][i];
				// largest index
				lowestRowIndex = i;
			}

		}
		return lowestRowIndex;
	}

	/**
	 * largest value in column
	 *
	 */
	public static double getHighestInColumn(double[][] data, int col) {

		// holds highest number at col
		double largestCol = Double.MIN_VALUE;

		for (int i = 0; i < data.length; i++) {
			if (col < data[i].length) {
				if (largestCol < data[i][col]) {
					largestCol = data[i][col];
				}
			}
		}
		return largestCol;

	}

	/**
	 * get highest col index
	 * 
	 */
	public static int getHighestInColumnIndex(double[][] data, int col) {

		// holds highest index at col
		int largestColIndex = 0;

		// holds highest number is a row
		double largestRow = Double.MIN_VALUE;

		for (int j = 0; j < data.length; j++) {
			if (col < data[j].length) {
				if (data[largestColIndex][col] < data[j][col]) {
					// largest number
					largestRow = data[j][col];
					// largest index
					largestColIndex = j;
				}
			}
		}
		return largestColIndex;

	}

	/**
	 * Get lowest lowest col index
	 * 
	 */
	public static int getLowestInColumnIndex(double[][] data, int col) {

		// holds highest at index 0
		int lowestColIndex = 0;

		// holds lowest number in a row
		double lowestCol = Double.MAX_VALUE;

		for (int i = 0; i < data.length; i++) {
			if (col < data[i].length) {
				if (lowestCol > data[i][col]) {
					// lowest number
					lowestCol = data[i][col];
					// lowest index
					lowestColIndex = i;
				}
			}
		}

		return lowestColIndex;

	}

	/**
	 * Get the lowest element in col
	 * 
	 */
	public static double getLowestInColumn(double[][] data, int col) {

		// holds highest number at col
		double lowestCol = Double.MAX_VALUE;

		for (int k = 0; k < data.length; k++) {
			if (col < data[k].length) {
				if (lowestCol > data[k][col]) {
					lowestCol = data[k][col];
				}
			}
		}
		return lowestCol;
	}

	/**
	 * Get the largest in both row and col
	 *
	 */
	public static double getHighestInArray(double[][] data) {

		// holds element at index 0,0
		double largestElement = data[0][0];

		for (int Row = 1; Row < data.length; Row++) {
			for (int col = 0; col < data[Row].length; col++) {
				if (largestElement < data[Row][col]) {
					largestElement = data[Row][col];
				}
			}
		}
		return largestElement;
	}

	/**
	 * Get the lowest element in the array
	 *
	 */
	public static double getLowestInArray(double[][] data) {

		// holds lowest element at index 0,0
		double LowestElement = data[0][0];

		for (int Row = 1; Row < data.length; Row++) {
			for (int col = 0; col < data[Row].length; col++) {
				if (LowestElement > data[Row][col]) {
					LowestElement = data[Row][col];
				}
			}
		}
		return LowestElement;
	}

}