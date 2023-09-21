package kitchenpos.menus.tobe.domain;

import kitchenpos.menus.domain.MenuDisplayPolicy;
import kitchenpos.menus.domain.MenuPricePolicy;
import org.junit.jupiter.api.Test;

class MenuDisplayPolicyTest {
    private final MenuPricePolicy menuPricePolicy = new MenuPricePolicy();
    private final MenuDisplayPolicy menuDisplayPolicy = new MenuDisplayPolicy(menuPricePolicy);

    //- `Product`의 `Change the Price`가 일어났을 때, 메뉴가격정책을 만족하지 못한 메뉴는 숨겨진다
    @Test
    void name() {
        menuDisplayPolicy.follow();
    }
}
