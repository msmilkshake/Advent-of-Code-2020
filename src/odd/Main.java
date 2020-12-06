package odd;

import java.util.*;

public class Main {

    public static char placeHolder[][] = new char[3][3];
    public static Scanner scanner = new Scanner(System.in);
    public static char endChar;
    public static int coordinate1=0;
    public static int coordinate2=0;
    public static int countX = 0;
    public static int countO = 0;

    public static void main(String[] args) {

        System.out.print("Enter cells: ");

        String input = scanner.nextLine();

        initiateValue(input);

        board();

        System.out.print("Enter the coordinates: ");

        coordinate();

        checker();

        counter();

        state();

    }

    public static void initiateValue(String input){

        placeHolder[0][0] = input.charAt(0);
        placeHolder[0][1] = input.charAt(1);
        placeHolder[0][2] = input.charAt(2);
        placeHolder[1][0] = input.charAt(3);
        placeHolder[1][1] = input.charAt(4);
        placeHolder[1][2] = input.charAt(5);
        placeHolder[2][0] = input.charAt(6);
        placeHolder[2][1] = input.charAt(7);
        placeHolder[2][2] = input.charAt(8);

        counter();

    }

    public static void counter(){
        countX = 0;
        countO = 0;

        for(int i = 0;i<3;i++){
            for(int j = 0;j<3;j++){
                if(placeHolder[i][j]=='X'){
                    countX++;
                }else if(placeHolder[i][j]=='O'){
                    countO++;
                }
            }
        }
        System.out.println(countX +" "+ countO);

        if(countX>countO){
            endChar = 'O';
        }else if(countO>countX){
            endChar = 'X';
        }else {
            endChar = 'X';
        }
    }

    public static void board(){

        System.out.println("---------");
        System.out.println("| "+placeHolder[0][0]+" "+placeHolder[0][1]+" "+placeHolder[0][2]+" |");
        System.out.println("| "+placeHolder[1][0]+" "+placeHolder[1][1]+" "+placeHolder[1][2]+" |");
        System.out.println("| "+placeHolder[2][0]+" "+placeHolder[2][1]+" "+placeHolder[2][2]+" |");
        System.out.println("---------");

    }

    public static void coordinate(){
        boolean retryInput;

        do{
            if (scanner.hasNextInt()) {
                coordinate1 = scanner.nextInt();
                retryInput =true;

                if (scanner.hasNextInt()) {
                    coordinate2 = scanner.nextInt();
                    retryInput =true;

                }else {
                    System.out.println("You should enter numbers!");
                    retryInput = false;
                    System.out.print("Enter the coordinates: ");
                    scanner.next();
                }
            }else {
                System.out.println("You should enter numbers!");
                retryInput = false;
                System.out.print("Enter the coordinates: ");
                scanner.next();
            }
        }while(!(retryInput));
    }

    public static void checker(){
        boolean retryInput1;

        do{
            if(coordinate1>3 || coordinate1<1 || coordinate2>3 || coordinate2<1){
                System.out.println("Coordinates should be from 1 to 3!");
                retryInput1 = false;
                System.out.print("Enter the coordinates: ");
                coordinate();
            }else if (placeHolder[3-coordinate2][coordinate1-1]=='_') {
                placeHolder[3-coordinate2][coordinate1-1]=endChar;
                board();
                retryInput1 =true;
            }else {
                System.out.println("This cell is occupied! Choose another one!");
                retryInput1 = false;
                System.out.print("Enter the coordinates: ");
                coordinate();
            }
        }while(!(retryInput1));
    }


    public static void state(){
        char a = placeHolder[0][0] ;
        char b = placeHolder[0][1] ;
        char c = placeHolder[0][2] ;
        char d = placeHolder[1][0] ;
        char e = placeHolder[1][1] ;
        char f = placeHolder[1][2] ;
        char g = placeHolder[2][0] ;
        char h = placeHolder[2][1] ;
        char i = placeHolder[2][2] ;

        if((a=='O' && b=='O' && c=='O')||(d=='O' && e=='O' && f=='O')||(a=='O' && d=='O' && g=='O')||(b=='O' && e=='O' && h=='O')||(c=='O' && f=='O' && i=='O')||(a=='O' && e=='O' && i=='O')||(c=='O' && e=='O' && g=='O')||(g=='O' && h=='O' && i=='O')){
            System.out.println("O wins");
        }else if((a=='X' && b=='X' && c=='X')||(d=='X' && e=='X' && f=='X')||(a=='X' && d=='X' && g=='X')||(b=='X' && e=='X' && h=='X')||(c=='X' && f=='X' && i=='X')||(a=='X' && e=='X' && i=='X')||(c=='X' && e=='X' && g=='X')||(g=='X' && h=='X' && i=='X')){
            System.out.println("X wins");
        }else if((countX + countO )==9){
            System.out.println("Draw");
        }else{
            System.out.println("Game not finished");
        }
    }


}