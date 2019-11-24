package ohtu.intjoukkosovellus;

import java.util.HashSet;

public class IntJoukko {

    private HashSet<Integer> lukujoukko;

    public IntJoukko() {
        this.lukujoukko = new HashSet<>();
    }

    public IntJoukko(HashSet<Integer> joukko) {
        this.lukujoukko = joukko;
    }

    public IntJoukko(int kapasiteetti) {
        lukujoukko = new HashSet<>();
    }

    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        lukujoukko = new HashSet<>();
    }

    public boolean lisaa(int luku) {
        if (lukujoukko.contains(luku)) {
            return false;
        }
        lukujoukko.add(luku);
        return true;
    }

    public boolean kuuluu(int luku) {
        return this.lukujoukko.contains(luku);
    }

    public boolean poista(int luku) {
        if (lukujoukko.contains(luku)) {
            lukujoukko.remove(luku);
            return true;
        }
        return false;
    }

    public int mahtavuus() {
        return lukujoukko.size();
    }

    @Override
    public String toString() {
        String palautettava = "{";
        if (!lukujoukko.isEmpty()) {
            int[] lukuTaulukko = toIntArray();
            if (lukujoukko.size() == 1) {
                palautettava = palautettava + lukuTaulukko[0];
            } else {
                for (int i = 0; i < lukujoukko.size() - 1; i++) {
                    palautettava = palautettava + lukuTaulukko[i] + ", ";
                }
                palautettava = palautettava + lukuTaulukko[lukuTaulukko.length - 1];
            }
        }
        palautettava = palautettava + "}";
        return palautettava;
    }

    public int[] toIntArray() {
        int[] lukuTaulukko = new int[lukujoukko.size()];
        int indeksi = lukuTaulukko.length - 1;
        for (Integer luku : lukujoukko) {
            lukuTaulukko[indeksi] = luku;
            indeksi--;
        }
        return lukuTaulukko;
    }

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        HashSet<Integer> yhdiste = new HashSet<>();
        yhdiste.addAll(a.getLukujoukko());
        yhdiste.addAll(b.getLukujoukko());
        return new IntJoukko(yhdiste);
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        HashSet<Integer> leikkaus = a.getLukujoukko();
        leikkaus.retainAll(b.getLukujoukko());
        return new IntJoukko(leikkaus);
    }

    public static IntJoukko erotus(IntJoukko a, IntJoukko b) {
        HashSet<Integer> erotus = new HashSet<>();
        HashSet<Integer> joukkoA = a.getLukujoukko();
        HashSet<Integer> poistettava = b.getLukujoukko();
        for (Integer luku : joukkoA) {
            if (!poistettava.contains(luku)) {
                erotus.add(luku);
            }
        }
        return new IntJoukko(erotus);
    }

    public HashSet getLukujoukko() {
        return this.lukujoukko;
    }

}
