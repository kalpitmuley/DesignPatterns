package ATS.Completed;

import java.util.Scanner;

public class AddOne {
    public static void printList(LLNode LLNode) {
        while (LLNode != null) {
            System.out.print(LLNode.data);
            LLNode = LLNode.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            LLNode head = new LLNode(s.charAt(0) - '0');
            LLNode tail = head;
            for (int i = 1; i < s.length(); i++) {
                tail.next = new LLNode(s.charAt(i) - '0');
                tail = tail.next;
            }
            head = addOne(head);
            printList(head);
        }
    }

    public static LLNode addOne(LLNode head) {
        int carryOver = add(head);
        LLNode temp = null;
        if (carryOver > 0) {
            temp = new LLNode(carryOver);
            temp.next = head;
            head = temp;
        }
        return head;
    }

    public static int add(LLNode head) {

        if (head.next == null) {
            int temp = head.data;
            head.data = (head.data + 1) % 10;
            return (temp + 1) / 10;
        }
        int temp = add(head.next);

        int tempData = head.data;
        head.data = (head.data + temp) % 10;
        return (tempData + temp) / 10;
    }
}
