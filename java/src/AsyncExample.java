import java.util.concurrent.CompletableFuture;

public class AsyncExample {

    public static void main(String[] args) throws InterruptedException {
//        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hello");
//
//        CompletableFuture<Integer> transformedFuture = future.thenApplyAsync(s -> {
//            System.out.println("Thread: " + Thread.currentThread().getName());
//            return s.length();
//        });
//
//        transformedFuture.thenAccept(length -> {
//            System.out.println("Thread: " + Thread.currentThread().getName());
//            System.out.println("Length of Hello: " + length);
//        });



        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Hello");

        CompletableFuture<String> future2 =
                future1.thenComposeAsync(s -> CompletableFuture.supplyAsync(() -> s + " World"));

        future2.thenAccept(System.out::println);

        Thread.sleep(10000);

    }
}
