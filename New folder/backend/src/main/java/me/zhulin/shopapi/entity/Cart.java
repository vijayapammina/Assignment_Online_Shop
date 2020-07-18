package me.zhulin.shopapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created By Zhu Lin on 1/2/2019.
 */
@Data
@Entity
//@NoArgsConstructor
public class Cart implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 3729573448259843945L;

	@Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long cartId;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JsonIgnore
//    @JoinColumn(name = "email", referencedColumnName = "email")
    private User user;
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, orphanRemoval = true,
            mappedBy = "cart")
    private Set<ProductInOrder> products = new HashSet<>();

    @Override
    public String toString() {
        return "Cart{" +
                "cartId=" + cartId +
                ", products=" + products +
                '}';
    }
    public Cart(User user) {
        this.user  = user;
    }
	public long getCartId() {
		return cartId;
	}
	public void setCartId(long cartId) {
		this.cartId = cartId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public Set<ProductInOrder> getProducts() {
		return products;
	}

	public void setProducts(Set<ProductInOrder> products) {
		this.products = products;
	}
	/*
	 * public Cart(@NotNull long cartId, User user, Set<ProductInOrder> products) {
	 * super(); this.cartId = cartId; this.user = user; this.products = products; }
	 */
	public Cart() {
		super();
	}
	

    

}
