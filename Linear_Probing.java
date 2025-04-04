public class Linear_Probing {  
    int[] T;  
    int m;  
    int size;  
  
    public Linear_Probing(int m) {  
        this.m = m;  
        this.T = new int[m];  
        this.size = 0;  
        for (int i = 0; i < m; i++) {  
            T[i] = -1; // Initialize the table with -1 to indicate empty slots  
        }  
    }  
  
    int hash(int k) {  
        return k % m;  
    }  
  
    public void insert(int k) {  
        if (size == m) {  
            System.out.println("Hash table is full, can't insert.");  
            return;  
        }  
        int idx = hash(k);  
        while (T[idx] != -1) {  
            idx = (idx + 1) % m; 
        }  
        T[idx] = k; 
        size++;  
    }  
  
    public boolean search(int k) {  
        int idx = hash(k);  
        while (T[idx] != -1) {  
            if (T[idx] == k) {  
                return true; 
            }  
            idx = (idx + 1) % m;   
        }  
        return false; 
    }  
  
    public void delete(int k) {  
        int idx = hash(k);  
        while (T[idx] != -1) {  
            if (T[idx] == k) {  
                T[idx] = -1; // Mark the slot as empty  
                size--;  
                return;  
            }  
            idx = (idx + 1) % m; // Continue searching  
        }  
        System.out.println("Key not found in the table.");  
    }  
  
    public void print_table() {  
        for (int i = 0; i < m; i++) {  
            if (T[i] == -1) {  
                System.out.print("EMPTY ");  
            } else {  
                System.out.print(T[i] + " ");  
            }  
        }  
        System.out.println(); 
    }  
  
    public static void main(String[] args) {  
        Linear_Probing obj = new Linear_Probing(10);  
        obj.insert(10);  
        obj.insert(12);  
        obj.insert(13);  
        obj.insert(19);  
          
        System.out.println("Hash table after insertions:");  
        obj.print_table();  
  
        System.out.println("Searching for 12: " + obj.search(12));  
        System.out.println("Searching for 20: " + obj.search(20));  
  
        obj.delete(12);  
        System.out.println("Hash table after deleting 12:");  
        obj.print_table();  
    }  
}  