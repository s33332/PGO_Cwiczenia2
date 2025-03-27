import java.util.ArrayList;
import java.util.List;

public class SklepKomputerowy {
    private List<Produkt> produkty = new ArrayList<>();
    private List<Klient> klienci = new ArrayList<>();
    private List<Zamowienie> zamowienia = new ArrayList<>();
    private int liczbaZamowien = 1;

    public void dodajProdukt(Produkt produkt) {
        produkty.add(produkt);
    }

    public void dodajKlienta(Klient klient) {
        klienci.add(klient);
    }

    public Zamowienie utworzZamowienie(Klient klient, Produkt[] produkty, int[] ilosci) {
        Zamowienie zamowienie = new Zamowienie(liczbaZamowien++, klient, produkty, ilosci);
        zamowienia.add(zamowienie);
        return zamowienie;
    }

    public void aktualizujStanMagazynowy(Zamowienie zamowienie) {
        for (int i = 0; i < zamowienie.getProdukty().length; i++) {
            Produkt produkt = zamowienie.getProdukty()[i];
            int nowaIlosc = produkt.getIloscWMagazynie() - zamowienie.getIlosci()[i];
            produkt.setIloscWMagazynie(nowaIlosc);
        }
    }

    public void zmienStatusZamowienia(int idZamowienia, String nowyStatus) {
        for (Zamowienie z : zamowienia) {
            if (z.getId() == idZamowienia) {
                z.setStatus(nowyStatus);
                break;
            }
        }
    }

    public void wyswietlProduktyWKategorii(String kategoria) {
        System.out.println("Produkty w kategorii: " + kategoria);
        for (Produkt p : produkty) {
            if (p.getKategoria().equalsIgnoreCase(kategoria)) {
                p.wyswietlInformacje();
            }
        }
    }

    public void wyswietlZamowieniaKlienta(int idKlienta) {
        System.out.println("Zamówienia klienta o ID " + idKlienta + ":");
        for (Zamowienie z : zamowienia) {
            if (z.getKlient().getId() == idKlienta) {
                z.wyswietlSzczegoly();
            }
        }
    }
    }