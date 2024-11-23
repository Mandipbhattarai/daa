import java.util.*;


public class s {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter no of jobs: ");
        int n = sc.nextInt();    
        
        int[][] task = new int[n][2];
        int maxDeadline = -1;

        System.out.println("Enter the deadlines and profit: ");

        for(int i = 0; i < n ; i++){
            System.out.print("Deadline d" + i + " : " );
            int deadline = sc.nextInt();

            System.out.print("Profit p" + i + " : " );
            int profit = sc.nextInt();

            if (deadline > maxDeadline) {
                maxDeadline = deadline;
            }

            task[i][0] = profit;
            task[i][1] = deadline;

            System.out.println(" ");
        }
        
        Arrays.sort(task, (a,b) -> Integer.compare(b[0], a[0]));

        int [] schedule = new int[maxDeadline + 1];

        for(int i = 0; i < n ; i++){
            int profit = task[i][0];
            int deadline = task[i][1];


            if (schedule[deadline] == 0) {
                schedule[deadline] = profit;

            }
            else{
                for(int j = deadline - 1; j >= 1; j--){
                    if (schedule[j] == 0) {
                        schedule[j] = profit;
                        break;
                    }
                }
            }
        }

        int result = 0;
        for(int i = 1; i < maxDeadline+1; i++){
            result += schedule[i];
        }

        System.out.println("Maximum Profit = " + result );

        sc.close();
    }

}
