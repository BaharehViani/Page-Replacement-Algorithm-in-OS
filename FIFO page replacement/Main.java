import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    public static void main( String[] args )
    {   
        Scanner scan = new Scanner(System.in);
        System.out.println("enter number of pages: ");
        int n = scan.nextInt();
        int[] pages = new int[n];
        System.out.println("enter page numbers: ");
        String str = scan.next();
        String[] strArr = str.split(",");
        for (int i = 0; i < strArr.length; i++) {
            pages[i] = Integer.parseInt(strArr[i]);
        } 
        System.out.println("enter number of frames: ");
        int nf = scan.nextInt();
        ArrayList<Integer>frames = new ArrayList<>();
        scan.close();
        System.out.println("---------------");
        int pageFault = 0;
        int pageHit = 0;
        here:
        for (int i = 0; i < pages.length; i++) {
            for (int j = 0; j < frames.size(); j++) {
                if (pages[i] == frames.get(j)) {
                    pageHit++;
                    System.out.println(frames.toString());
                    continue here;
                }
            }
            pageFault++;
            if (frames.size() == nf) {
                frames.remove(0);
            }
            frames.add(pages[i]);
            System.out.println(frames.toString());
        }

        System.out.println("Number of page faults = " + pageFault);
        System.out.println("Number of page hits = " + pageHit);
    }
}