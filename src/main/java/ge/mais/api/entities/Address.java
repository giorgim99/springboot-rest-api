package ge.mais.api.entities;
import jakarta.persistence.*;

@Entity
@Table(name="address")
public class Address {

    @Id
    @SequenceGenerator(name="address_address_iq_seq", sequenceName = "address_address_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_address_iq_seq")
    @Column(name="address_id")
    private Long id;

    @Column(name="address")
    private String address;
    @Column(name="postal_code")
    private String postalCode;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="city_id")
    private City city;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
