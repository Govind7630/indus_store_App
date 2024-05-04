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
public class Projects extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projects);
        RecyclerView recyclerViewProducts = findViewById(R.id.recyclerViewProducts);
        List<Product> productList = getProductList();
        ProductAdapter adapter = new ProductAdapter(this, productList);
        adapter.setOnItemClickListener(new ProductAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Product clickedProduct = productList.get(position);
                switch (clickedProduct.getName()) {
                    case "MAD Project":
                        Intent calculatorIntent = new Intent(Projects.this, mad.class);
                        startActivity(calculatorIntent);
                        break;
                    case "Electrical Project":
                        Intent drafterIntent = new Intent(Projects.this, electrical.class);
                        startActivity(drafterIntent);
                        break;
                    case "Mechanical Project":
                        Intent geometryIntent = new Intent(Projects.this, Clock.class);
                        startActivity(geometryIntent);
                        break;
                    case "civil Project":
                        Intent fileIntent = new Intent(Projects.this, civil.class);
                        startActivity(fileIntent);
                        break;
                    default:
                        Toast.makeText(Projects.this, "Product detail not available", Toast.LENGTH_SHORT).show();
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
        productList.add(new Product(R.drawable.madimg, "MAD Project", "$100.00"));
        productList.add(new Product(R.drawable.electrical, "Electrical Project", "$150.00"));
        productList.add(new Product(R.drawable.clock, "Mechanical Project", "$200.00"));
        productList.add(new Product(R.drawable.civil, "civil Project", "$200.00"));
        return productList;
    }
}
