package util;


import java.util.ArrayList;

public  class NthPrimeNumber {
    //    //declare the maximumm size as constant
//    static int MAX_SIZE = 1000005;
//    //creating an instance of the ArrayList class that stores all the prime numbers
//    static ArrayList<Integer> primelist = new ArrayList<>();
//
//    //defining a static function to find the nth prime number using Sieve of Eratosthenes approach
//   public  static int findnthPrimeNumber(int  n ) {
////creating a boolean array and marking all entries as true
////the value IsPrime[i] will be false if i is not a IsPrime
//        boolean[] IsPrime = new boolean[MAX_SIZE];
//        for (int i = 0; i < MAX_SIZE; i++)
//            IsPrime[i] = true;
//        for (int p = 2; p * p < MAX_SIZE; p++) {
//// If IsPrime[p] is not changed,
//// then it is a prime
//            if (IsPrime[p] == true) {
////finds the multiples of p greater than or equal to the square of it
////we have already marked the numbers that rae multiple of p and are less than p to the power 2
//                for (int i = p * p; i < MAX_SIZE; i += p)
//                    IsPrime[i] = false;
//            }
//        }
//        for (int p = 2; p < MAX_SIZE; p++)
//            if (IsPrime[p] == true)
////adding prime number to the ArrayList
//                primelist.add(p);
//
//        return primelist.get(n);
//    }
    public  static int findnthPrimeNumber(int  n ) {
        int num=1, count=0, i;
        while (count < n)
        {
            num=num+1;
            for (i = 2; i <= num; i++)
            {
//determines the modulo and compare it with 0
                if (num % i == 0)
                {
//breaks the loop if the above condition returns true
                    break;
                }
            }
            if (i == num)
            {
//increments the count variable by 1 if the number is prime
                count = count+1;
            }
        }
        return num;

    }
}
