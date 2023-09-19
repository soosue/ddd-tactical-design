package kitchenpos.menus.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import kitchenpos.menus.domain.Menu;
import kitchenpos.menus.domain.MenuGroup;
import kitchenpos.menus.domain.MenuProduct;
import kitchenpos.products.domain.Product;

public class MenuFixture {
    private final Menu menu;

    public MenuFixture() {
        menu = new Menu();
        menu.setId(UUID.randomUUID());
        menu.setName("내일의 치킨");
        menu.setPrice(new BigDecimal(15000));
    }

    public static MenuFixture builder() {
        return new MenuFixture();
    }

    public static MenuFixture builder(MenuGroup menuGroup) {
        return builder()
                .menuGroup(menuGroup)
                .price(1000L)
                .displayed(true);
    }

    public static MenuFixture builder(MenuGroup menuGroup, Product product) {
        return builder(menuGroup)
                .menuProducts(List.of(MenuProductFixture.builder(product).build()));
    }

    public MenuFixture name(String name) {
        menu.setName(name);
        return this;
    }

    public MenuFixture price(BigDecimal price) {
        menu.setPrice(price);
        return this;
    }

    public MenuFixture price(long price) {
        return price(new BigDecimal(price));
    }

    public MenuFixture menuGroup(MenuGroup menuGroup) {
        menu.setMenuGroup(menuGroup);
        if (menuGroup != null) {
            menu.setMenuGroupId(menuGroup.getId());
        }
        return this;
    }

    public MenuFixture menuProduct(MenuProduct menuProduct) {
        menu.setMenuProducts(List.of(menuProduct));
        return this;
    }

    public MenuFixture menuProducts(List<MenuProduct> menuProducts) {
        menu.setMenuProducts(menuProducts);
        return this;
    }

    public MenuFixture displayed(boolean displayed) {
        menu.setDisplayed(displayed);
        return this;
    }

    public Menu build() {
        return menu;
    }
}
