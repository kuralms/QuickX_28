package com.example.javaprogramms;





public class MainJava {


   /* Given an array of 5 integers how will you make mathematical expression to achieve the required number using operators(+,- *).
    You are given two inputs:
    Integer[]: Array of 5 integers.
            Number: Number to achieve.

    For Example:
    If array is [1, 2 ,3, 4, 5] and number to compute is 35 here it can be created by:
            ((((2*3)*5)+4)+1) =35

    Compute and return true if mathematical expression can be created or false if we can't create a mathematical expression return empty array.

    Method signature:	boolean createMathExpression(int[] integers, int number)

    Examples
0)[ 1 ,1, 1, 1 ,1 ],35
    Returns: true

            1) [1,2 ,3 ,4 ,5],35
    Returns: false

*/

    public static void main(String []args) {
        System.out.println("Welcome to JAVA"); // prints Hello World

        int[] integers_pool = {1, 2 ,3, 4, 5};
        int expected_result =35;

      if(createMathExpression(integers_pool, expected_result)){

      }else {

      }

    }

    public static boolean createMathExpression(int[] integers_pool, int expected_result) {
        Boolean is_result_computable = false ;

        for (int i = 0; i <integers_pool.length ; i++) {




        }






        return is_result_computable;
    }


}
