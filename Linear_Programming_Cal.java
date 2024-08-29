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

  private void calculate(int[][] number) {
    double minRatio = Double.MAX_VALUE;
    
    for (int[] ints : number) {
      for (int anInt : ints) {
        System.out.print(anInt + " | " + " ");
      }
      System.out.println();
    }

    // Find min. ratio
    for(int i=1; i<number.length; i++) {
        double last_element = number[i][number[i].length-1];
        double first_element = number[i][0];

        minRatio = Math.min(minRatio, last_element / first_element);
    }

    // Find -ve in objective function








    try {
      int numberOfDots = 5; // Number of dots to print
      int delay = 250; // Delay in milliseconds

      Thread.sleep(delay);
      System.out.println("\nCalculating\n");

      for (int i = 0; i < numberOfDots; i++) {
        System.out.print(".");
        Thread.sleep(delay);
      }
      Thread.sleep(delay);
      System.out.println("\n\nFirst min. ratio: " + minRatio);
      Thread.sleep(delay);
      System.out.println("\nThe max. number is: " + number[0][5]);
    } catch (InterruptedException e) {
      System.err.println(e.getMessage());
    }
  }
}
