import java.util.Objects;

class Address {
    private String country;
    private String city;

    public Address(String country, String city) {
        this.country = country.toLowerCase();
        this.city = city.toLowerCase();
    }

    // Переопределяем equals и hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return country.equals(address.country) && city.equals(address.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, city);
    }
}