package utils;

import com.google.gson.Gson;
import models.ShopConfig;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class JsonReader {

    public static ShopConfig read(String path) {

        InputStream stream = JsonReader.class
                .getClassLoader()
                .getResourceAsStream(path);

        if (stream == null) {
            throw new IllegalStateException(
                    "JSON resource not found: " + path);
        }

        try (InputStream in = stream;
             InputStreamReader reader =
                     new InputStreamReader(in, StandardCharsets.UTF_8)) {

            return new Gson().fromJson(reader, ShopConfig.class);

        } catch (IOException e) {
            throw new IllegalStateException(
                    "Unable to read JSON resource: " + path, e);
        }
    }
}