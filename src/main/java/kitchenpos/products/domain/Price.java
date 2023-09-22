package kitchenpos.products.domain;

import javax.persistence.Embeddable;
import java.math.BigDecimal;
import java.util.Objects;

@Embeddable
public class Price {
    private BigDecimal price;

    protected Price() {
    }

    public Price(Long price) {
        if (price == null || price < 0) {
            throw new IllegalArgumentException(String.format("가격은 0원 이상이어야 합니다. 현재 값: %s", price));
        }
        this.price = new BigDecimal(price);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price1 = (Price) o;
        return Objects.equals(price, price1.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price);
    }

    public long longValue() {
        return price.longValue();
    }
}
