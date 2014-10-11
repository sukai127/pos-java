package com.thoughtworks.iamcoach.pos;

import org.junit.Test;

import java.io.IOException;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

public class BarcodeScannerTest {

    @Test
    public void should_get_a_product_when_input_an_barcode() throws IOException {

        BarcodeScanner barcodeScanner = new BarcodeScanner();
        String barcode = "ITEM000001";
        Product product = barcodeScanner.getProduct(barcode);

        assertThat(product.getName()).isEqualTo("雪碧");
        assertEquals(product.getName(),"雪碧");
    }
}
