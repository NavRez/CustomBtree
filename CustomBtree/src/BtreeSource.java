import java.util.*;

class BtreeSource {
    public static void main(String[] args) {
        Btree btree = new Btree();
        

        Scanner scan = new Scanner(System.in);
        boolean isNotError = false;
        int intTemp = 0;
        System.out.println("Enter a number : ");

        do {
        	
        	if(scan.hasNextInt()){
            	intTemp = scan.nextInt();
                isNotError = true;
                btree.insert(btree.returnRoot(), intTemp);
                System.out.print("Preorder : ");
                btree.Preorderprint(btree.returnRoot());
                System.out.print("\nPostorder : ");
                btree.Postorderprint(btree.returnRoot());
                System.out.print("\nInorder : ");
                btree.Inorderprint(btree.returnRoot());
                System.out.println();
                System.out.println("Enter a number : ");
            }else{
                scan.nextLine();
                System.out.println("Error, value is not an Integer. Try again");    
            }
        	
        }while(true);

    }
}