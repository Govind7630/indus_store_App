package com.example.indusstore;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import android.widget.Toast;
import com.example.indusstore.Product;
public class Book extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        RecyclerView recyclerViewProducts = findViewById(R.id.recyclerViewProducts);
        List<Product> productList = getProductList();
        ProductAdapter adapter = new ProductAdapter(this, productList);
        adapter.setOnItemClickListener(new ProductAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Product clickedProduct = productList.get(position);
                switch (clickedProduct.getName()) {
                    case "Calculas":
                        Intent calculasIntent = new Intent(Book.this, Calculas.class);
                        startActivity(calculasIntent);
                        break;
                    case "Cloud Computing":
                        Intent cloudIntent = new Intent(Book.this, Cloud.class);
                        startActivity(cloudIntent);
                        break;
                    case "Cyber Security":
                        Intent cyberIntent = new Intent(Book.this, cyber.class);
                        startActivity(cyberIntent);
                        break;
                    case "C++ Programmings":
                        Intent cppIntent = new Intent(Book.this, cprogram.class);
                        startActivity(cppIntent);
                        break;
                    default:
                        Toast.makeText(Book.this, "Product detail not available", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerViewProducts.setLayoutManager(layoutManager);
        recyclerViewProducts.setAdapter(adapter);
    }
    private List<Product> getProductList() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(R.drawable.calculas, "Calculas", "$100.00"));
        productList.add(new Product(R.drawable.cloud, "Cloud Computing", "$150.00"));
        productList.add(new Product(R.drawable.cyber, "Cyber Security", "$200.00"));
        productList.add(new Product(R.drawable.cprogram, "C++ Programmings", "$200.00"));
        return productList;
    }
}
