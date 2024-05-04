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
public class Help extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        RecyclerView recyclerViewProducts = findViewById(R.id.recyclerViewProducts);
        List<Product> productList = getProductList();
        ProductAdapter adapter = new ProductAdapter(this, productList);
        adapter.setOnItemClickListener(new ProductAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Product clickedProduct = productList.get(position);
                switch (clickedProduct.getName()) {
                    case "Assigments":
                        Intent assignmentsIntent = new Intent(Help.this, assigment.class);
                        startActivity(assignmentsIntent);
                        break;
                    case "Printer":
                        Intent printerIntent = new Intent(Help.this, printer.class);
                        startActivity(printerIntent);
                        break;
                    default:
                        Toast.makeText(Help.this, "Product detail not available", Toast.LENGTH_SHORT).show();
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
        productList.add(new Product(R.drawable.assigment, "Assigments", "$100.00"));
        productList.add(new Product(R.drawable.printer, "Printer", "$150.00"));
        return productList;
    }
}
