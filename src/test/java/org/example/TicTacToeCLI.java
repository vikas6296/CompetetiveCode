package org.example;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class TicTacToeCLI
{
    public static void main(String []s)
    {
        TicTacToeCLI.usageStack();
    }

//    private static final Scanner scanner = new Scanner(System.in);
//    private static char[][] board;
//    private static int[] rows, cols;
//    private static int diag, antiDiag;
//    private static int n;
//    private static int totalMoves = 0;
//
//    public static void main(String[] args) {
//        System.out.print("Enter board size (n x n): ");
//        n = scanner.nextInt();
//        initializeGame(n);
//
//        char currentPlayer = 'A';
//        while (true) {
//            printBoard();
//            System.out.println("Player " + currentPlayer + "'s turn. Enter row and column (0-based): ");
//            int r = scanner.nextInt();
//            int c = scanner.nextInt();
//
//            if (!isValidMove(r, c)) {
//                System.out.println("Invalid move! Try again.");
//                continue;
//            }
//
//            board[r][c] = currentPlayer;
//            int val = (currentPlayer == 'A') ? 1 : -1;
//            rows[r] += val;
//            cols[c] += val;
//            if (r == c) diag += val;
//            if (r + c == n - 1) antiDiag += val;
//            totalMoves++;
//
//            if (Math.abs(rows[r]) == n || Math.abs(cols[c]) == n || Math.abs(diag) == n || Math.abs(antiDiag) == n) {
//                printBoard();
//                System.out.println("🎉 Player " + currentPlayer + " wins!");
//                break;
//            }
//
//            if (totalMoves == n * n) {
//                printBoard();
//                System.out.println("It's a draw!");
//                break;
//            }
//
//            currentPlayer = (currentPlayer == 'A') ? 'B' : 'A';
//        }
//    }

//    private static void initializeGame(int size) {
//        board = new char[size][size];
//        for (char[] row : board) Arrays.fill(row, '.');
//        rows = new int[size];
//        cols = new int[size];
//        diag = 0;
//        antiDiag = 0;
//        totalMoves = 0;
//    }
//
//    private static void printBoard() {
//        System.out.println("\nCurrent Board:");
//        for (char[] row : board) {
//            for (char c : row) {
//                System.out.print(c + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();
//    }
//
//    private static boolean isValidMove(int r, int c) {
//        return r >= 0 && r < n && c >= 0 && c < n && board[r][c] == '.';
//    }
//

    public static void usageStack()
    {
        StackProblem.push(5);
        StackProblem.push(10);
        StackProblem.push(15);
        StackProblem.push(20);
        StackProblem.push(30);

        while(!StackProblem.isEmpty())
        {
            System.out.println(StackProblem.pop());
        }


    }

  /*  public ListNode deleteDuplicates(ListNode head) {
        HashSet<Integet> h = new HashSet<>();

        removeNode(head,h);

        return head;

    }
    public void removeNode(ListNode head , HashSet<Integer> h)
    {
        if( head == null)
            return ;

        h.add(head.val);
        removeNode(head.next , h);


    }*/


//    ListNode current = head;
//
//    while (current != null && current.next != null) {
//    if (current.val == current.next.val) {
//        // Skip the duplicate node
//        current.next = current.next.next;
//    } else {
//        // Move forward
//        current = current.next;
//    }
//}
//
//    return head;


// remove duplcates from linked list
   /* public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;

        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                // Skip the duplicate node
                current.next = current.next.next;
            } else {
                // Move forward
                current = current.next;
            }
        }

        return head;

    }*/
}
