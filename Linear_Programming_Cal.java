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

  public void calculate(int[][] number) {

    print2DArray(number);

    double minRatio = findMinRatio(number);

    // Simulate calculation with delay
    simulateCalculation(minRatio, number);
  }

  
  private void print2DArray(int[][] number) {
    System.out.println("Contents of the 2D array:");
    for (int[] row : number) {
      for (int element : row) {
        System.out.print(element + " | ");
      }
      System.out.println();
    }
  }

  private double findMinRatio(int[][] number) {
    double minRatio = Double.MAX_VALUE;

    for (int i = 1; i < number.length; i++) {
      double lastElement = number[i][number[i].length - 1];
      double firstElement = number[i][0];

      if (firstElement != 0) { // Avoid division by zero
        minRatio = Math.min(minRatio, lastElement / firstElement);
      }
    }

    return minRatio;
  }

  private void simulateCalculation(double minRatio, int[][] number) {
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
      System.out.println("\nThe max. number is: " + number[0][number[0].length - 1]);
    } catch (InterruptedException e) {
      System.err.println(e.getMessage());
    }
  }

}
