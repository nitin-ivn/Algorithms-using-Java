public class SimpleSieve {
    public static void main(String[] args) {
        simpleSieve(10);
    }

    public static void simpleSieve(int num){
        boolean prime[] = new boolean[num + 1];

        for (int i = 0; i <= num; i++) {
            prime[i] = true;
        }
        for(int i=2;i*i<=num;i++){
            if(prime[i] == true){
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
