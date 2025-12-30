import java.util.Scanner;

class Deque {
    int[] deque;
    int front, rear, size;

    Deque(int size) {
        this.size = size;
        deque = new int[size];
        front = -1;
        rear = -1;
    }

    // Insert at front
    void insertFront(int value) {
        if ((front == 0 && rear == size - 1) || (front == rear + 1)) {
            System.out.println("Deque is Full");
            return;
        }
        if (front == -1) { // empty
            front = 0;
            rear = 0;
        } else if (front == 0) {
            front = size - 1;
        } else {
            front--;
        }
        deque[front] = value;
        System.out.println("Inserted at front: " + value);
    }

    // Insert at rear
    void insertRear(int value) {
        if ((front == 0 && rear == size - 1) || (front == rear + 1)) {
            System.out.println("Deque is Full");
            return;
        }
        if (front == -1) { // empty
            front = 0;
            rear = 0;
        } else if (rear == size - 1) {
            rear = 0;
        } else {
            rear++;
        }
        deque[rear] = value;
        System.out.println("Inserted at rear: " + value);
    }

    // Delete from front
    void deleteFront() {
        if (front == -1) {
            System.out.println("Deque is Empty");
            return;
        }
        System.out.println("Deleted from front: " + deque[front]);
        if (front == rear) {
            front = -1;
            rear = -1;
        } else if (front == size - 1) {
            front = 0;
        } else {
            front++;
        }
    }

    // Delete from rear
    void deleteRear() {
        if (front == -1) {
            System.out.println("Deque is Empty");
            return;
        }
        System.out.println("Deleted from rear: " + deque[rear]);
        if (front == rear) {
            front = -1;
            rear = -1;
        } else if (rear == 0) {
            rear = size - 1;
        } else {
            rear--;
        }
    }

    // Display deque
    void display() {
        if (front == -1) {
            System.out.println("Deque is Empty");
            return;
        }
        System.out.print("Deque elements: ");
        int i = front;
        while (true) {
            System.out.print(deque[i] + " ");
            if (i == rear)
                break;
            i = (i + 1) % size;
        }
        System.out.println();
    }
}

public class DequeImplementation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Deque dq = new Deque(5);

        while (true) {
            System.out.println("\n1.Insert Front\n2.Insert Rear\n3.Delete Front\n4.Delete Rear\n5.Display\n6.Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value: ");
                    dq.insertFront(sc.nextInt());
                    break;
                case 2:
                    System.out.print("Enter value: ");
                    dq.insertRear(sc.nextInt());
                    break;
                case 3:
                    dq.deleteFront();
                    break;
                case 4:
                    dq.deleteRear();
                    break;
                case 5:
                    dq.display();
                    break;
                case 6:
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
