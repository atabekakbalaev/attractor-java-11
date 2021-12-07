package exam03.step01;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class JsonSerializer {
    public static Product[] getProducts() throws IOException {
        Gson gson = new Gson();
        try(Reader reader = new FileReader("exam03/step01/Products.json")){
            Product[] products = gson.fromJson(reader,Product[].class);
//            for(int i = 0; i < products.length; i++){
//                products[i].fillState();
//            }
            return products;
        }
    }
}
