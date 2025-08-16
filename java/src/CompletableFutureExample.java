import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample {


    public static void main(String[] args) {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> 10).thenApply(
                result -> result * 2).thenApply(
                        result -> String.valueOf(result + 5)
        );

        future1.thenAccept(System.out::println);
    }
}
