/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab5_Bai7;

/**
 *
 * @author dvu73
 */
public class Bank {
    double[] accounts;
    
    public Bank(int n, double initBalance) 
    { 
        accounts = new double[n]; 
        for (int i = 0; i < accounts.length; i++)  
        { 
            accounts[i] = initBalance; 
        } 
    } 
        
    public int size() 
    { 
        return accounts.length; 
    } 
     
    public synchronized double getTotalBalance() 
    { 
        double total = 0; 
        for (int i = 0; i < accounts.length; i++)  
        { 
            total+= accounts[i]; 
        }
        return total; 
    } 
       
    public synchronized void transfer(int from, int to, double amount) throws InterruptedException 
    { 
        while(accounts[from] < amount) 
        { 
            System.out.println(Thread.currentThread().getName()+ " đợi đủ tiền\n"); 
            wait();    
            System.out.println(Thread.currentThread().getName()+ " tiếp tục giao dịch"); 
        } 
        accounts[from] -= amount; 
        accounts[to] += amount; 
        System.out.println("Chuyển " + amount + " từ account " + from + " sang account " + to); 
        System.out.println("Tổng tiền của các account: "  + getTotalBalance()+"\n"); 
        notifyAll(); 
    } 
    
}
