package ATS.Completed;

import java.util.Scanner;

class LNode {

    int data;
    LNode next;

    LNode(int d) {
        data = d;
        next = null;
    }
}


class LinkedList {


    /* Function to print linked list */
    public static void print(LNode root) {
        LNode temp = root;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }


    /* Driver program to test above functions */
    public static void main(String args[]) {

        /* Constructed Linked List is 1.2.3.4.5.6.
         7.8.8.9.null */
        int value;
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0 && sc.hasNextInt()) {
            int n = sc.nextInt();

            //int n=Integer.parseInt(br.readLine());
            int a1 = sc.nextInt();
            LNode head = new LNode(a1);
            LNode tail = head;

            for (int i = 1; i < n && sc.hasNextInt(); i++) {
                int a = sc.nextInt();
                tail.next = new LNode(a);
                tail = tail.next;
            }


            LNode result = new DeleteGreaterRight().compute(head);
            print(result);
            System.out.println();
            t--;
        }
    }
}// } Driver Code Ends


/*
class LNode {
   int data;
   LNode next;

  LNode(int data) {
      this.data = data;
  }
}
*/
public class DeleteGreaterRight {

    LNode compute(LNode head) {
        if (head == null || head.next == null) return head;
        head.next = compute(head.next);
        if (head.data < head.next.data) {
            return head.next;
        }
        return head;
    }
}

