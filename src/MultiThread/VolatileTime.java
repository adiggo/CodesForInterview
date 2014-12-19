package MultiThread;

/**
 * Created by i843719 on 12/9/14.
 */
////////////////////////////////////////////////////////////////////////////////
//
//  class: VolatileTime
//
//   Simple concurrent Java program demonstrating basic features of
//     thread creation
//     waiting on threads
//     the volatile keyword
//
//  This version has no shared var an can be used for timing comparisons
//
////////////////////////////////////////////////////////////////////////////////

class VolatileTime implements Runnable
{
    int thread_id;    // Variable containing specific id of this thread.

    // Create some variables for testing.
    static volatile int sharedvolvar = 0;

    // Run: overides Runnabale.Run, thread entry point
    public void run ()
    {
        for ( int i=0; i<10000000; i++ )
        {
            sharedvolvar++;
        }
    }

    // Constructor: set thread id
    VolatileTime ( int id )
    {
        this.thread_id = id;
    }

    public static void main ( String[] args )
    {
        if ( 1 != args.length )
        {
            System.out.println ("Usage: VolatileTime #threads");
            return;
        }

        // Get the number of threads we are going to run from the command line
        int numthreads = Integer.parseInt ( args[0] );

        // Array to hold references to thread objects
        Thread[] threads = new Thread[numthreads];

        // create and start specified thread objects of class VolatileTime
        for ( int i=0; i<numthreads; i++ )
        {
            threads[i] = new Thread ( new VolatileTime(i) );
            threads[i].start();
        }

        // Await the completion of all threads
        for ( int i=0; i<numthreads; i++ )
        {
            try
            {
                threads[i].join();
            }
            catch (InterruptedException e)
            {
                System.out.println("Thread interrupted.  Exception: " + e.toString() +
                        " Message: " + e.getMessage()) ;
                return;
            }
        }
        System.out.println("Shared volatile variable = " + sharedvolvar);
    }
}

