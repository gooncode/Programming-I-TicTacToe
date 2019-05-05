
//Adam Provost
//CS-200-1, Spring 2019  
//Northeastern Illinois Univeristy 


import java.util.Scanner;


public class TicTacToe_PartIII {

    public static void main(String[] args) {
    
        char[][] board = {{'1','2','3'},
                          {'4','5','6'},
                          {'7','8','9'}};    
        
        displayBoard(board);
        
                
        int i = 0, square, row, col, userSquare;
        
        char player;
        
        boolean win = false, tie = false, occupied; 
        
        
        while (!win && !tie) {
        
        player = identifyPlayer(i);
               
        do {
        userSquare = getUserInput(player);
        
        row = getRow(userSquare);
        col = getCol(userSquare);
        
        occupied = isOccupied(board[row][col]); 
        
        if (occupied) {
            System.out.println("its full");
            i--;
         }
        else {
        
            upDateBoard(board, row, col, player);          
            displayBoard(board);   
        }  
       
        win = isWinner(board, player);
       
        tie = isTie(board);
        
        i++;
        
        } while(occupied);
       
       }
       
       printGameOver(tie, win, identifyPlayer(i - 1));
           
    }
    
    public static char identifyPlayer(int n) {
    
        char player;
        
        if (n % 2 == 0)
            player = 'X';
        else
            player = 'O';
            
        return player;
    
    
    }
    
    public static void promptPlayerSquare(char p) {
    
        System.out.print(p + " - Which square? [1-9] ");
        
    }
    
    public static int getRow(int n) {
    
        int row;
        
        if (n == 1 || n == 2 || n == 3)
            row = 0;
        else if (n == 4 || n == 5 || n == 6) 
            row = 1;
        else
            row = 2;
            
        return row;
        
    }
    
    public static int getCol(int n) {
    
        int col;
        
        if (n == 1 || n == 4 || n == 7)
            col = 0;
        else if (n == 2 || n == 5 || n == 8) 
            col = 1;
        else
            col = 2;
            
        return col;
        
    }
    
    public static int getUserInput(char p) {
    
        Scanner kb = new Scanner(System.in); 
        int inPut;
        
        
        do {
        
            promptPlayerSquare(p);
            inPut = kb.nextInt();
            
            if (inPut < 1 || inPut > 9)
                System.out.println("Invalid input");
        
        
        } while (inPut < 1 || inPut > 9);
        
                
        return inPut;
    
    }
    
    public static boolean isOccupied(char square) {
    
        boolean occupied;
        
        if (square == 'X' || square == 'O')
            occupied = true;
        else 
            occupied = false; 
        
        return occupied;
            
    }
    
    public static void printGameOver(boolean tie, boolean win, char p) {
    
        if (tie && !win)
            System.out.println("Cat's Game");
        else if (win)
            System.out.println("Player " + p + " wins!");      
    
    }
           
    public static void displayBoard(char[][] board) {
    
        for (int i = 0; i < 11; i++) {
        
            for (int j = 0; j < 11; j++) {
            
                if (i != 3 && i != 7) {
                
                    if (j == 3 || j == 7) 
                        System.out.print("|");
                    else if (i == 1 ^ i == 5 ^ i == 9 && j == 1 ^ j == 5 ^ j == 9)
                        System.out.print(board[i/4][j/4]);
                    else 
                        System.out.print(" "); 
                                    
                }
                else
                    System.out.print("-");
                            
            }
            System.out.println();       
        
        }
    
    
    }
    
     public static boolean isWinner(char[][] board, char p) {
    
        boolean win = false; 
        
        for (int i = 0; i < 3; i++) {
        
            if (board[i][0] == p && board[i][1] == p && board[i][2] == p) {
            
                win = true;
            
            }
            else if (board[0][i] == p && board[1][i] == p && board[2][i] == p) {
            
                win = true;
            
            }
             
        }
        
            if (board[0][0] == p && board[1][1] == p && board[2][2] == p) {
            
                win = true;
            
            }
            else if (board[0][2] == p && board[1][1] == p && board[2][0] == p) {
            
                win = true;
            
            }
                     
        return win;

        }
        
        public static boolean isTie(char[][] board) {
        
            int count = 0;
            boolean tie;
            
            for (int i = 0; i < 3; i++) {
            
                for (int j = 0; j < 3; j++) {
                
                    if (board[i][j] == 'X' || board[i][j] == 'O')
                        count++;
                
                }
         
            }
            
            if (count == 9) 
                tie = true;
            else
                tie = false;
                     
            return tie;
        
        
        }
        
        public static void upDateBoard(char[][] board, int row, int col, char p) {
              
            board[row][col] = p;
               
        }
        

}
