package ATS.Completed;

import java.util.Scanner;

public class Sort012LL {
    static LLNode segregate(LLNode head) {
        LLNode zeroHead = null;
        LLNode oneHead = null;
        LLNode twoHead = null;
        LLNode zeroTail = null;
        LLNode oneTail = null;
        LLNode twoTail = null;
        boolean zero = true;
        boolean one = true;
        boolean two = true;
        LLNode current = head;
        while (current != null) {
            if (current.data == 0) {
                if (zero) {
                    zeroHead = zeroTail = current;
                    zero = false;
                } else {
                    zeroTail.next = current;
                    zeroTail = zeroTail.next;
                }
            }
            if (current.data == 1) {
                if (one) {
                    oneHead = oneTail = current;
                    one = false;
                } else {
                    oneTail.next = current;
                    oneTail = oneTail.next;
                }
            }
            if (current.data == 2) {
                if (two) {
                    twoHead = twoTail = current;
                    two = false;
                } else {
                    twoTail.next = current;
                    twoTail = twoTail.next;
                }
            }
            current = current.next;
        }
        if (!two) twoTail.next = null;
        if (zero) {
            if (one) {
                head = twoHead;
            } else {
                head = oneHead;
                oneTail = twoHead;
            }
        } else {
            head = zeroHead;
            if (oneHead != null) {
                zeroTail.next = oneHead;
                oneTail.next = twoHead;
            } else zeroTail.next = twoHead;
        }

        return head;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            LLNode head = new LLNode(sc.nextInt());
            LLNode tail = head;
            while (n-- > 1) {
                tail.next = new LLNode(sc.nextInt());
                tail = tail.next;
            }

            segregate(head);
            printList(head);
            System.out.println();
        }
    }

    public static void printList(LLNode head) {
        if (head == null)
            return;

        LLNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}