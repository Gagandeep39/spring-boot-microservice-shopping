/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-04-22 22:58:19
 * @modify date 2020-04-22 22:58:19
 * @desc Shopping cart to add products
 */
package com.gagan.shoppingcartservice.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * @OneToOne unidirectional mapping with user
 */
@Entity
@Table(name = "shopping_cart")
public class ShoppingCart {

    @Id
    @Column(name = "cart_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer cartId;
    @Column(name = "cart_status")
    private String status;

    /**
     * **NOTE: Do not use Cascade type.Persist (It implies cascade save)
     */
    @OneToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH })
    @JoinColumn(name = "username")
    private Customer customer;

    @ManyToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH} )
	@JoinTable(
			name = "cart_product",
			joinColumns = @JoinColumn(name = "cart_id"),
			inverseJoinColumns = @JoinColumn(name = "product_id")
            )
    private List<Product> products;

    public ShoppingCart() {

    }


    public void addProductToCart(Product product){
        if(products == null)
            products = new ArrayList<>();
        products.add(product);
    }

    public Integer getCartId() {
        return this.cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Product> getProducts() {
        return this.products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }


    public ShoppingCart(Customer customer) {
        this.customer = customer;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }




    @Override
    public String toString() {
        return "{" +
            " cartId='" + getCartId() + "'" +
            ", status='" + getStatus() + "'" +
            ", customer='" + getCustomer() + "'" +
            "}";
    }


}