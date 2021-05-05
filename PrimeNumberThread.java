package sk.kosickaakademia.de.thread;

public class PrimeNumberThread extends Thread {
    private String threadName;
    private int base;
    private Thread t;

    public PrimeNumberThread(String threadName, String threadName1, int base) {
        super(threadName);
        this.threadName = threadName;
        this.base = base;
    }

    @Override
    public void run() {
        System.out.println("Thread is running");

        while (checkPrime(base) == 0){
            base = base+1;
        }

        System.out.println("Thread finished");
    }

    static int checkPrime(long n){
        long i,m=0,flag=0;
        m=n/2;
        if(n==0||n==1){
            System.out.println(n+" is not a prime number");
        }else{
            for(i=2;i<=m;i++){
                if(n%i==0){
                    System.out.println(n+" is not a prime number");
                    flag=1;
                    return 0;
                }
            }
            if(flag==0)  { System.out.println(n+" is a prime number");
                return 1;}
        }
        return 0;
    }

    @Override
    public void start() {
        if(t==null){
            t = new Thread(this,threadName);
            t.start();
        }
    }
}