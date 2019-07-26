package cn.snow;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.joda.time.DateTime;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Richard Xue
 * @version 1.0
 * @date 2019/7/25 14:02
 */
public class TDengineTest {

    OkHttpClient client = new OkHttpClient();

    // select count(*),avg(degree), sum(degree),min(degree),max(degree),first(degree),last(degree),spread(degree) from xx interval(1M) group by device_id ;
    // select count(*),avg(degree), sum(degree),min(degree),max(degree),first(degree),last(degree),spread(degree),first(longitude),first(latitude) from xx interval(1M);

    private static final String CREATE_SUPER_TABLE = "CREATE TABLE test.xx (ts TIMESTAMP, degree INT, longitude DOUBLE, latitude DOUBLE) TAGS (device_id INT, type TINYINT, name BINARY(32))";
    private static final String CREATE_TABLE = "CREATE TABLE test.{0} USING test.xx TAGS ({1}, 1, {2})";
    private static final String INSERT_INTO2 = "INSERT INTO test.{0} VALUES ({1}, {2}, {3}, {4})";

    public static void main(String[] args) {
        TDengineTest okHttpTest = new TDengineTest();
//        String sql = "select * from test.therm2";
        String url = "http://192.168.1.40:6020/rest/sql";

        System.out.println(DateTime.now().toString("yyyy-MM-dd HH:mm:ss.SSS"));

        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("sss-%d").build();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(50, 200, 1000, TimeUnit.SECONDS, new ArrayBlockingQueue<>(1000), threadFactory, new ThreadPoolExecutor.AbortPolicy());

        for (int j = 0; j < 10; j++) {
            threadPoolExecutor.execute(() -> {
                try {
                    Random random = new Random();
                    for (int i = 0; i < 100000; i++) {
                        if (i % 1000 == 0) {
                            System.out.println(Thread.currentThread().getName() + ">>>>>>>>>>>>>" + i);
                        }
                        String insertSql = createInsert2(random);
//                System.out.println(insertSql);
                        okHttpTest.post(url, insertSql);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
        threadPoolExecutor.shutdown();
    }

    public static String createInsert2(Random random) {
        int id = random.nextInt(100);
        String device = "D" + id;
        return MessageFormat.format(INSERT_INTO2, device, "'" + DateTime.now().toString("yyyy-MM-dd HH:mm:ss.SSS") + "'", random.nextInt(40), random.nextDouble() * 100, random.nextDouble() * 100);
    }

    public void test(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();
        try (Response response = client.newCall(request).execute()) {
            System.out.println(response.body().string());
        }
    }

    public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");
    public static final MediaType TEXT = MediaType.get("text/plain; charset=utf-8");

    public void post(String url, String content) throws IOException {
        RequestBody body = RequestBody.create(TEXT, content);
        Request request = new Request.Builder()
                .header("Authorization", "Basic dXNlcl9uYW1lOnBhc3N3b3Jk")
                .url(url)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
//            System.out.println(response.body().string());
        }
    }

}
