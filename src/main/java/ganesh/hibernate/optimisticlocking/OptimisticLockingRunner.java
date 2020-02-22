package ganesh.hibernate.optimisticlocking;

import javax.persistence.OptimisticLockException;
import java.util.concurrent.TimeUnit;

import static ganesh.hibernate.util.HibernateUtil.*;

public class OptimisticLockingRunner {
//    private static int deductAmount = 100;
//
//    public static void main(String[] args) throws InterruptedException {
//        createDummyData();
//        try {
//            testOptimisticLocking();
//        } catch (OptimisticLockException e) {
//            System.out.println("There was error while updating data, please try again.");
//        } catch (Exception e) {
//            System.out.println("General error" + e.getMessage());
//        }
//
////        testWithMultipleUpdatesCheckingVersionNumber();
////        printBalance();
//        TimeUnit.SECONDS.sleep(5);
//        shutdown();
//    }
//
//    private static void testWithMultipleUpdatesCheckingVersionNumber() {
//        for (int i = 1; i <= 10; i++) {
//            runWithinTransaction((session) -> {
//                BankAccount bankAccount = session.get(BankAccount.class, 1);
//                bankAccount.setBalance(bankAccount.getBalance() - 1);
//                return;
//            }, "Update - " + i);
//        }
//    }
//
//    private static void testOptimisticLocking() throws InterruptedException {
//        Thread thread1 = new Thread(() -> {
//            runWithinTransaction((session) -> {
//                BankAccount bankAccount = session.get(BankAccount.class, 1);
//                System.out.println("Got: " + bankAccount);
//                try {
//                    TimeUnit.SECONDS.sleep(2);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                bankAccount.setBalance(getDeductFromBalance(bankAccount));
//                return;
//            }, "Thread-1");
//        });
//
//        //
//        Thread thread2 = new Thread(() -> {
//            runWithinTransaction((session) -> {
//                BankAccount bankAccount = session.get(BankAccount.class, 1);
//                System.out.println("Got: " + bankAccount);
//                bankAccount.setBalance(getDeductFromBalance(bankAccount));
//                return;
//            }, "Thread-2");
//        });
//        thread1.start();
//        thread2.start();
//
//        thread1.join();
//        thread2.join();
//    }
//
//    private static long getDeductFromBalance(BankAccount bankAccount) {
//        return bankAccount.getBalance() - deductAmount;
//    }
//
//    private static void createDummyData() {
//        runWithinTransaction((session) -> {
//            session.save(new BankAccount(1000));
//            return;
//        }, "Dummy Data");
//    }
//
//    private static void printBalance() {
//        runWithoutTransaction((session) -> {
//            BankAccount bankAccount = session.get(BankAccount.class, 1);
//            System.out.println(bankAccount);
//            return;
//        }, "Balance");
//    }
}
