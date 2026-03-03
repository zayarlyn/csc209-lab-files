class Fraction {
    private int nume, deno = 0; // assuming only whole num fraction
    
    Fraction(int nume, int deno) {
        this.nume = nume;
        this.deno = deno;
    }
    
    Fraction() {
        this.nume = 1;
        this.deno = 1;
    }
    
    int getNume() {
        return this.nume;
    }
    
    int getDeno() {
        return this.deno;
    }

    Fraction add(int nume, int deno) {
        return this.addOrSubtract(nume, deno, true);
    }
    
    Fraction add(Fraction fr) {
        return this.add(fr.getNume(), fr.getDeno());
    }
    
    Fraction subtract(int nume, int deno) {
        return this.addOrSubtract(nume, deno, false);
    }
    
    Fraction subtract(Fraction fr) {
        return this.subtract(fr.getNume(), fr.getDeno());
    }
    
    private Fraction addOrSubtract(int nume, int deno, boolean shouldAdd) {
        int maxDeno = Math.max(this.deno, deno);
        int leftNume = maxDeno == this.deno ? this.nume : this.nume * deno;
        int rightNume = maxDeno == deno ? nume : nume * this.deno;
        this.nume =  leftNume + (shouldAdd ? rightNume : -rightNume);
        this.deno = this.deno == deno ? deno : this.deno * deno;
        this.reduce();
        return this;
    }
    
    Fraction multiply(int nume, int deno) {
        this.deno *= deno;
        this.nume *= nume;
        this.reduce();
        return this;
    }
    
    Fraction multiply(Fraction fr) {
        return this.multiply(fr.getNume(), fr.getDeno());
    }
    
    Fraction divide(int nume, int deno) {
        this.nume *= deno;
        this.deno *= nume;
        this.reduce();
        return this;
    }
    
    Fraction divide(Fraction fr) {
        return this.divide(fr.getNume(), fr.getDeno());
    }
    
    private void reduce() {
        int gcd = this.getGcd(this.nume, this.deno);
        this.nume /= gcd;
        this.deno /= gcd;
    }
    
    private int getGcd(int n, int m) {
        int larger = Math.max(n, m), smaller = Math.min(n, m);
        
        while (larger % smaller != 0) {
            int tmp = smaller;
            smaller = larger % smaller;
            larger = tmp;
        }
        
        return smaller;
    }
    
    public String toString() {
        return this.nume + "/" + this.deno;
    }
}
