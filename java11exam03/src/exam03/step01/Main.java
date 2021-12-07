package exam03.step01;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args)  {
        Gson gson;
//        try{
//            Product[] products = JsonSerializer.getProducts();
//        }catch (IOException ie){
//            System.out.println(ie.getMessage());
//            ie.printStackTrace();
//        }
        User[] users = new User[] { new User(1, "Mike"), new User(2, "Tom") };

        try (Writer writer = new FileWriter("user.json")) {
            gson = new GsonBuilder().create();
            gson.toJson(users, writer);
            JsonReader reader = new JsonReader(new FileReader("user.json"));
            User[] users1 = gson.fromJson(reader, User.class);
            System.out.println(Arrays.toString(users1));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
