public interface BankInterface {

   double checkBalance(); // to check how much money he/she have in the bank
   String addMoney(int amount); //money which user want to add

   String withdrawMoney(int amount , String password); //with amount only if user enters a correct password then only they can withdraw money
   double caculateInterest(int years); // as we need amount , rate of interest ,no of years for calculating interest
                                        // we have amount and rate of interest as a variable in our class so we only need to pass years as parameters
}
