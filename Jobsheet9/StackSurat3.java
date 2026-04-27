package Jobsheet9;

public class StackSurat3 {
    Surat3[] stack;
    int top;
    int size;

    public StackSurat3(int size) {
        this.size = size;
        stack = new Surat3[size];
        top = -1;
    } 

    boolean isFull() {
        return top == size - 1;
    }

    boolean isEmpty() {
        return top == -1;
    }
    
    void push(Surat3 s) {
        if (!isFull()) {
            stack[++top] = s;
        } else {
            System.out.println("Stack penuh!");
        }
    }

    Surat3 pop() {
        if (!isEmpty()) {
            return stack[top--];
        } else {
            System.out.println("Tidak ada surat untuk diperoses!");
            return null;
        }
    }

    Surat3 peek() {
        if (!isEmpty()) {
            return stack[top];
        } else {
            System.out.println("Stack kosong!");
            return null;
        }
    }

    boolean cari(String nama){
        for (int i = top; i >= 0; i--) {
            if (stack[i].namaMahasiswa.equals(nama)) {
                return true;
            }
        }
        return false;
    }
}
