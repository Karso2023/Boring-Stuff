public class Linear_Programming_Cal {

  /*
  Linear Programming Calculator

  Only support max. function and 1 phase simplex method so far

  Logic behind :
  Find the smallest ratio
  -> find -ve in obj. function
  -> Bland's rule
  -> insert formula to calculate each row
  -> update 2D array
  -> print result if no -ve in objective function
  */

  protected double minRatio = Double.MAX_VALUE;
  protected int negativeElement = 0;
  protected int minIndex = -1;
  protected int negativeIndex = -1;
  public static void main(String[] args) {

    //Change your input here, I will make a better version later
    int[][] function = new int[][] {
            {-6, -3, 0, 0, 0, 0},  //Objective function
            {2, 1, 1, 0, 0, 20},
            {1, -1, 0, 1, 0, 4},
            {3, 2, 0, 0, 1, 35}
    };

    Linear_Programming_Cal linearProgrammingCal = new Linear_Programming_Cal();
    linearProgrammingCal.calculate(function);
  }


  /**
   * Combine different methods
   * @param number 2D array
   */
  public void calculate(int[][] number) {

    print2DArray(number);

    double minRatio = findMinRatio(number);
    int negative = findNegative(number);

    // Simulate calculation with delay
    simulateCalculation(number);
  }


  /**
   * Print 2D array
   * @param number 2D array
   */
  private void print2DArray(int[][] number) {
    System.out.println("Contents of the 2D array:");
    for (int[] row : number) {
      for (int element : row) {
        System.out.print(element + " | ");
      }
      System.out.println();
    }
  }

  /**
   * This is the first step for phase one simplex method
   * Cal min. ratio and should return the related array position
   * @param number number
   * @return min. ratio
   */
  private int findMinRatio(int[][] number) {

    for (int i = 1; i < number.length; i++) {
      double lastElement = number[i][number[i].length - 1];
      double firstElement = number[i][0];

      if (firstElement > 0 && lastElement > 0) { // Avoid negative, > 0 or >= 0 ?
        minRatio = Math.min(minRatio, lastElement / firstElement);
        minIndex = i;
      }
    }

    return minIndex;
  }

  /**
   * Bland's rule, it should return related position
   * @param number number
   * @return negative element
   */
  private int findNegative(int[][] number) {

    //How to restart and continue to second iterate ?
    for(int i=0; i<number.length; i++) {
      if(number[0][i] < 0 && negativeElement == 0) {
        negativeElement = number[0][i];
        negativeIndex = i;
      }
    }

    return negativeIndex;
  }

  /**
   * Method to modify and calculate the 2D array
   * How to update and return ?
   * @param number number
   */
  private int[][] modifyArray(int[][] number) {
    double neg = number[0][negativeIndex];
    double minRat;
    double absoluteElement;
    double absoluteRow;

    for(int i=0; i<number.length; i++) {
      for (int j=0; j<number[i].length; j++) {
        minRat = number[minIndex][i];
        absoluteElement = number[i][0];
        absoluteRow = number[i][j];
        double formula = neg - ((absoluteElement * absoluteRow) / minRat);
        number[i][j] = (int) formula;
      }
    }

    return number;
  }


  /**
   * Some fancy effects
   * @param number number
   */
  private void simulateCalculation(int[][] number) {
    try {
      int numberOfDots = 5;
      int delay = 250;

      Thread.sleep(delay);
      System.out.println("\nCalculating\n");

      for (int i = 0; i < numberOfDots; i++) {
        System.out.print(".");
        Thread.sleep(delay);
      }
      Thread.sleep(delay);
      System.out.println("\n\nFirst min. ratio: " + minRatio);
      Thread.sleep(delay);
      System.out.println("\nFirst negative element in objective function: " + negativeElement);
      Thread.sleep(delay);
      System.out.println("\nThe max. number is: " + number[0][number[0].length - 1]);
    } catch (InterruptedException e) {
      System.err.println(e.getMessage());
    }
  }

}
