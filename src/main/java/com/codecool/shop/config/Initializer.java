package com.codecool.shop.config;

import com.codecool.shop.dao.*;
import com.codecool.shop.dao.implementation.*;
import com.codecool.shop.dao.sql.ProductCategoryDaoJDBC;
import com.codecool.shop.dao.sql.ProductDaoJDBC;
import com.codecool.shop.dao.sql.SupplierDaoJDBC;
import com.codecool.shop.model.Cart;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.SQLException;

@WebListener
public class Initializer implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ProductDao productDataStore = new ProductDaoJDBC();
        ProductCategoryDao productCategoryDataStore = new ProductCategoryDaoJDBC();
        SupplierDao supplierDataStore = new SupplierDaoJDBC();
        CartDao cartDao = CartDaoMem.getInstance();
//        OrderDao orderDao = OrderDaoMem.getInstance();

        //setting up a new supplier
        Supplier kiniCosmetics = new Supplier("Kini Cosmetics", "Kini Cosmetics");
        supplierDataStore.add(kiniCosmetics);
        Supplier lush = new Supplier("Lush", "Lush");
        supplierDataStore.add(lush);
        Supplier theSoapShop = new Supplier("The Soap Shop", "The Soap Shop");
        supplierDataStore.add(theSoapShop);

        //setting up a new product category
        ProductCategory soap = new ProductCategory("Soap", "Soap", "Soap");
        productCategoryDataStore.add(soap);
        ProductCategory candle = new ProductCategory("Candle", "Candle", "Candle");
        productCategoryDataStore.add(candle);
        ProductCategory bathBomb = new ProductCategory("Bath Bomb", "Bath Bomb", "Bath Bomb");
        productCategoryDataStore.add(bathBomb);

        //setting up products and printing it
        productDataStore.add(new Product("Orange Delight", 5.49f, "USD", "Homemade soap", soap, kiniCosmetics));
        productDataStore.add(new Product("Calmness", 4.99f, "USD", "Homemade soap", soap, kiniCosmetics));
        productDataStore.add(new Product("Java Blossom", 3.99f, "USD", "Homemade soap", soap, kiniCosmetics));
        productDataStore.add(new Product("Honey Moon", 4.99f, "USD", "Homemade soap", soap, kiniCosmetics));
        productDataStore.add(new Product("Hazelnut Tree", 4.49f, "USD", "Homemade soap", soap, lush));
        productDataStore.add(new Product("Banana Split", 4.99f, "USD", "Homemade soap", soap, lush));
        productDataStore.add(new Product("Starry Night", 5.99f, "USD", "Homemade soap", soap, lush));
        productDataStore.add(new Product("Holy Guacamole", 5.99f, "USD", "Homemade soap", soap, theSoapShop));
        productDataStore.add(new Product("Unicorn Days", 4.99f, "USD", "Homemade soap", soap, theSoapShop));
        productDataStore.add(new Product("Queen Bee", 7.49f, "USD", "Homemade soap", soap, theSoapShop));
        productDataStore.add(new Product("Summer Wine", 7.99f, "USD", "Homemade candle", candle, lush));
        productDataStore.add(new Product("Petal Harmony", 8.99f, "USD", "Homemade candle", candle, lush));
        productDataStore.add(new Product("Ruby Rose", 7.99f, "USD", "Homemade candle", candle, theSoapShop));
        productDataStore.add(new Product("Cinnamon Rolls", 7.99f, "USD", "Homemade candle", candle, theSoapShop));
        productDataStore.add(new Product("English Rose", 9.49f, "USD", "Homemade candle", candle, theSoapShop));
        productDataStore.add(new Product("Purple Rain", 8.49f, "USD", "Homemade candle", candle, kiniCosmetics));
        productDataStore.add(new Product("Cappuccino Dream", 2.49f, "USD", "Homemade bath bomb", bathBomb, theSoapShop));
        productDataStore.add(new Product("Fluffy Marshmallow", 1.99f, "USD", "Homemade bath bomb", bathBomb, theSoapShop));
        productDataStore.add(new Product("Fizzy Lemonade", 3.49f, "USD", "Homemade bath bomb", bathBomb, lush));
        productDataStore.add(new Product("Crazy Watermelon", 2.49f, "USD", "Homemade bath bomb", bathBomb, lush));
        productDataStore.add(new Product("Pokeball", 2.99f, "USD", "Homemade bath bomb", bathBomb, kiniCosmetics));


        //setting up the cart
        cartDao.add(new Cart(1));

    }
}
