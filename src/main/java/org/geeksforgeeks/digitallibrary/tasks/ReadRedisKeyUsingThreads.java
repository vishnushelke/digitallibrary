package org.geeksforgeeks.digitallibrary.tasks;

import org.springframework.http.HttpMethod;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ReadRedisKeyUsingThreads {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of times you want to read the key");
        int times = sc.nextInt();
        System.out.println("Enter the number of threads");

        URL url = new URL("http://localhost:8080/redis/name");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod(HttpMethod.GET.name());

        int threadCount = sc.nextInt();
        ExecutorService service = Executors.newFixedThreadPool(threadCount);

        for (int i = 0; i < times; i++) {
            service.submit(() -> {
                try {
                    System.out.println("Response code: " + conn.getResponseCode());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        sc.close();
//        service.close();
    }
}
