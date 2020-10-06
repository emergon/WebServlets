package emergon.entity;

import java.util.Objects;

public class Product {
    private int pcode;
    private String pdescr;
    private double pprice;

    public Product() {
    }

    public Product(int pcode, String pdescr, double pprice) {
        this.pcode = pcode;
        this.pdescr = pdescr;
        this.pprice = pprice;
    }

    public int getPcode() {
        return pcode;
    }

    public void setPcode(int pcode) {
        this.pcode = pcode;
    }

    public String getPdescr() {
        return pdescr;
    }

    public void setPdescr(String pdescr) {
        this.pdescr = pdescr;
    }

    public double getPprice() {
        return pprice;
    }

    public void setPprice(double pprice) {
        this.pprice = pprice;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.pcode;
        hash = 23 * hash + Objects.hashCode(this.pdescr);
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.pprice) ^ (Double.doubleToLongBits(this.pprice) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Product other = (Product) obj;
        if (this.pcode != other.pcode) {
            return false;
        }
        if (Double.doubleToLongBits(this.pprice) != Double.doubleToLongBits(other.pprice)) {
            return false;
        }
        if (!Objects.equals(this.pdescr, other.pdescr)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Product{" + "pcode=" + pcode + ", pdescr=" + pdescr + ", pprice=" + pprice + '}';
    }
    
    
}
