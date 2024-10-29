//basically used to find all the prime numbers less than or equal to given number
//example: 10
//step1: we create a list of all numbers from 2 to 10
//step2: we will mark all the numbers which are divisible by 2 = 2 4 6 8
//step3: we will move to next unmarked number which is 3 = 3 6 9
//step3: next unmarked number which is 5 = 5 10
//step3: next unmarked number which is 7 = 7
//we continue this process for examples with greater number.
//these unmarked numbers are required prime numbers


public class SimpleSieve {
    public static void main(String[] args) {
        simpleSieve(10);
    }

    public static void simpleSieve(int num){
        boolean[] prime = new boolean[num + 1];

        for (int i = 0; i <= num; i++) {
            prime[i] = true;
        }
        for(int i=2;i*i<=num;i++){
            if(prime[i]){
                for (int j = i*i; j <= num; j+=i) {
                    prime[j] = false;
                }
            }
        }
        for (int i = 2; i <= num; i++) {
            if (prime[i])
                System.out.print(i + " ");
        }
    }
}
