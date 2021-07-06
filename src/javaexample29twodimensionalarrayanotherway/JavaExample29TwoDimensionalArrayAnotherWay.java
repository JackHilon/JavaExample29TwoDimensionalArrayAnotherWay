
package javaexample29twodimensionalarrayanotherway;

import java.util.Scanner;


public class JavaExample29TwoDimensionalArrayAnotherWay {

    
    public static void main(String[] args) {
        
        
        // int[n][m]
        // n: number of rows
        // m: number of columns. Can be different for each row.
        // int[n][m] is array of n references (arrays)
        
        Scanner in=new Scanner(System.in);
        int row=0, col=0;
        
        System.out.print("Enter number of rows (references): ");
        row=GetInteger(in);
        in.nextLine();
        System.out.print("Enter number of columns..........: ");
        col=GetInteger(in);
        in.nextLine();
        System.out.println();
        
        System.out.println("Enter your array:");
        int[] arrIn=GetWholeInputInOneArray(in, row, col);
        System.out.print("Your entered array: ");
        PrintOneLineIntArray(arrIn);
        
        int[][] realArray=InputArrayTo2DArray(arrIn, row, col);
        System.out.println("Your real array:");
        Print2DIntArray(realArray);
        
        in.close();
        
    } // end main()
    
    private static int[][] InputArrayTo2DArray(int[] inputArray, int row, int col)
    {
        int[][] res=new int[row][col];
        int inputArrayIndex=0;
        
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                res[i][j]=inputArray[inputArrayIndex];
                inputArrayIndex++;
            }// end inner for
        }// end outer for
        return res;
    }
    
    private static int[] GetWholeInputInOneArray(Scanner input, int row, int col)
    {
        int len=row*col;
        String temp;
        
        int[] res=new int[len];
        for (int i = 0; i < len; i++) {
            temp=input.next();
            if(IntegerCheck(temp))
                res[i]=Integer.parseInt(temp);
            else
            {
                while(!IntegerCheck(temp))
                {
                    temp=input.next();
                }
                res[i]=Integer.parseInt(temp);
            }// end else
        }// end for
        return res;
    }
    
    private static void Print2DIntArray(int[][] arr)
    {
        for (int i = 0; i < arr.length; i++) {
            PrintOneLineIntArray(arr[i]);
        }
    }
    
    private static void PrintOneLineIntArray(int[] arr)
    {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    
    
    private static void InitializeOneArray(int[] arr, Scanner input)
    {
        try{
        for (int i = 0; i < arr.length; i++) {
            arr[i]=input.nextInt();
            //input.nextLine(); // to accept one item per line only!
        }
        }catch(Exception e)
        {
            input.nextLine();
            System.out.println(e.toString());
            System.out.println("Re-initialize your array.");
            InitializeOneArray(arr, input);
        }
    }
    
    public static int GetInteger(Scanner input)
    {
        int res=0;
        try{
            res=input.nextInt();
            return res;
        }catch(Exception e)
        {
            input.nextLine();
            System.out.println(e.toString());
            return GetInteger(input);
        }
    }// end GetInteger()
    
    private static boolean IntegerCheck(String str)
    {
        int a=0;
        try{
            a=Integer.parseInt(str);
            return true;
        }catch(Exception e)
        {
            return false;
        }
    }
    
}
