public class Zamowienie {
    private int id;
    private Klient klient;
    private Produkt[] produkty;
    private int[] ilosci;
    private String dataZamowienia;
    private String status;

    public Zamowienie(int id, Klient klient, Produkt[] produkty, int[] ilosci) {
        this.id = id;
        this.klient = klient;
        this.produkty = produkty;
        this.ilosci = ilosci;
        this.dataZamowienia = dataZamowienia;
        this.status = "Nowe";
    }

    public int getId() {
        return id;
    }

    public Klient getKlient() {
        return klient;
    }

    public void setKlient(Klient klient) {
        this.klient = klient;
    }

    public Produkt[] getProdukty() {
        return produkty;
    }

    public void setProdukty(Produkt[] produkty) {
        this.produkty = produkty;
    }

    public int[] getIlosci() {
        return ilosci;
    }

    public void setIlosci(int[] ilosci) {
        this.ilosci = ilosci;
    }

    public String getDataZamowienia() {
        return dataZamowienia;
    }

    public void setDataZamowienia(String dataZamowienia) {
        this.dataZamowienia = dataZamowienia;
    }

    public String getStatus() {
        return status;
    }

    public double obliczWartoscZamowienia() {
        double suma = 0;
        for (int i = 0; i < produkty.length; i++) {
            suma += produkty[i].getCena() * ilosci[i];
        }
        return suma;
    }

    public void zastosujZnizke() {
        if (klient.isCzyStaly()) {
            double suma = obliczWartoscZamowienia();
            System.out.println("Zastosowano zniżkę 10%. Nowa wartość: " + (suma * 0.9));
        }
    }

    public void wyswietlSzczegoly() {
        System.out.println("Zamówienie ID: " + id + ", Klient: " + klient.getImie() + " " + klient.getNazwisko());
        System.out.println("Status: " + status + ", Data: " + dataZamowienia);
        System.out.println("Produkty:");
        for (int i = 0; i < produkty.length; i++) {
            System.out.println("  - " + produkty[i].getNazwa() + " (x" + ilosci[i] + ")");
        }
        System.out.println("Łączna wartość: " + obliczWartoscZamowienia());
    }

    public void setStatus(String status) { this.status = status; }
}
