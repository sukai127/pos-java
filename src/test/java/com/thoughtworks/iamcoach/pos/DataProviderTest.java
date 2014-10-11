package com.thoughtworks.iamcoach.pos;

import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class DataProviderTest {
    @Test
    public void should_return_an_product_object(){

        DataProvider dp = new DataProvider();
        String str = "ITEM000005,方便面,袋,4.50";

        Product product = dp.buildProduct(str);
        assertThat(product.getName()).isEqualTo("方便面");
    }
}
