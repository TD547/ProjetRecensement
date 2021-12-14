package fr.epsi.b3.recensement.ClassesPourInfos;

public class Region {
    private int code;
    private int popu;
    private String nom;

    public Region(int code, int popu, String nom) {
        this.code = code;
        this.popu = popu;
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Region{" +
                "code='" + code + '\'' +
                ", popu=" + popu +
                ", nom='" + nom + '\'' +
                '}';
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getPopu() {
        return popu;
    }

    public void setPopu(int popu) {
        this.popu = popu;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
