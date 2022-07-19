public class thread_example {
    
    
    public static void main(String[] args) {
        new thread_example().threadOne();
        new thread_example().runnableOne();
    }

    private void threadOne()
    {
        // A a = new A();
        //a.start();
        new A().start();
    }

    private void runnableOne()
    {
        B b = new B();
        //Thread t=new Thread(b);
        //t.start();
        new Thread(b).start();
    }

     //------------------------
     private void threadOptimized(){
        new Thread(){

            @Override
            public void run() {
                super.run();
                // long running operation goes here
            }
        }.start();
    }

    private void runnableOptimized(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                // long running operation goes here
            }
        }).start();
    }

}

class A extends Thread
    {

        @Override
        public void run() 
        {
            super.run();
            // long running operation goes here
            for (int i=0; i<10;i++)
            {
                //Log.i("NIBM", "I am thread.. "+i);
                System.out.println("I am thread.. "+i);
                try 
                {
                    Thread.sleep(1000);
                } 
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }

            }

        }

    }
    class B implements Runnable
    {

        @Override
        public void run() 
        {
            // long running operation goes here
            for (int i=0; i<10;i++)
            {
                //Log.i("NIBM", "I am runnable.. "+i);
                System.out.println("I am runnable.. "+i);
                try 
                {
                    Thread.sleep(1000);
                } 
                catch (InterruptedException e) 
                {
                    e.printStackTrace();
                }

            }
        }
    }
