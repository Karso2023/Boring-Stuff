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
    while (true) {
      // Check if there are negative elements in the first row
      boolean hasNegative = false;
      for (int value : number[0]) {
        if (value < 0) {
          hasNegative = true;
          break;
        }
      }

      if (!hasNegative) {
        break;
      }
      simulateCalculation(number);
    }
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

    /*
    Logic bugs up here
    1st min index = 3
    1st negative index = 0
     */
    for(int i=0; i<number.length; i++) {
      System.out.println(number.length);
        minRat = number[minIndex-1][i];

        absoluteElement = number[i][0];
        absoluteRow = number[0][i];
        double formula = neg - ((absoluteElement * absoluteRow) / minRat);
        number[i][number[i].length-1] = (int) formula;

//      System.out.println("neg: " + neg);
//      System.out.println("minIndex: " + minRat);
//      System.out.println("absoluteElement: " + absoluteElement);
//      System.out.println("absoluteRow: " + absoluteRow);
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
      int[][] updatedArray = modifyArray(number);
      Thread.sleep(delay);
      System.out.println("\nCalculating\n");

      for (int i = 0; i < numberOfDots; i++) {
        System.out.print(".");
        Thread.sleep(delay);
      }
      Thread.sleep(delay);
      System.out.println("\n\nMin. ratio: " + minRatio);
      Thread.sleep(delay);
      System.out.println("\nNegative element in the objective function: " + negativeElement);
      Thread.sleep(delay);
      System.out.println("\nUpdated Array: ");
      for (int[] row : updatedArray) {
        for (int element : row) {
          System.out.print(element + " | ");
        }
        System.out.println();
      }
      Thread.sleep(delay);
      System.out.println("\nThe max. number is: " + number[0][number[0].length - 1]);
    } catch (InterruptedException e) {
      System.err.println(e.getMessage());
    }
  }

}
