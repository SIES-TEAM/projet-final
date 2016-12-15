package co.simplon.exercise.core.model;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;


@Entity
public class PasswordChangeToken {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String token;
    private Date expiryDate;

    @ManyToOne(cascade = { CascadeType.MERGE }, targetEntity = User.class)
    @JoinColumn(name = "userid")
    private User user;
    
    
    @Transient
    private static SecureRandom secureRandom;

    private static SecureRandom getSecureRandom() {
        if( secureRandom == null ) secureRandom = new SecureRandom();
        return secureRandom;
    }

    public PasswordChangeToken() {}

    public PasswordChangeToken(User user) {
        this.token = new BigInteger(130, getSecureRandom()).toString(32);
        this.expiryDate = new Date();
        this.user = user;
    }

	public PasswordChangeToken( String token, Date expiryDate, User user) {
		super();
		this.token = token;
		this.expiryDate = expiryDate;
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}


	public Date getExpiryDate() {
		return expiryDate;
	}

	public User getUser() {
		return user;
	}
	
}

    
    

