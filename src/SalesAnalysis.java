
public class SalesAnalysis {

    public static void main(String[] args) {
      
        String[] months = {
            "Jan", "Feb", "Mar", "Apr", "May", "Jun",
            "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
        };

        double[] salesChange = {
            12, -8, 15, 18, -22, 10,
            14, -5, 20, 8, -25, 6
        };

        int[] bestPeriod = findBestPeriod(salesChange);
        double bestTotal = sumRange(salesChange, bestPeriod[0], bestPeriod[1]);

        displayResults(months, bestPeriod[0], bestPeriod[1], bestTotal);
    }

    public static int[] findBestPeriod(double[] values) {
        int bestStart = 0;
        int bestEnd = 0;
        double bestTotal = values[0]; 

        
        for (int start = 0; start < values.length; start++) {
            double runningTotal = 0;

           
            for (int end = start; end < values.length; end++) {
                runningTotal += values[end];

              
                if (runningTotal > bestTotal) {
                    bestTotal = runningTotal;
                    bestStart = start;
                    bestEnd = end;
                }
            }
        }

        return new int[] { bestStart, bestEnd };
    }

   
    public static double sumRange(double[] values, int start, int end) {
        double total = 0;
        for (int i = start; i <= end; i++) {
            total += values[i];
        }
        return total;
    }

   
    public static void displayResults(String[] months, int startIndex, int endIndex, double total) {
        System.out.println("Sales Analysis");
        System.out.println("-------------------------");
        System.out.println("Start Month: " + months[startIndex]);
        System.out.println("End Month:   " + months[endIndex]);
        System.out.println("Total Sales Change: " + total + " million");
    }
}
