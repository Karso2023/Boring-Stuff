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
    for (int[] ints : number) {
      for (int anInt : ints) {
        System.out.print(anInt + " | " + " ");
      }
      System.out.println();
    }
  }
}
