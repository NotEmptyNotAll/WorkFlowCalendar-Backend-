package com.kryha.springjwt.payload.response;

public class TestResponse {

    private String categ;
    private String product;
    private String att;

    public TestResponse() {
    }

    public TestResponse(String categ, String product, String att) {
        this.categ = categ;
        this.product = product;
        this.att = att;
    }

    public String getCateg() {
        return categ;
    }

    public void setCateg(String categ) {
        this.categ = categ;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getAtt() {
        return att;
    }

    public void setAtt(String att) {
        this.att = att;
    }
}
