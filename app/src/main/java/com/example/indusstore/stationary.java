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
public class stationary extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stationary);
        RecyclerView recyclerViewProducts = findViewById(R.id.recyclerViewProducts);
        List<Product> productList = getProductList();
        ProductAdapter adapter = new ProductAdapter(this, productList);
        adapter.setOnItemClickListener(new ProductAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Product clickedProduct = productList.get(position);
                switch (clickedProduct.getName()) {
                    case "Calculator":
                        Intent calculatorIntent = new Intent(stationary.this, Calculator.class);
                        startActivity(calculatorIntent);
                        break;
                    case "Drafter":
                        Intent drafterIntent = new Intent(stationary.this, Drafter.class);
                        startActivity(drafterIntent);
                        break;
                    case "geometry":
                        Intent geometryIntent = new Intent(stationary.this, geometry.class);
                        startActivity(geometryIntent);
                        break;
                    case "file":
                        Intent fileIntent = new Intent(stationary.this, files.class);
                        startActivity(fileIntent);
                        break;
                    default:
                        Toast.makeText(stationary.this, "Product detail not available", Toast.LENGTH_SHORT).show();
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
        productList.add(new Product(R.drawable.calculator, "Calculator", "$10.00"));
        productList.add(new Product(R.drawable.drafter, "Drafter", "$15.00"));
        productList.add(new Product(R.drawable.geometry, "geometry", "$20.00"));
        productList.add(new Product(R.drawable.file, "file", "$20.00"));
        return productList;
    }
}
