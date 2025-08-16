import java.util.concurrent.CompletableFuture;

public class Exception {
    public static void main(String[] args) {
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
                    return 10;
                }
        );

        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
                    return 10/0;
                }
        );

        CompletableFuture<Integer> future3 = CompletableFuture.supplyAsync(() -> {
                    return 20;
                }
        );
        CompletableFuture<Void> allFutures = CompletableFuture.allOf(future1, future2, future3);


        allFutures.exceptionally(ex -> {
            System.out.println("Exception occurred " + ex.getMessage());
            return null;
        }).thenRun(() -> {
                    int res1 = future1.join();
                    int res2 = future2.join();
                    int res3 = future3.join();
                    System.out.println(res1 + ", " + res2 + ", " + res3);
                }
        );

    }
}
