//CMSC203 CRN 22297
//Instructor: Dr. Grinberg
//Assognment5
//Due Date:11/15/2021
/*Assignment Discription: calculateHolidayBonus – pass in a two-dimensional ragged array of doubles, and the
 * bonus amount for the store with the highest sales in a category, the bonus amount for the store 
 * with the lowest sales in a category and bonus amount for all other stores. 
 * It will return an array of doubles which represents the holiday bonuses for each of the stores in the district
 * Integrity Pledge: I pledge that I have completed the programming assignment independently
 * 
 */
public class HolidayBonus {

	public HolidayBonus() {
	}


	public static double[] calculateHolidayBonus(double[][] data, double high, double low, double other) {



		int storeNumber = data.length;
		// hold bonus array
		double[] Bonuses = new double[storeNumber];

		for (int n = 0; n < data.length; n++) {
			for (int k = 0; k < data[n].length; k++) {
				if (data[n][k] > 0) {
					if (data[n][k] == TwoDimRaggedArrayUtility.getHighestInColumn(data, k)) {
						Bonuses[n] += high; // add 5000
					} else if (data[n][k] == TwoDimRaggedArrayUtility.getLowestInColumn(data, k)) {
						Bonuses[n] += low; // add 1000
					} else {
						Bonuses[n] += other;
					}
				}
			}
		}
		return Bonuses;
	}

	/**calculate the sum of all bonuses */
	
	public static double calculateTotalHolidayBonus(double[][] data, double high, double low, double other) {

		// call the bonus array
		double[] bonusList = calculateHolidayBonus(data, high, low, other);

		// accumulate total
		double BonusTotal = 0;

		for (int m = 0; m < data.length; m++)
			BonusTotal += bonusList[m];

		// return total
		return BonusTotal;
	}

}
