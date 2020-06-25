package ATS.Completed;

import java.util.Scanner;

/* LLNode of a linked list
 class LLNode {
   int data;
    LLNode next;
    LLNode(int d)  { data = d;  next = null; }
}
 Linked List class
class LinkedList
{
    LLNode head;  // head of list
}*/

public class IntersectionPoint {

    int intersectPoint(LLNode headA, LLNode headB) {
        if (headA == null || headB == null) return -1;
        int count1 = 0;
        int count2 = 0;
        LLNode first = headA;
        LLNode second = headB;
        while (first != null) {
            count1++;
            first = first.next;
        }
        while (second != null) {
            count2++;
            second = second.next;
        }
        int result = count1 - count2;
        first = headA;
        second = headB;

        if (result > 0) {
            while (result > 0) {
                first = first.next;
                result--;
            }
        } else {
            while (result < 0) {
                second = second.next;
                result++;
            }
        }

        result = -1;

        while (first != null && second != null) {
            if (first == second) {
                result = first.data;
                break;
            }

            first = first.next;
            second = second.next;
        }
        return result;
    }
}

class LinkedList_Intersection {
    LLNode head = null;
    LLNode tail = null;

    /* Driver program to test above functions */
    public static void main(String[] args) {


        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t > 0) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            int n3 = sc.nextInt();
            LinkedList_Intersection llist1 = new LinkedList_Intersection();
            LinkedList_Intersection llist2 = new LinkedList_Intersection();
            LinkedList_Intersection llist3 = new LinkedList_Intersection();

            int a1 = sc.nextInt();
            LLNode head1 = new LLNode(a1);
            LLNode tail1 = head1;

            for (int i = 1; i < n1; i++) {
                int a = sc.nextInt();
                tail1.next = (new LLNode(a));
                tail1 = tail1.next;
            }


            int b1 = sc.nextInt();
            LLNode head2 = new LLNode(b1);
            LLNode tail2 = head2;
            for (int i = 1; i < n2; i++) {
                int b = sc.nextInt();
                tail2.next = (new LLNode(b));
                tail2 = tail2.next;
            }

            int c1 = sc.nextInt();
            LLNode head3 = new LLNode(c1);
            tail1.next = head3;
            tail2.next = head3;
            LLNode tail3 = head3;
            for (int i = 1; i < n3; i++) {
                int c = sc.nextInt();
                tail3.next = (new LLNode(c));
                tail3 = tail3.next;
            }

            IntersectionPoint obj = new IntersectionPoint();
            System.out.println(obj.intersectPoint(head1, head2));
            t--;
        }
    }

    public void addToTheLast(LLNode LLNode) {

        if (head == null) {
            head = LLNode;
            tail = head;
        } else {
            tail.next = LLNode;
            tail = LLNode;
        }
    }

    /* Function to print linked list */
    void printList() {
        LLNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}