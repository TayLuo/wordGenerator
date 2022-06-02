//CS 145
// Assignment 1 Word Generator
// The program supposes to generate a word puzzle
// Ke Tu


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class searchGenerator2 {
   private char[][] grid;
   private List<String> userWord;
   private int rows;
   private int colums;

   public searchGenerator2(){ // constructor 
      rows = 10;
      colums = 10;
      userWord = new ArrayList<>();
      grid = new char[rows][colums];
      setupGrid();
   } 
   	
   public void generator() { // generator with an assistance method.
      @SuppressWarnings("resource")
         Scanner console = new Scanner(System.in); 
      System.out.println("How many words do you want to print out: ");
      int num = console.nextInt(); 
      for (int i = 0; i < num; i++){
         System.out.println("What are the words you want to print out: ");
         userWord.add(console.next());
      }
      Assistance(); // method help the generator funcition to have the random number.
   }
      
   private void Assistance(){
      Random rand = new Random();
      int s;
      int x, y;
      int enoughspace = 0;
      int restriction = 0;
      for (int i = 0; i < userWord.size(); i++) {
         enoughspace = 0;
         restriction = 0;
         int direction = rand.nextInt(3);
         s = userWord.get(i).length();
         String word = userWord.get(i);
      while(s != enoughspace && restriction < 100) {
            restriction++;
            direction = rand.nextInt(3);
            x = rand.nextInt(rows - s + 1);
            y = rand.nextInt(colums - s + 1);
            if (direction == 0) {// horizontal  line 
               for (int k = 0; k < s; k++) {
                  if(grid[y][x + k] == '-')
                     enoughspace++;
               }
               if(enoughspace == s) {
                  for(int j = 0; j < s; j++) {
                     grid[y][x + j] = word.charAt(j);
                  }
               }
            } else if(direction == 1){// vertical line 
               for (int k = 0; k < s; k++) {
                  if(grid[y + k][x] == '-')
                     enoughspace++;
               }
               if(enoughspace == s) {
                  for(int u = 0; u < s; u++) {
                     grid[y + u][x] = word.charAt(u);
                  }
               }
            } else { // diagional line
               for (int k = 0; k < s; k++) {
                  if(grid[y + k][x + k] == '-')
                     enoughspace++;
               }
               if(enoughspace == s) {
                  for(int q = 0; q < s; q++) {
                     grid[y + q][x + q] = word.charAt(q);
                  }
               }
            }
         }
      }
      fillGrid();
   }
   
   public void print() {
      for (int i = 0; i < colums; i++){
         for (int k = 0; k < rows; k++){
            System.out.print(grid[i][k] + " ");
         }
         System.out.println( );
      }
   }
   
   private void setupGrid() {
      for (int i = 0; i < colums; i++){
         for (int k = 0; k < rows; k++){
            grid[i][k] = '-';
         }
      }
   }
   
   // fill the grid with random characters in all of the empty places
   private void fillGrid() {
      Random rand = new Random();
      for (int m = 0; m < colums; m++) {
         for (int j = 0; j < rows; j++) {
            if (grid[m][j] == '-') { 
               grid[m][j] = (char)(rand.nextInt(26) + 97);
            }
         }
      }
   }
   
   public void intro() {
      System.out.println("Welcome to my word search generator ");
      System.out.println("This program will allow you to generate your own word search puzzle ");
      System.out.println();
   }   
}
