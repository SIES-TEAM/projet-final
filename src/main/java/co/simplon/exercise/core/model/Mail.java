package co.simplon.exercise.core.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Mail implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String fromAddress;

    private Date createdAt;

    @Column(name = "treated", nullable = false, columnDefinition = "int default 0")
    private Integer treated;

    private Date treatedAt;

    @Column(name = "subject")
    private String subject;

    @Column(name = "body", nullable = false)
    private String msgBody;

    public Mail() {
        super();
    }

    public Mail(String fromAddress, Date createdAt, Integer treated, Date treatedAt, String subject, String msgBody) {
        this.fromAddress = fromAddress;
        this.createdAt = createdAt;
        this.treated = treated;
        this.treatedAt = treatedAt;
        this.subject = subject;
        this.msgBody = msgBody;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getTreated() {
        return treated;
    }

    public void setTreated(Integer treated) {
        this.treated = treated;
    }

    public Date getTreatedAt() {
        return treatedAt;
    }

    public void setTreatedAt(Date treatedAt) {
        this.treatedAt = treatedAt;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMsgBody() {
        return msgBody;
    }

    public void setMsgBody(String msgBody) {
        this.msgBody = msgBody;
    }
}

