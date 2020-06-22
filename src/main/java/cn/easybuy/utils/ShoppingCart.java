package cn.easybuy.utils;

import cn.easybuy.pojo.Product;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ShoppingCart implements Serializable {
    public List<ShoppingCartItem> items = new ArrayList<ShoppingCartItem>();
    private Double sum = (double) 0;

    //获取购物车中所有商品
    public List<ShoppingCartItem> getItems() {
        return items;
    }

    //添加一项
    public ReturnResult addItem(Product product, Integer quantity) {
        ReturnResult result = new ReturnResult();
        int flag = 0;
        for (int i = 0; i < items.size(); i++) {
            //判断购物车中是否已有此商品，如果有则累计数量
            if ((items.get(i).getProduct().getId()).equals(product.getId())) {
                if (items.get(i).getQuantity() + quantity > product.getStock()) {
                    return result.returnFail("商品数量不足");
                } else {
                    items.get(i).setQuantity(items.get(i).getQuantity() + quantity);
                    flag = 1;
                }
            }
        }
        if (quantity > product.getStock()) {
            return result.returnFail("商品数量不足");
        }
        if (flag == 0) {
            items.add(new ShoppingCartItem(product, quantity));
        }
        return result.returnSuccess();
    }

    //移除一项
    public void removeItem(Integer entityId) {
        items.removeIf(new Predicate<ShoppingCartItem>() {
            @Override
            public boolean test(ShoppingCartItem shoppingCartItem) {
                return shoppingCartItem.getProduct().getId().equals(entityId);
            }
        });
    }

    //修改数量
    public void modifyQuantity(Integer entityId, Integer quantity) {
        for (ShoppingCartItem item : items) {
            if (item.getProduct().getId().equals(entityId)) {
                item.setQuantity(quantity);
                break;
            }
        }
    }

    //计算总价格
    public float getTotalCost() {
        float sum = 0;
        for (ShoppingCartItem item : items) {
            sum = sum + item.getCost();
        }
        return sum;
    }

    public void setItems(List<ShoppingCartItem> items) {
        this.items = items;
    }

    public Double getSum() {
        return (double) getTotalCost();
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }
}
